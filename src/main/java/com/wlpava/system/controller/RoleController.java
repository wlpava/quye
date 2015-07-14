/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

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
import com.wlpava.system.entity.Role;

/**
 * 系统管理->角色管理Controller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/dev/role")
public class RoleController extends BaseController {

	@RequiresPermissions("role:view")
	@RequestMapping(value = { "list", "" }, method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, REQUEST_PREFIX);
		model.addAttribute("page", systemServices.roleService.getPageable(searchParams, pageNumber, pageSize));
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, REQUEST_PREFIX));
		return "system/role/list";
	}

	@RequiresPermissions("role:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		setCommonData(model);
		model.addAttribute("role", new Role());
		model.addAttribute("op", SystemConstant.OperateEnum.create.getInfo());
		return "system/role/edit";
	}

	@RequiresPermissions("role:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Role role, RedirectAttributes redirectAttributes) {
		systemServices.roleService.create(role);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.create.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/role";
	}

	@RequiresPermissions("role:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		setCommonData(model);
		model.addAttribute("role", systemServices.roleService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.update.getInfo());
		return "system/role/edit";
	}

	@RequiresPermissions("role:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(Role role, RedirectAttributes redirectAttributes) {
		systemServices.roleService.update(role);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.update.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/role";
	}

	@RequiresPermissions("role:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
		setCommonData(model);
		model.addAttribute("role", systemServices.roleService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.delete.getInfo());
		return "system/role/edit";
	}

	@RequiresPermissions("role:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		systemServices.roleService.delete(id);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.delete.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/role";
	}

	private void setCommonData(Model model) {
		model.addAttribute("resourceList", systemServices.resourceService.findAll());
	}

}
