/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wlpava.system.BaseController;
import com.wlpava.system.SystemConstant;
import com.wlpava.system.entity.User;

/**
 * 系统管理->注册管理Contoller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String register(User user, RedirectAttributes redirectAttributes) {
		try {
			User userTemp = systemServices.userService.findByLoginName(user.getLoginName());
			if (userTemp != null) {
				redirectAttributes.addFlashAttribute("msg", "注册失败：该用户已存在！");
				return "redirect:/register";
			}
			user.setUserName(user.getLoginName());
			user.setType(SystemConstant.UserType.普通用户.toInteger());
			user.setRoleIdsStr(systemServices.roleService.findByName(SystemConstant.UserType.get(user.getType())).getId() + ",");
			user.setCreateTime(new Date());
			user.setStatus(1);
			systemServices.userService.create(user);
			redirectAttributes.addFlashAttribute("msg", "注册成功，请登录！");
			return "redirect:/login";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "注册失败：" + e.getMessage());
			return "redirect:/register";
		}
	}

	@RequestMapping(value = "client", method = RequestMethod.GET)
	public String clientRegister(Model model) {
		model.addAttribute("user", new User());
		return "register2";
	}

	@RequestMapping(value = "client", method = RequestMethod.POST)
	public String clientRegister(User user, @RequestParam(value = "smsCode") String smsCode, HttpSession session, RedirectAttributes redirectAttributes) {
		try {
			String code = (String) session.getAttribute(SystemConstant.SMS_RANDOM_CODE_KEY);
			log.info("input code：" + smsCode);
			if (!smsCode.trim().equalsIgnoreCase(code)) {
				redirectAttributes.addFlashAttribute("msg", "注册失败：验证码错误！");
				return "redirect:/register/client";
			}

			User userTemp = systemServices.userService.findByLoginName(user.getLoginName());
			if (userTemp != null) {
				redirectAttributes.addFlashAttribute("msg", "注册失败：该用户已存在！");
				return "redirect:/register/client";
			}
			user.setLoginName(user.getPhone());
			user.setUserName(user.getLoginName());
			user.setType(SystemConstant.UserType.普通用户.toInteger());
			user.setRoleIdsStr(systemServices.roleService.findByName("普通用户").getId() + ",");
			user.setCreateTime(new Date());
			user.setStatus(1);
			systemServices.userService.create(user);
			redirectAttributes.addFlashAttribute("msg", "注册成功，请登录！");
			return "redirect:/login";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "注册失败：" + e.getMessage());
			return "redirect:/register";
		}
	}

}
