/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wlpava.system.realm.UserRealm.ShiroUser;

/**
 * Service的基类<br>
 * 包含了常用的分页参数,当前用户ID,所有业务的Service注入等.<br>
 * 建议每个Sevice都实现此类.
 * 
 * @author wenlp
 */
public class BaseService {
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
	public SystemDaos systemDaos;

	/**
	 * 创建分页请求.<br>
	 * 默认以id为DESC 倒序查询
	 */
	public PageRequest buildPageRequest(int pageNumber, int pagzSize) {
		return new PageRequest(pageNumber - 1, pagzSize, new Sort(Direction.DESC, "id"));
	}

	/**
	 * 创建分页请求.<br>
	 * 以传入的sort排序
	 */
	public PageRequest buildPageRequest(int pageNumber, int pagzSize, Sort sort) {
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

}
