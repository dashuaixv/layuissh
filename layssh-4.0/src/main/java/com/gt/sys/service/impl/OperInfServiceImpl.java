package com.gt.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.gt.model.TSysInsInf;
import com.gt.model.TSysOperInf;
import com.gt.model.TSysRoleInf;
import com.gt.model.TSysRoleOper;
import com.gt.pageModel.DatagridForLayUI;
import com.gt.pageModel.Json;
import com.gt.pageModel.OperInf;
import com.gt.pageModel.RoleOper;
import com.gt.sys.service.IDictCdService;
import com.gt.sys.service.IInsInfService;
import com.gt.sys.service.IOperInfService;
import com.gt.sys.service.IRoleInfService;
import com.gt.sys.service.IRoleOperService;
import com.gt.utils.Contans;
import com.gt.utils.MD5;
import com.gt.utils.MapToBeanUtils;
import com.gt.utils.PbUtils;
import org.springframework.transaction.annotation.*;

/**
 * @功能说明：系统用户
 * @作者： herun
 * @创建日期：2015-09-23
 * @版本号：V1.0
 */
@Service("operInfService")
public class OperInfServiceImpl extends BaseServiceImpl<TSysOperInf> implements IOperInfService {

    private IDictCdService dictCdService;// 数据字典

    private IRoleInfService roleInfService;// 用户角色

    private IInsInfService insInfService;// 机构信息

    private IRoleOperService roleOperService;// 角色人员

    public IRoleOperService getRoleOperService() {
        return roleOperService;
    }

    @Autowired
    public void setRoleOperService(IRoleOperService roleOperService) {
        this.roleOperService = roleOperService;
    }

    public IRoleInfService getRoleInfService() {
        return roleInfService;
    }

    @Autowired
    public void setRoleInfService(IRoleInfService roleInfService) {
        this.roleInfService = roleInfService;
    }

    public IInsInfService getInsInfService() {
        return insInfService;
    }

    @Autowired
    public void setInsInfService(IInsInfService insInfService) {
        this.insInfService = insInfService;
    }

    public IDictCdService getDictCdService() {
        return dictCdService;
    }

    @Autowired
    public void setDictCdService(IDictCdService dictCdService) {
        this.dictCdService = dictCdService;
    }

    @Override
    public DatagridForLayUI datagrid(OperInf operInf, String writeOperInsCd, boolean v) throws Exception {
        DatagridForLayUI grid = new DatagridForLayUI();

        String sqlleft = "select * from ( select a.oper_cd as operCd, a.job, a.oper_Nm, a.email,  b.INS_DETAIL_NOT_MY ,  a.oper_nm as operNm,  a.oper_st as operSt,  a.telephone, a.ins_cd as insCd, b.ins_nm as insCdNm ,xs.DICT_NM as operStNm,f.DICT_NM as jobNm ";
        sqlleft += " ,GROUP_CONCAT(DISTINCT(c.ROLE_CD)) as roleCd,GROUP_CONCAT(DISTINCT(d.ROLE_NM)) as roleCdNm";
        String sql = " from t_sys_oper_inf a ";
        sql += "	LEFT JOIN t_sys_ins_inf b ON a.ins_cd=b.uuid ";
        sql += " left JOIN T_SYS_ROLE_OPER c ON a.OPER_CD=c.OPER_CD ";
        sql += "	left JOIN T_SYS_ROLE_INF d ON c.ROLE_CD=d.ROLE_CD ";
        sql += " left join t_sys_dict_cd  xs on a.oper_st=xs.dict_cd";
        sql += " and xs.dict_type_cd='oper_st' ";
        sql += " left join t_sys_dict_cd  f on a.job=f.dict_cd";
        sql += " and f.dict_type_cd='job_tp' ";
        sql += "  ) as a where 1=1 ";

        Map<String, Object> param = new HashMap<String, Object>();

        // 用户代码
        if (!PbUtils.isEmpty(operInf.getOperCd())) {
            sql += " and a.operCd like:operCd";
            param.put("operCd", "%%" + operInf.getOperCd() + "%%");
        }
        // 机构编号
        if (!PbUtils.isEmpty(operInf.getInsCd())) {
            sql += " and a.ins_Cd =:insCd";
            param.put("insCd", operInf.getInsCd());
        }
        // 数据所属机构
        if (!PbUtils.isEmpty(writeOperInsCd)) {
            if (!v) {// 非超级管理
                // 查找所有下一级
                sql += " and (a.INS_DETAIL_NOT_MY like:insCd )";
                param.put("insCd", "%%" + writeOperInsCd + "%%");
            }
        }

        // 用户名称
        if (!PbUtils.isEmpty(operInf.getOperNm())) {
            sql += " and a.operNm like:operNm";
            param.put("operNm", "%%" + operInf.getOperNm() + "%%");
        }
        // 用户状态
        if (!PbUtils.isEmpty(operInf.getOperSt())) {
            sql += " and a.operSt =:operSt";
            param.put("operSt", operInf.getOperSt());
        }
        // 电话号码
        if (!PbUtils.isEmpty(operInf.getTelephone())) {
            sql += " and a.telephone like:telephone";
            param.put("telephone", "%%" + operInf.getTelephone() + "%%");
        }


        String totalSql = "   select count(*) from (" + sqlleft + sql + ") as a";


        if (!PbUtils.isEmpty(operInf.getSort())) {
            sql += " order by " + operInf.getSort() + "  " + operInf.getOrder();
        }

        List<Map> maps = findBySql(sqlleft + sql, param, operInf.getPage(), operInf.getLimit());

        Long total = countBySql(totalSql, param);
        grid.setCount(total);
        grid.setData(maps);

        return grid;
    }

    @Transactional
    @Override
    public OperInf add(OperInf inf) {
        TSysOperInf tInf = new TSysOperInf();
        BeanUtils.copyProperties(inf, tInf);

        // 用户所属机构
        if (!PbUtils.isEmpty(inf.getInsCd())) {
            TSysInsInf insInf = insInfService.getById(TSysInsInf.class, inf.getInsCd());
            if (insInf != null) {
                tInf.setTSysInsInf(insInf);
            }
        }

        save(tInf);

        // 用户所属角色
        if (!PbUtils.isEmpty(inf.getRoleCd())) {
            roleOperService.remove(inf.getOperCd());
            String[] rolseCds = inf.getRoleCd().split(",");
            for (int i = 0; i < rolseCds.length; i++) {
                RoleOper roleOper = new RoleOper();
                roleOper.setUuid(UUID.randomUUID().toString());
                roleOper.setOperCd(inf.getOperCd());
                roleOper.setRoleCd(rolseCds[i]);
                roleOperService.add(roleOper);
            }
        }

        // 设置返回对象
        BeanUtils.copyProperties(tInf, inf);

        return inf;
    }

    @Transactional
    @Override
    public void remove(String ids) {
        String[] nids = ids.split(",");
        String hql = "delete from TSysOperInf t where t.operCd in (";
        for (int i = 0; i < nids.length; i++) {
            if (i > 0) {
                hql += ",";
            }
            hql += "'" + nids[i] + "'";
        }
        hql += ")";
        executeHql(hql);

    }

    // 清空缓存
    @CacheEvict(value = {"MenuInfServiceImpl_getTreeByRole", "MenuInfServiceImpl_treegrid", "MenuInfServiceImpl_getTreeByRoleByNoSys"}, allEntries = true)
    @Transactional
    @Override
    public Json modify(OperInf inf) {
        Json j = new Json();

        TSysOperInf tInf = getById(TSysOperInf.class, inf.getOperCd());
        if (tInf == null) {
            j.setSuccess(false);
            j.setMsg("修改失败：找不到要修改的信息");
            return j;
        }

        // 旧对象
        OperInf oldObject = new OperInf();
        BeanUtils.copyProperties(tInf, oldObject);
        if (tInf.getTSysRoleInfs() != null) {
            String roleCds = "";
            for (TSysRoleInf tSysRoleOper : tInf.getTSysRoleInfs()) {
                if (!PbUtils.isEmpty(tSysRoleOper.getRoleCd())) {
                    roleCds += tSysRoleOper.getRoleCd();
                }
            }
            oldObject.setRoleCd(roleCds);

        }
        if (tInf.getTSysInsInf() != null) {
            if (PbUtils.isEmpty(tInf.getTSysInsInf().getInsCd())) {
                oldObject.setInsCd(tInf.getTSysInsInf().getInsCd());
            }
        }
        j.setOldObj(oldObject);

        BeanUtils.copyProperties(inf, tInf, new String[]{"operPwd", "operCd", "recCrtTs"});

        // 用户所属角色
        if (!PbUtils.isEmpty(inf.getRoleCd())) {
            roleOperService.remove(inf.getOperCd());
            String[] rolseCds = inf.getRoleCd().split(",");
            for (int i = 0; i < rolseCds.length; i++) {
                RoleOper roleOper = new RoleOper();
                roleOper.setUuid(UUID.randomUUID().toString());
                roleOper.setOperCd(inf.getOperCd());
                roleOper.setRoleCd(rolseCds[i]);
                roleOperService.add(roleOper);
            }
        }

        // 用户所属机构
        if (!PbUtils.isEmpty(inf.getInsCd())) {
            TSysInsInf insInf = insInfService.getById(TSysInsInf.class, inf.getInsCd());
            if (insInf != null) {
                tInf.setTSysInsInf(insInf);
            }
        }

        update(tInf);// 更新

        // 设置返回对象
        BeanUtils.copyProperties(tInf, inf);

        j.setSuccess(true);
        j.setMsg("更新成功");
        j.setObj(inf);
        return j;
    }

    @Override
    public Json verifyInfo(OperInf inf) {
        Json j = new Json();
        Map<String, Object> params = new HashMap<String, Object>();
        if (!PbUtils.isEmpty(inf.getOperCd())) {
            params.put("operCd", inf.getOperCd().trim());
        }
        Long total = super.count("Select count(*) from TSysOperInf t where t.operCd =:operCd ", params);

        if (total > 0) {
            j.setSuccess(false);
            j.setMsg("新增失败：用户名已经存在");
            return j;
        }

        j.setSuccess(true);
        j.setMsg("成功！");
        j.setObj(inf);
        return j;
    }

    @Transactional
    @Override
    public Json redoPwd(String operCd) {
        Json j = new Json();
        String pwd = null;

        TSysOperInf operInf = getById(TSysOperInf.class, operCd);
        if (operInf == null) {
            j.setMsg("密码重置失败：找不到要重置的用户信息");
        }

        MD5 md5 = new MD5();
        if (!PbUtils.isEmpty(operInf.getOperPwd())) {
            pwd = md5.getMD5Str(operInf.getOperCd() + Contans.DEFAULT_PASSWORD);// 系统默认密码,
            // 用户名+密码
        }

        String sql = "update t_sys_oper_inf set oper_pwd=:oper_pwd  where trim(oper_cd)=:oper_cd";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("oper_pwd", pwd);
        params.put("oper_cd", operCd.trim());
        executeSql(sql, params);

        j.setSuccess(true);
        j.setMsg("密码重置成功");
        return j;
    }

    @Override
    public Json userLogin(OperInf operInf) {

        Json j = new Json();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("operCd", operInf.getOperCd());// 用户名

        MD5 md5 = new MD5();
        String pwd = md5.getMD5Str(operInf.getOperCd() + operInf.getOperPwd());// MD5密码=用户名+密码
        params.put("operPwd", pwd);

        TSysOperInf TSysOperInf = getByHql("from TSysOperInf where operCd=:operCd and operPwd=:operPwd", params);
        if (TSysOperInf == null) {
            j.setSuccess(false);
            j.setMsg("用户名或者密码不正确");
            return j;
        }

        if (!PbUtils.isEmpty(TSysOperInf.getOperSt()) && TSysOperInf.getOperSt().equals(Contans.OPER_ST_NO)) {
            j.setSuccess(false);
            j.setMsg("该用户名处于禁用状态，禁止登录系统");
            return j;
        }

        if (!PbUtils.isEmpty(TSysOperInf.getOperSt()) && TSysOperInf.getOperSt().equals(Contans.OPER_ST_CANCEL)) {
            j.setSuccess(false);
            j.setMsg("该用户名处于注销用状态，禁止登录系统");
            return j;
        }

        j.setSuccess(true);
        return j;
    }


    @Transactional
    @Override
    public Json changepwd(OperInf operInf) {
        Json j = new Json();
        MD5 md5 = new MD5();
        String pwd = md5.getMD5Str(operInf.getOperCd() + operInf.getOperPwd());

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("oper_pwd", pwd);
        params.put("oper_cd", operInf.getOperCd());
        String sql = "update t_sys_oper_inf set oper_pwd=:oper_pwd where oper_cd=:oper_cd";
        executeSql(sql, params);

        j.setMsg("密码修改成功");
        j.setSuccess(true);
        return j;
    }

    @Override
    public List<OperInf> getList() {
        List<OperInf> l = new ArrayList<OperInf>();
        String hql = " from TSysOperInf t";
        List<TSysOperInf> tl = new ArrayList<TSysOperInf>();
        tl = find(hql);

        if (tl != null && tl.size() > 0) {
            for (TSysOperInf t : tl) {
                OperInf operInf = new OperInf();
                BeanUtils.copyProperties(t, operInf);
                l.add(operInf);
            }
        }
        return l;
    }
}
