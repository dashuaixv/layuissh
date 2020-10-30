package com.gt.sys.controller;

import com.gt.pageModel.*;
import com.gt.utils.*;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

/**
 * 
 * @功能说明：动态创建按钮
 * @作者： herun
 * @创建日期：2015-09-30
 * @版本号：V1.0
 */
@Controller
@RequestMapping("/buttonCreate")
public class ButtonCreateController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(ButtonCreateController.class);

	/**
	 * 验证权限
	 * 
	 * @param request
	 * @param requestPath
	 * @param session
	 * @return
	 */
	@RequestMapping("/checkAuth")
	@ResponseBody
	public Json checkAuth(HttpServletRequest request, String requestPath, HttpSession session) {
		Json j = new Json();
		String[] auths = requestPath.split(",");

		try {
			SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(Contans.SESSION_BEAN);
			boolean v = false;
			for (int i = 0; i < auths.length; i++) {
				// 是否需要权限验证
				if (sysFunctionInfService.isExistUrl(auths[i])) {
					v = sysFunctionInfService.checkAuth(sessionInfo.getOperInf().getRoleInfs(), auths[i]);// 有权限
					auths[i] = (v == true ? "1" : "0");

				} else {
					auths[i] = ("1");// 不需要验则默认拥有权限
				}
			}

			j.setMsg("有权限");
			j.setSuccess(true);
			j.setObj(auths);
		} catch (Exception e) {
			logger.error(e.getMessage());
			j.setSuccess(false);
			j.setMsg("权限查询失败:" + e.getMessage());
		}

		return j;
	}
}
