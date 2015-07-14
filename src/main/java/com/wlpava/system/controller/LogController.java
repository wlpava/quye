/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.controller;

import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wlpava.core.web.Servlets;
import com.wlpava.system.BaseController;

/**
 * 系统管理->日志管理Contoller
 * 
 * @author wenlp
 */
@Controller
@RequestMapping(value = "/dev/log")
public class LogController extends BaseController {

	@RequestMapping(value = { "list", "" })
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, REQUEST_PREFIX);
		model.addAttribute("page", systemServices.logService.getPageable(searchParams, pageNumber, pageSize));
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, REQUEST_PREFIX));
		return "system/log/list";
	}

}
