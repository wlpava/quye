/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wlpava.system.service.BulletinService;
import com.wlpava.system.service.ConfigService;
import com.wlpava.system.service.LogService;
import com.wlpava.system.service.ResourceService;
import com.wlpava.system.service.RoleService;
import com.wlpava.system.service.UserService;

/**
 * 系统管理Service公共类
 * 
 * @author wenlp
 */
@Service
public class SystemServices {

	@Resource
	public UserService userService;

	@Resource
	public RoleService roleService;

	@Resource
	public ResourceService resourceService;

	@Resource
	public ConfigService configService;

	@Resource
	public LogService logService;

	@Resource
	public BulletinService bulletinService;

}
