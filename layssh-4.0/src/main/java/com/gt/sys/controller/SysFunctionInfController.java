package com.gt.sys.controller;

import com.gt.pageModel.*;
import com.gt.sys.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

/**
 * 
 * @功能说明：系统功能
 * @作者： herun
 * @创建日期：2015-09-24
 * @版本号：V1.0
 */
@Controller
@RequestMapping("/sysFunctionInf")
public class SysFunctionInfController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(SysFunctionInfController.class);

	public IMenuInfService menuInfService;// 菜单功能
	
	
	public IMenuInfService getMenuInfService() {
		return menuInfService;
	}
	
	@Autowired
	public void setMenuInfService(IMenuInfService menuInfService) {
		this.menuInfService = menuInfService;
	}
	
	/**
	 * 获取datagrid数据
	 */
	@RequestMapping("/datagrid")
	@ResponseBody
	public DatagridForLayUI datagrid(SysFunctionInf sftinfo) {
		return sysFunctionInfService.datagrid(sftinfo);
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(SysFunctionInf sftinfo, HttpSession session, HttpServletRequest request) {
		Json j = new Json();
		try {
			boolean v = sysFunctionInfService.isExistUrl(sftinfo.getFunctionUrl());
			if (!v) {
				v=menuInfService.isLastMenu(sftinfo.getMenuCd());
				if(v){
					SysFunctionInf sysFunctionInf = sysFunctionInfService.add(sftinfo);
					j.setSuccess(true);
					j.setObj(sysFunctionInf);
					j.setMsg("新增成功");
				}else {
					j.setSuccess(false);
					j.setMsg("新增失败：所属菜单必须选择最后一级菜单");
				}
			} else {
				j.setSuccess(false);
				j.setMsg("新增失败：请求地址已经存在");
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("新增失败:" + e.getMessage());
		}

		// 添加系统日志
		writeSysLog(j, sftinfo, request, session);

		return j;
	}

	/**
	 * 删除
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public Json remove(SysFunctionInf sftinfo, HttpSession session, HttpServletRequest request) {
		Json j = new Json();
		try {
			sysFunctionInfService.remove(sftinfo.getFunctionCd());
			j.setSuccess(true);
			j.setMsg("删除成功！");
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error(e.getMessage());
			j.setMsg("删除失败:" + e.getMessage());
		}

		// 添加系统日志
		writeSysLog(j, sftinfo, request, session);

		return j;
	}

	/**
	 * 修改
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public Json modify(SysFunctionInf sftinfo, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			boolean v=menuInfService.isLastMenu(sftinfo.getMenuCd());
			if(v){
				j = sysFunctionInfService.modify(sftinfo);
			}else {
				j.setSuccess(false);
				j.setMsg("修改失败：所属菜单必须选择最后一级菜单");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("修改失败:" + e.getMessage());
		}

		// 添加系统日志
		writeSysLog(j, sftinfo, request, session);

		return j;
	}

}
