package com.gt.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.model.TSysInsInf;
import com.gt.pageModel.DatagridForLayUI;
import com.gt.pageModel.InsInf;
import com.gt.pageModel.Json;
import com.gt.pageModel.TreeForLayUI;
import com.gt.pageModel.ZTree;
import com.gt.sys.service.IDictCdService;
import com.gt.sys.service.IInsInfService;
import com.gt.utils.Contans;
import com.gt.utils.PbUtils;
import org.springframework.transaction.annotation.*;

/**
 * @功能说明：机构信息
 * @作者： herun
 * @创建日期：2015-09-23
 * @版本号：V1.0
 */
@Service("insInfService")
public class InsInfServiceImpl extends BaseServiceImpl<TSysInsInf> implements IInsInfService {

    private IDictCdService dictCdService;// 数据字典

    public IDictCdService getDictCdService() {
        return dictCdService;
    }

    @Autowired
    public void setDictCdService(IDictCdService dictCdService) {
        this.dictCdService = dictCdService;
    }

    @Override
    public DatagridForLayUI datagrid(InsInf insInf, String insCd) {
        DatagridForLayUI grid = new DatagridForLayUI();
        String hql = " from TSysInsInf t where 1=1 ";
        Map<String, Object> param = new HashMap<String, Object>();

        // 机构编号
        if (!PbUtils.isEmpty(insInf.getInsCd())) {
            hql += " and t.insCd like:insCd";
            param.put("insCd", "%%" + insInf.getInsCd() + "%%");
        }
        // 上一级机构
        if (!PbUtils.isEmpty(insInf.getParentInsCd())) {
            hql += " and t.TSysInsInf.uuid =:parentInsCd";
            param.put("parentInsCd", insInf.getParentInsCd());
        }
        // 机构名称
        if (!PbUtils.isEmpty(insInf.getInsNm())) {
            hql += " and t.insNm like:insNm";
            param.put("insNm", "%%" + insInf.getInsNm() + "%%");
        }
        // 机构级别
        if (!PbUtils.isEmpty(insInf.getInsLvl())) {
            hql += " and t.insLvl =:insLvl";
            param.put("insLvl", insInf.getInsLvl());
        }
        // 数据所属机构
        if (!PbUtils.isEmpty(insCd)) {
            hql += " and t.insDetail like:insCd";
            param.put("insCd", "%%" + insCd + "%%");
        }
        String totalHql = "select count(*) " + hql;

        if (!PbUtils.isEmpty(insInf.getSort())) {
            hql += " order by " + insInf.getSort() + "  " + insInf.getOrder();
        }

        List<TSysInsInf> tl = find(hql, param, insInf.getPage(), insInf.getLimit());
        List<InsInf> l = new ArrayList<InsInf>();

        if (tl != null && tl.size() > 0) {
            for (TSysInsInf t : tl) {
                InsInf inf = new InsInf();
                BeanUtils.copyProperties(t, inf);

                // 上一级机构
                if (t.getTSysInsInf() != null) {
                    if (!PbUtils.isEmpty(t.getTSysInsInf().getInsCd())) {
                        inf.setParentInsCd(t.getTSysInsInf().getUuid());// 上一级机构UUID
                        inf.setParentInsCdNm(t.getTSysInsInf().getInsNm());// 上一级机构名称
                    }
                }

                l.add(inf);
            }
        }

        Long total = count(totalHql, param);
        grid.setCount(total);
        grid.setData(l);

        return grid;
    }

    @Transactional
    @Override
    public Json add(InsInf inf) {
        Json j = new Json();

        // 判断机构编号是否存在
        Map<String, Object> params = new HashMap<String, Object>();
        if (!PbUtils.isEmpty(inf.getInsCd())) {
            params.put("insCd", inf.getInsCd().trim());
        }
        Long total = super.count("Select count(*) from TSysInsInf t where trim(t.insCd) =:insCd ", params);

        if (total > 0) {
            j.setSuccess(false);
            j.setMsg("新增失败：机构编号已经存在");
            return j;
        }

        TSysInsInf tInf = new TSysInsInf();
        BeanUtils.copyProperties(inf, tInf);

        // 上一级机构
        TSysInsInf tSysInsInf = null;
        if (!PbUtils.isEmpty(inf.getParentInsCd())) {
            tSysInsInf = getById(TSysInsInf.class, inf.getParentInsCd());
            tInf.setTSysInsInf(tSysInsInf);
        }

        // 机构详情
        String insDetail = "," + inf.getUuid() + ",";
        // 机构详情-不包含自己
        String insDetailNotMy = ",";
        if (tSysInsInf != null) {

            while (tSysInsInf != null) {
                insDetail += tSysInsInf.getUuid() + ",";
                insDetailNotMy += tSysInsInf.getUuid() + ",";
                tSysInsInf = tSysInsInf.getTSysInsInf();
            }
        }
        tInf.setInsDetail(insDetail);
        tInf.setInsDetailNotMy(insDetailNotMy);
        save(tInf);

        j.setSuccess(true);
        j.setMsg("新增成功");
        return j;
    }


    @Transactional
    @Override
    public Json addNotPage(InsInf inf) {
        Json j = new Json();

        TSysInsInf tInf = new TSysInsInf();
        BeanUtils.copyProperties(inf, tInf);

        // 上一级机构
        TSysInsInf tSysInsInf = null;
        TSysInsInf tSysInsInfFather = null;
        if (!PbUtils.isEmpty(inf.getParentInsCd())) {
            tSysInsInf = getById(TSysInsInf.class, inf.getParentInsCd());
            tSysInsInfFather = tSysInsInf;
        }

        // 机构详情
        String insDetail = "," + inf.getUuid() + ",";
        // 机构详情-不包含自己
        String insDetailNotMy = "";

        if (tSysInsInf != null) {
            insDetailNotMy = ",";
            while (tSysInsInf != null) {
                insDetail += tSysInsInf.getUuid() + ",";
                insDetailNotMy += tSysInsInf.getUuid() + ",";
                tSysInsInf = tSysInsInf.getTSysInsInf();
            }
        }
        tInf.setInsDetail(insDetail);
        tInf.setInsDetailNotMy(insDetailNotMy);
        tInf.setTSysInsInf(tSysInsInfFather);//上一级
        save(tInf);

        j.setSuccess(true);
        j.setMsg("新增成功");
        return j;
    }

    @Transactional
    @Override
    public void remove(String ids) {
        String[] nids = ids.split(",");
        String hql = "delete from TSysInsInf t where t.uuid in (";
        for (int i = 0; i < nids.length; i++) {
            if (i > 0) {
                hql += ",";
            }
            hql += "'" + nids[i] + "'";
        }
        hql += ")";
        executeHql(hql);

    }

    @Transactional
    @Override
    public Json modify(InsInf inf) {
        Json j = new Json();

        TSysInsInf tInf = getById(TSysInsInf.class, inf.getUuid());
        if (tInf == null) {
            j.setSuccess(false);
            j.setMsg("修改失败：找不到要修改的信息");
            return j;
        }


        // 旧对象
        InsInf oldObject = new InsInf();
        BeanUtils.copyProperties(tInf, oldObject);
        if (tInf.getTSysInsInf() != null) {
            oldObject.setParentInsCd(tInf.getInsCd());
            oldObject.setParentInsCdNm(tInf.getInsNm());
        }
        j.setOldObj(oldObject);

        BeanUtils.copyProperties(inf, tInf);

        // 上一级机构
        TSysInsInf tSysInsInf = null;
        TSysInsInf tSysInsInfFather = null;
        if (!PbUtils.isEmpty(inf.getParentInsCd())) {
            tSysInsInf = getById(TSysInsInf.class, inf.getParentInsCd());
            tSysInsInfFather = tSysInsInf;
        }

        // 机构详情
        String insDetail = "," + inf.getUuid() + ",";
        // 机构详情-不包含自己
        String insDetailNotMy = "";

        if (tSysInsInf != null) {
            insDetailNotMy = ",";
            while (tSysInsInf != null) {
                insDetail += tSysInsInf.getUuid() + ",";
                insDetailNotMy += tSysInsInf.getUuid() + ",";
                tSysInsInf = tSysInsInf.getTSysInsInf();
            }
        }
        tInf.setInsDetail(insDetail);
        tInf.setInsDetailNotMy(insDetailNotMy);
        tInf.setTSysInsInf(tSysInsInfFather);//上一级


        update(tInf);// 更新

        // 设置返回对象
        BeanUtils.copyProperties(tInf, inf);

        j.setSuccess(true);
        j.setMsg("更新成功");
        j.setObj(inf);
        return j;
    }

    @Override
    public Json verifyInfo(InsInf inf) {
        Json j = new Json();

        // 判断本级的机构是否比上一级机构小
        j = verifyLvl(inf);
        if (!j.isSuccess()) {
            return j;
        }

        // 判断是否为最高层的机构
        String lvl = Contans.INS_LVL_TOP;
        if (!inf.getInsLvl().equals(lvl) && PbUtils.isEmpty(inf.getParentInsCd())) {
            j.setSuccess(false);
            j.setMsg("非最高层机构需要选择上一级机构");
            return j;
        }

        j.setSuccess(true);
        j.setMsg("成功！");
        j.setObj(inf);
        return j;
    }

    /**
     * 判断本级的机构是否比上一级机构小
     *
     * @param inf
     * @return
     */
    private Json verifyLvl(InsInf inf) {
        Json j = new Json();
        // 如果上一级机构不为空，级别最高的机构才为空
        if (!PbUtils.isEmpty(inf.getParentInsCd())) {
            TSysInsInf tInsInf = getById(TSysInsInf.class, inf.getParentInsCd());
            if (tInsInf != null) {
                // 判断本级的机构是否比上一级机构小
                Integer lvl = Integer.parseInt(inf.getInsLvl());// 本级机构
                Integer pLvl = Integer.parseInt(tInsInf.getInsLvl());// 上一级机构
                if (pLvl > lvl || pLvl == lvl) {
                    j.setSuccess(false);
                    j.setMsg("新增失败：本级机构级别不能位于上一级机构级别之上,或者平级");
                    return j;
                }
            }
        }

        j.setSuccess(true);
        return j;
    }

    @Override
    public List<InsInf> getList() {
        String hql = " from TSysInsInf t where 1=1";
        List<TSysInsInf> tlist = find(hql);
        List<InsInf> list = new ArrayList<InsInf>();
        if (tlist != null && tlist.size() > 0) {
            for (TSysInsInf tInf : tlist) {
                InsInf inf = new InsInf();
                BeanUtils.copyProperties(tInf, inf);
                list.add(inf);
            }
        }

        return list;
    }

    @Override
    public List<ZTree> getInsList(String insCd, String insTp) {
        String sql = "SELECT TRIM(UUID) AS ID,TRIM(INS_CD) INSCD ,TRIM(INS_NM) AS NAME,TRIM(PARENT_INS_CD) AS PID FROM T_SYS_INS_INF ";
        sql += "	where (uuid =:insCd or parent_ins_cd =:insCd or up_two_ins =:insCd or up_three_ins =:insCd) ";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("insCd", insCd);

        if (!PbUtils.isEmpty(insTp)) {
            sql += " and trim(INS_TP) in ( ";
            sql += "'" + Contans.INSTP0 + "','" + insTp.trim() + "'";
            sql += " )";
        }

        sql += " order by ins_cd";

        List<Map> list = findBySql(sql, params);

        List<ZTree> retList = new ArrayList<ZTree>();
        for (int i = 0; i < list.size(); i++) {
            Map map = (Map) list.get(i);
            ZTree treeNode = new ZTree();
            treeNode.setId((String) map.get("ID"));
            treeNode.setpId((String) map.get("PID"));
            treeNode.setName((String) map.get("NAME"));
            treeNode.setInsCd((String) map.get("INSCD"));
            if (PbUtils.isEmpty((String) map.get("PID"))) {
                treeNode.setOpen(true);
            }
            retList.add(treeNode);
        }

        return retList;
    }

    @Override
    public List<TreeForLayUI> getInsListForLayUI(String insCd, String insTp) {
        List<TreeForLayUI> zForLayUIs = new ArrayList<TreeForLayUI>();

        String sql = "SELECT TRIM(UUID) AS ID,TRIM(INS_CD) INSCD ,TRIM(INS_NM) AS NAME,TRIM(PARENT_INS_CD) AS PID FROM T_SYS_INS_INF t";
        sql += "	where  t.INS_DETAIL like:insCd";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("insCd", "%%" + insCd + "%%");


        sql += " order by ins_cd";

        List<Map> list = findBySql(sql, params);

        // 寻找本次结果的最高节点
        TreeForLayUI rootTreeForLayUI = new TreeForLayUI();
        String rootPid = null;
        String mPid = null;
        for (int i = 0; i < list.size(); i++) {
            Map map = (Map) list.get(i);
            mPid = (String) map.get("PID");//假设是最高级别
            boolean v = true;
            for (int x = 0; x < list.size(); x++) {
                Map mapChild = (Map) list.get(i);
                String id = (String) mapChild.get("ID");
                if (id.equals(mPid)) {
                    v = false;
                    break;//不是最高级别
                }
            }
            if (v) {
                rootPid = (String) map.get("ID");
                rootTreeForLayUI.setId((String) map.get("ID"));
                rootTreeForLayUI.setName((String) map.get("NAME"));
                rootTreeForLayUI.setSpread(true);
                break;
            }
        }


        //第二级
        List<TreeForLayUI> childList1 = new ArrayList<TreeForLayUI>();
        for (int i = 0; i < list.size(); i++) {
            TreeForLayUI childTreeForLayUI = new TreeForLayUI();
            Map map = (Map) list.get(i);
            String pid = (String) map.get("PID");
            if (rootPid.equals(pid)) {
                childTreeForLayUI.setId((String) map.get("ID"));
                childTreeForLayUI.setName((String) map.get("NAME"));
                childTreeForLayUI.setSpread(false);
                childList1.add(childTreeForLayUI);
            }
        }
        rootTreeForLayUI.setChildren(childList1);

        //遍历所有下一级
        for (int x = 0; x < list.size(); x++) {
            List<TreeForLayUI> childList = new ArrayList<TreeForLayUI>();
            for (TreeForLayUI treeNode : childList1) {
                for (int i = 0; i < list.size(); i++) {
                    TreeForLayUI childTreeForLayUI = new TreeForLayUI();
                    Map map = (Map) list.get(i);
                    String pid = (String) map.get("PID");
                    if (pid != null && pid.equals(treeNode.getId())) {
                        childTreeForLayUI.setId((String) map.get("ID"));
                        childTreeForLayUI.setName((String) map.get("NAME"));
                        childTreeForLayUI.setSpread(false);
                        childList.add(childTreeForLayUI);
                    }
                }
                treeNode.setChildren(childList);
            }
            childList1 = childList;
        }


        zForLayUIs.add(rootTreeForLayUI);
        return zForLayUIs;
    }

    @Override
    public List<ZTree> getInsList() {
        String sql = "SELECT TRIM(INS_CD) AS ID,TRIM(INS_NM) AS NAME,TRIM(PARENT_INS_CD) AS PID FROM T_SYS_INS_INF ";
        List<Map> list = findBySql(sql);

        List<ZTree> retList = new ArrayList<ZTree>();
        for (int i = 0; i < list.size(); i++) {
            Map map = (Map) list.get(i);
            ZTree treeNode = new ZTree();
            treeNode.setId((String) map.get("ID"));
            treeNode.setpId((String) map.get("PID"));
            treeNode.setName((String) map.get("NAME"));
            if (PbUtils.isEmpty((String) map.get("PID"))) {
                treeNode.setOpen(true);
            }
            retList.add(treeNode);
        }

        return retList;
    }

}
