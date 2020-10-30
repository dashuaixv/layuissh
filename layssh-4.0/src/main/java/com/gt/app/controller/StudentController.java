package com.gt.app.controller;

import com.gt.app.service.*;
import com.gt.model.*;
import com.gt.pageModel.*;
import com.gt.sys.controller.*;
import com.gt.utils.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;


/**
 * @功能说明：
 * @作者：herun
 * @创建日期：2017-12-13
 * @版本号：V1.0
 */
@Controller
@RequestMapping("/student")

public class StudentController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(StudentController.class);
	private IStudentService studentService;

	public IStudentService getStudentService() {
		return  studentService;
	}

	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}


	/**
	 * 获取datagrid数据
	 */
	@RequestMapping("/datagrid")
	@ResponseBody
	public DatagridForLayUI datagrid(Student student) {
		DatagridForLayUI datagrid=null;
		try {
			datagrid = studentService.datagrid(student);
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
	public Json add(Student student, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			student.setUuid(PbUtils.getUUID());
			student.setCreateTime(new Date());
			j = studentService.add(student);
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			e.printStackTrace();
			j.setMsg("添加失败:" + e.getMessage());
		}
		
		//添加系统日志
		writeSysLog(j, student, request, session);
		
		return j;
	}

	/**
	 * 删除
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public Json remove(Student student, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			studentService.remove(student.getUuid().toString());
			j.setSuccess(true);
			j.setMsg("删除成功！");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败:" + e.getMessage());
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		//添加系统日志
		writeSysLog(j, student,request, session);
		
		return j;
	}

	/**
	 * 修改
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public Json modify(Student student, HttpServletRequest request, HttpSession session) {
		Json j = new Json();
		try {
			student.setUpdateTime(new Date());
			j = studentService.modify(student);
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("修改失败:" + e.getMessage());
			e.printStackTrace();
		}
	
		//添加系统日志
		writeSysLog(j, student,request,session );
		return j;
	}

	/**
	 * 获取下拉框数据
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public List<Student>  getList() {
		List<Student> list = studentService.getList();
		return list;
	}

}
