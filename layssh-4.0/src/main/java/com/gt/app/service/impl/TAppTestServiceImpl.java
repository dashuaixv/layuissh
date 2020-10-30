package com.gt.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gt.utils.MyBeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.gt.app.service.ITAppTestService;
import com.gt.model.TAppTest;
import com.gt.pageModel.DatagridForLayUI;
import com.gt.pageModel.Json;
import com.gt.sys.service.impl.BaseServiceImpl;
import com.gt.utils.PbUtils;
import javax.transaction.*;
import com.gt.app.dao.ITAppTestDao;
/**
 * 
 * @功能说明：测试管理业务接口实现类
 * @作者： herun
 * @创建日期：2018-09-20
 * @版本号：V1.0
 */
@Service("tAppTestService")
public class TAppTestServiceImpl extends BaseServiceImpl<TAppTest> implements ITAppTestService {

    //定义DAO
	@Autowired
	private ITAppTestDao TAppTestDao;

	//获取datagrid数据
	@Override
	public DatagridForLayUI datagrid(TAppTest tAppTest) throws Exception{
		DatagridForLayUI grid = new DatagridForLayUI();
		String sqlLeft = "select t.myuuid as myuuid,t.name as name,t.sex as sex,t.age as age " ;
		String sql = " from t_app_test t where 1=1 " ;
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		// 主键
		if (!PbUtils.isEmpty(tAppTest.getMyuuid())) {
			sql += " and t.myuuid like:myuuid";
			param.put("myuuid", "%%" + tAppTest.getMyuuid() + "%%");
		}
		// 姓名
		if (!PbUtils.isEmpty(tAppTest.getName())) {
			sql += " and t.name like:name";
			param.put("name", "%%" + tAppTest.getName() + "%%");
		}
		// 性别
		if (!PbUtils.isEmpty(tAppTest.getSex())) {
			sql += " and t.sex like:sex";
			param.put("sex", "%%" + tAppTest.getSex() + "%%");
		}
		// 年纪
		if (!PbUtils.isEmpty(tAppTest.getAge())) {
			sql += " and t.age like:age";
			param.put("age", "%%" + tAppTest.getAge() + "%%");
		}
		
		
		String totalsql = "select count(*) " + sql;

		//排序
		sql += " order by  myuuid desc";
	
		List<Map> maps = findBySql(sqlLeft+sql, param, tAppTest.getPage(), tAppTest.getLimit());
		Long total = countBySql(totalsql,param);
		grid.setCount(total);
		grid.setData(maps);

		return grid;
	}

	//添加
    @Transactional
	@Override
	public Json add(TAppTest inf) {
		Json j = new Json();
		save(inf);
		j.setSuccess(true);
		j.setMsg("新增成功");
		j.setObj(inf);	// 设置返回对象
		return j;

	}

	//删除
    @Transactional
	@Override
	public void remove(String ids) {
		String[] nids = ids.split(",");
		String sql = "delete from t_app_test  where myuuid in (";
		for (int i = 0; i < nids.length; i++) {
			if (i > 0) {
				sql += ",";
			}
			sql += "'" + nids[i] + "'";
		}
		sql += ")";
		executeSql(sql);

	}

	//修改
    @Transactional
	@Override
	public Json modify(TAppTest inf) {
		Json j = new Json();

		TAppTest tInf = getById(TAppTest.class, inf.getMyuuid());
		if (tInf == null) {
			j.setSuccess(false);
			j.setMsg("修改失败：找不到要修改的信息");
			return j;
		}

		// 旧对象
		TAppTest oldObject = new TAppTest();
		MyBeanUtils.copyProperties(tInf, oldObject);
		j.setOldObj(oldObject);
		
		MyBeanUtils.copyProperties(inf, tInf);
		update(tInf);// 更新
		j.setSuccess(true);
		j.setMsg("更新成功");
		j.setObj(tInf);// 设置返回对象
		return j;
	}

	
	@Override
	public Json verifyInfo(TAppTest inf) {
		Json j = new Json();
		Map<String, Object> params= new HashMap<String, Object>();
		if (!PbUtils.isEmpty(inf.getMyuuid())) {
			params.put("myuuid", inf.getMyuuid());
		}
		Long total = super.count("Select count(*) from TAppTest t where t.Myuuid =:myuuid ", params);

		if (total > 0) {
			j.setSuccess(false);
			j.setMsg("此信息已经存在");
			return j;
		}

		j.setSuccess(true);
		j.setMsg("成功！");
		j.setObj(inf);
		return j;
	}

	//获取列表
	@Override
	public List<TAppTest> getList() {
		List<TAppTest> l = find("from TAppTest t");
		return l;
	}
}
