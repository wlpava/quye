/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlpava.system.BaseController;
import com.wlpava.system.entity.Resource;
import com.wlpava.system.service.ResourceService;
import com.wlpava.system.service.UserService;

/**
 * 系统管理->首页Contoller
 * 
 * @author wenlp
 */
@Controller
public class IndexController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;

	@RequestMapping("/dev")
	public String index(Model model) {
		Set<String> permissions = userService.findPermissions(currentUser().loginName);
		List<Resource> menus = resourceService.findMenus(permissions);
		model.addAttribute("menus", menus);
		model.addAttribute("userId", currentUser().id);
		// if (currentUser().type == SystemConstant.USER_TYPE_3) {
		// return "mdm/home";
		// }
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
