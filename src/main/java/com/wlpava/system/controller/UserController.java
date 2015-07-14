/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wlpava.core.web.Servlets;
import com.wlpava.system.BaseController;
import com.wlpava.system.SystemConstant;
import com.wlpava.system.entity.User;

/**
 * 系统管理->用户管理Contoller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/dev/user")
public class UserController extends BaseController {
	@RequiresPermissions("user:view")
	@RequestMapping(value = { "list", "" }, method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, REQUEST_PREFIX);
		model.addAttribute("page", systemServices.userService.getPageable(searchParams, pageNumber, pageSize));
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, REQUEST_PREFIX));
		return "system/user/list";
	}

	@RequestMapping(value = { "chooseUser" }, method = RequestMethod.GET)
	public String chooseUser(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, REQUEST_PREFIX);
		model.addAttribute("page", systemServices.userService.getPageable(searchParams, pageNumber, pageSize));
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, REQUEST_PREFIX));
		return "system/user/chooseUser";
	}

	@RequiresPermissions("user:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		setCommonData(model);
		model.addAttribute("user", new User());
		model.addAttribute("op", SystemConstant.OperateEnum.create.getInfo());
		return "system/user/edit";
	}

	@RequiresPermissions("user:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user, RedirectAttributes redirectAttributes) {
		user.setCreateTime(new Date());
		user.setStatus(1);
		systemServices.userService.create(user);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.create.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/user";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		setCommonData(model);
		model.addAttribute("user", systemServices.userService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.update.getInfo());
		return "system/user/edit";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(User user, RedirectAttributes redirectAttributes) {
		User oldUser = systemServices.userService.findOne(user.getId());
		user.setCreateTime(oldUser.getCreateTime());
		systemServices.userService.update(user);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.update.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/user";
	}

	@RequiresPermissions("user:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
		setCommonData(model);
		model.addAttribute("user", systemServices.userService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.delete.getInfo());
		return "system/user/edit";
	}

	@RequiresPermissions("user:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		systemServices.userService.delete(id);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.delete.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/user";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
	public String showChangePasswordForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("user", systemServices.userService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.update.getInfo());
		return "system/user/changePassword";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
	public String changePassword(@PathVariable("id") Integer id, String newPassword, RedirectAttributes redirectAttributes) {
		systemServices.userService.changePassword(id, newPassword);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.update.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/user";
	}

	private void setCommonData(Model model) {
		model.addAttribute("roleList", systemServices.roleService.findAll());
	}
}
