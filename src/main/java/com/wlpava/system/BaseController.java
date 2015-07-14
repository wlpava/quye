/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wlpava.system.realm.UserRealm.ShiroUser;

/**
 * Contoller的基类.<br>
 * 包含了常用的分页,查询参数,当前用户ID,所有业务的Service注入等.<br>
 * 建议每个Controller都实现此类.
 * 
 * @author wenlp
 */
public class BaseController {
	/**
	 * 当前登录用户
	 */
	public ShiroUser currentUser() {
		return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 公共的Service
	 */
	@Resource
	public SystemServices systemServices;

	/**
	 * 每页行数
	 */
	public static final String PAGE_SIZE = "10";

	/**
	 * 查询前缀<br>
	 * 页面的查询条件中name的前缀必须包含： REQUEST_PREFIX+查询格式(LIKE,EQ..) +查询参数.<br>
	 * eg: search_LIKE_name
	 */
	public static final String REQUEST_PREFIX = "search_";

	/**
	 * 用户类型Map
	 * 
	 * @return
	 */
	@ModelAttribute("userTypeMap")
	public Map<Integer, String> userTypeMap() {
		return SystemConstant.UserType.map;
	}

	/**
	 * 系统类型Map
	 * 
	 * @return
	 */
	@ModelAttribute("systemTypeMap")
	public Map<Integer, String> systemTypeMap() {
		return SystemConstant.SYSTEM_TYPE_MAP;
	}

}
