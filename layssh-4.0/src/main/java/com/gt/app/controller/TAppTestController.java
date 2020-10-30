package com.gt.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gt.pageModel.DatagridForLayUI;
import com.gt.model.TAppTest;
import com.gt.pageModel.Json;
import com.gt.sys.controller.BaseController;
import com.gt.app.service.ITAppTestService;


/**
 * @功能说明：测试管理
 * @作者：herun
 * @创建日期：2018-09-20
 * @版本号：V1.0
 */
@Controller
@RequestMapping("/tAppTest")

public class TAppTestController extends BaseController {
	private Logger logger = Logger.getLogger(TAppTestController.class);
	private ITAppTestService tAppTestService;

	public ITAppTestService getTAppTestService() {
		return  tAppTestService;
	}

	@Autowired
	public void setTAppTestService(ITAppTestService tAppTestService) {
		this.tAppTestService = tAppTestService;
	}


	/**
	 * 获取datagrid数据
	 */
	@RequestMapping("/datagrid")
	@ResponseBody
	public DatagridForLayUI datagrid(TAppTest tAppTest) {
		DatagridForLayUI datagrid=null;
		try {
			datagrid = tAppTestService.datagrid(tAppTest);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(TAppTest tAppTest, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			j = tAppTestService.add(tAppTest);
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			e.printStackTrace();
			j.setMsg("添加失败:" + e.getMessage());
		}
		
		//添加系统日志
		writeSysLog(j, tAppTest, request, session);
		
		return j;
	}

	/**
	 * 删除
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public Json remove(TAppTest tAppTest, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			tAppTestService.remove(tAppTest.getMyuuid().toString());
			j.setSuccess(true);
			j.setMsg("删除成功！");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败:" + e.getMessage());
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		//添加系统日志
		writeSysLog(j, tAppTest,request, session);
		
		return j;
	}

	/**
	 * 修改
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public Json modify(TAppTest tAppTest, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			j = tAppTestService.modify(tAppTest);
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("修改失败:" + e.getMessage());
			e.printStackTrace();
		}
	
		//添加系统日志
		writeSysLog(j, tAppTest,request,session );
		return j;
	}

	/**
	 * 获取下拉框数据
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public List<TAppTest>  getList() {
		List<TAppTest> list = tAppTestService.getList();
		return list;
	}

}
