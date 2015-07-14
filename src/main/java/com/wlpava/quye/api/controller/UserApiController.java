/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.quye.api.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlpava.quye.QuyeController;
import com.wlpava.quye.api.ClientConstant;
import com.wlpava.quye.api.vo.Response;
import com.wlpava.system.SystemConstant;
import com.wlpava.system.entity.User;

/**
 * 对外接口->用户Contoller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/api/user")
public class UserApiController extends QuyeController {
	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Response register(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password, @RequestParam(value = "smsCode") String smsCode, HttpSession session) {
		log.info("--->[API]：register");
		Response response = new Response();
		try {
			String code = (String) session.getAttribute(SystemConstant.SMS_RANDOM_CODE_KEY);
			log.info("input code：" + smsCode);
			if (!smsCode.trim().equalsIgnoreCase(code)) {
				response.setReturnCode(ClientConstant.CLIENT_RETURN_CODE_502);
			} else if (systemServices.userService.findByPhone(phone) != null) {
				response.setReturnCode(ClientConstant.CLIENT_RETURN_CODE_501);
			} else {
				User user = new User();
				user.setLoginName(phone);
				user.setUserName(phone);
				user.setPassword(password);
				user.setPhone(phone);
				user.setType(SystemConstant.UserType.普通用户.toInteger());
				user.setRoleIdsStr(systemServices.roleService.findByName(SystemConstant.UserType.普通用户.toString()).getId() + ",");
				user.setCreateTime(new Date());
				user.setStatus(1);
				systemServices.userService.create(user);
				response.setReturnCode(ClientConstant.CLIENT_RETURN_CODE_200);
			}
		} catch (Exception e) {
			response.setReturnCode(ClientConstant.CLIENT_RETURN_CODE_500);
		}
		return response;
	}

}