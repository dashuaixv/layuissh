package com.gt.servlet;

import com.gt.model.*;
import com.gt.sys.service.*;
import com.gt.utils.*;
import org.quartz.*;
import org.springframework.beans.factory.annotation.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;

/**
 * @功能说明：初始化quartz
 * @作者： herun
 * @创建日期：2015-11-19
 * @版本号：V1.0
 */
public class QuartzInItServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBaseService<Quarz> baseService;

	public void destroy() {
		super.destroy();
	}

	public void init() throws ServletException {
		String sql = "select *  from T_SYS_QUARZ t where t.state='0' ";
		List<Map> maps = baseService.findBySql(sql);
		MapToBeanUtils<Quarz> beanUtils = new MapToBeanUtils<Quarz>();
		List<Quarz> list = null;
		try {
			list = beanUtils.ListMapToJavaBean(maps, Quarz.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for (Quarz quarz : list) {
			try {
				QuarzUtils.schedStart(quarz, getServletContext());
			} catch (SchedulerException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

	}
}
