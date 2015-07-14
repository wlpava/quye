/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wlpava.system.BaseController;
import com.wlpava.system.SystemConstant;
import com.wlpava.system.entity.Resource;

/**
 * 系统管理->资源管理Controller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping("/dev/resource")
public class ResourceController extends BaseController {
	@ModelAttribute("types")
	public Resource.TypeEnum[] resourceTypes() {
		return Resource.TypeEnum.values();
	}

	@RequiresPermissions("resource:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("resourceList", systemServices.resourceService.findAll());
		return "system/resource/list";
	}

	@RequiresPermissions("resource:create")
	@RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
	public String showAppendChildForm(@PathVariable("parentId") Integer parentId, Model model) {
		Resource parent = systemServices.resourceService.findOne(parentId);
		model.addAttribute("parent", parent);
		Resource child = new Resource();
		child.setParentId(parentId);
		child.setParentIds(parent.makeSelfAsParentIds());
		model.addAttribute("resource", child);
		model.addAttribute("op", SystemConstant.OperateEnum.create.getInfo());
		return "system/resource/edit";
	}

	@RequiresPermissions("resource:create")
	@RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
	public String create(Resource resource, RedirectAttributes redirectAttributes) {
		systemServices.resourceService.create(resource);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.create.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/resource";
	}

	@RequiresPermissions("resource:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("resource", systemServices.resourceService.findOne(id));
		model.addAttribute("op", SystemConstant.OperateEnum.update.getInfo());
		return "system/resource/edit";
	}

	@RequiresPermissions("resource:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(Resource resource, RedirectAttributes redirectAttributes) {
		systemServices.resourceService.update(resource);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.update.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/resource";
	}

	@RequiresPermissions("resource:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		systemServices.resourceService.delete(id);
		redirectAttributes.addFlashAttribute("msg", SystemConstant.OperateEnum.delete.getInfo() + SystemConstant.OperateEnum.success.getInfo());
		return "redirect:/resource";
	}

}
