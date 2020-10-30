package com.gt.app.service;

import java.util.List;
import com.gt.model.TAppTest;
import com.gt.pageModel.DatagridForLayUI;
import com.gt.pageModel.Json;
import com.gt.sys.service.IBaseService;

/**
 * @功能说明：测试管理业务接口类
 * @作者： herun
 * @创建日期：2018-09-20
 * @版本号：V1.0
 */
public interface ITAppTestService extends IBaseService<TAppTest> {

	/**
	 * 获取datagrid数据
	 * 
	 * @return
	 */
	public DatagridForLayUI datagrid(TAppTest inf) throws Exception;

	/**
	 * 新增
	 * 
	 * @param inf
	 * @return
	 */
	public Json add(TAppTest inf) throws Exception;

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public void remove(String ids);

	/**
	 * 修改
	 * 
	 * @param menuInf
	 */
	public Json modify(TAppTest inf);

	/**
	 * 信息验证
	 * 
	 * @param inf
	 * @return
	 */
	public Json verifyInfo(TAppTest inf);

	/**
	 * 获取下拉框数据
	 * @return
	 */
	public List<TAppTest> getList();

	
}
