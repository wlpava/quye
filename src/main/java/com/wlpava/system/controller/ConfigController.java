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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wlpava.core.web.Servlets;
import com.wlpava.system.BaseController;
import com.wlpava.system.SystemConstant;
import com.wlpava.system.entity.Config;

/**
 * 系统管理->配置管理Contoller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/dev/config")
public class ConfigController extends BaseController {

	@RequiresPermissions("config:view")
	@RequestMapping(value = { "list", "" }, method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, REQUEST_PREFIX);
		model.addAttribute("page", systemServices.configService.getPageable(searchParams, pageNumber, pageSize));
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, REQUEST_PREFIX));
		return "system/config/list";
	}

	@RequiresPermissions("config:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("config", new Config());
		model.addAttribute("op", SystemConstant.OperateEnum.create.getInfo());
		return "system/config/edit";
	}

	/**
	 * 校验参数名称和代码是否唯一
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/checkConfigName")
	@ResponseBody
	public String checkConfigName(@RequestParam(value = "oldName", required = false) String oldName, @RequestParam("name") String name) {
		return name.equals(oldName) || (systemServices.configService.findByName(name) == null) ? "true" : "false";
	}

	@RequestMapping(value = "/checkConfigCode")
	@ResponseBody
	public String checkConfigCode(@RequestParam(value = "oldCode", required = false) String oldCode, @RequestParam("code") String code) {
		return code.equals(oldCode) || (systemServices.configService.findByCode(code) == null) ? "true" : "false";
	}

	@RequiresPermissions("config:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Config config, RedirectAttributes redirectAttributes) {
		systemServices.configService.create(config);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.create.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/config";
	}

	@RequiresPermissions("config:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("config", systemServices.configService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.update.getInfo());
		return "system/config/edit";
	}

	@RequiresPermissions("config:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(Config config, RedirectAttributes redirectAttributes) {
		systemServices.configService.update(config);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.update.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/config";
	}

	@RequiresPermissions("config:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("config", systemServices.configService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.delete.getInfo());
		return "system/config/edit";
	}

	@RequiresPermissions("config:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		systemServices.configService.delete(id);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.delete.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/config";
	}

}
