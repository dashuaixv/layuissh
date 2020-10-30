package com.gt.sys.controller;

import com.gt.pageModel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.multipart.commons.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * 
 * @功能说明：文件上传
 * @作者： herun
 * @创建日期：2015-09-25
 * @版本号：V1.0
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController extends BaseController {

	@Value("${upload}")
	private  String upload;

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Json springUpload(HttpServletRequest request) {
		Json json = new Json();
		String fileName = "";// 文件名称
		json.setSuccess(true);

		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					fileName = file.getOriginalFilename();
					String rootPath = upload + "/";
					String path = rootPath + fileName;

					// 文件文件夹
					File rootFile = new File(rootPath);
					if (!rootFile.exists()) {
						rootFile.mkdirs();
					}

					// 上传
					json.setMsg(fileName);
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						e.printStackTrace();
						json.setSuccess(false);
						json.setMsg(e.getMessage());
					} catch (IOException e) {
						e.printStackTrace();
						json.setSuccess(false);
						json.setMsg(e.getMessage());
					}
				}

			}

		}
		return json;
	}

	/**
	 * 文件下载
	 * 
	 * @Description:
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/downloadFile")
	@ResponseBody
	public Json downloadFile(String fileName,HttpServletRequest request,HttpServletResponse response) {
		Json json=new Json();
		json.setSuccess(true);
		if (fileName != null) {
			String realPath = upload+ "/";
			File file = new File(realPath, fileName);
			if (file.exists()) {
				json.setSuccess(true);
				json.setMsg("附件存在");
			}
			}else {
				json.setSuccess(false);
				json.setMsg("附件不存在");
		}
		return json;
	}
}
