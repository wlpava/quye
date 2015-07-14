/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wlpava.core.utils.FileUtil;
import com.wlpava.system.BaseController;
import com.wlpava.system.SystemConstant;

/**
 * 系统管理->上传管理Contoller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartHttpServletRequest request) {
		MultipartFile file = request.getFile("file");
		String uploadPath = systemServices.configService.findByCode(SystemConstant.CONFIG_UPLOAD_PATH).getValue();
		String filePath = FileUtil.getUUID() + File.separator;
		uploadPath += File.separator + filePath;

		boolean isSave = false;
		try {
			if (file != null) {
				filePath += file.getOriginalFilename();
				isSave = FileUtil.save(file.getInputStream(), uploadPath, file.getOriginalFilename());
			}
			if (isSave) {
				return "{result: \"success\", msg: \"上传文件成功！\", filePath: \"" + filePath.replaceAll("\\\\", "/") + "\"}";
			} else {
				return "{result: \"error\", msg: \"上传文件失败，请重新上传！\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{result: \"error\", msg: \"上传文件失败：" + e.getMessage() + "！\"}";
		}
	}

}
