package com.gt.sys.controller;

import com.gt.pageModel.*;
import com.gt.sys.service.*;
import com.gt.sys.service.impl.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

/**
 * 
 * @功能说明：数据字典类型
 * @作者： herun
 * @创建日期：2015-09-25
 * @版本号：V1.0
 */
@Controller
@RequestMapping("/dictTp")
public class DictTpController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(DictTpController.class);
	private IDictTpService dictTpService = new DictTpServiceImpl();

	public IDictTpService getDictTpService() {
		return dictTpService;
	}

	@Autowired
	public void setDictTpService(IDictTpService dictTpService) {
		this.dictTpService = dictTpService;
	}

//	/**
//	 * 获取datagrid数据
//	 */
//	@RequestMapping("/datagrid")
//	@ResponseBody
//	public Datagrid datagrid(DictTp dictTp) {
//		Datagrid datagrid = dictTpService.datagrid(dictTp);
//		return datagrid;
//	}
	
	/**
	 * 获取datagrid数据
	 */
	@RequestMapping("/datagrid")
	@ResponseBody
	public DatagridForLayUI datagrid(DictTp dictTp) {
		DatagridForLayUI datagrid = dictTpService.datagrid(dictTp);
		return datagrid;
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(DictTp dictTp, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			j = dictTpService.verifyInfo(dictTp);
			if (j.isSuccess()) {
				DictTp inf = dictTpService.add(dictTp);
				j.setMsg("新增成功");
				j.setObj(inf);
				j.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("添加失败:" + e.getMessage());
		}

		// 添加系统日志
		writeSysLog(j, dictTp, request, session);

		return j;
	}

	/**
	 * 删除
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public Json remove(DictTp dictTp, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			dictTpService.remove(dictTp.getDictTypeCd());
			j.setSuccess(true);
			j.setMsg("删除成功！");
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败:" + e.getMessage());
		}

		// 添加系统日志
		writeSysLog(j, dictTp, request, session);

		return j;
	}

	/**
	 * 修改
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public Json modify(DictTp dictTp, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			j = dictTpService.modify(dictTp);
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("修改失败:" + e.getMessage());
		}

		// 添加系统日志
		writeSysLog(j, dictTp, request, session);

		return j;
	}

	/**
	 * 获取下拉框数据
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public List<DictTp> getList() {
		List<DictTp> list = dictTpService.getList();
		return list;
	}
}
