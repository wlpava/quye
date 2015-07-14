/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wlpava.system.dao.BulletinDao;
import com.wlpava.system.dao.ConfigDao;
import com.wlpava.system.dao.LogDao;
import com.wlpava.system.dao.ResourceDao;
import com.wlpava.system.dao.RoleDao;
import com.wlpava.system.dao.UserDao;

/**
 * 系统管理Dao公共类
 * 
 * @author wenlp
 */
@Service
public class SystemDaos {

	@Resource
	public UserDao userDao;

	@Resource
	public RoleDao roleDao;

	@Resource
	public ResourceDao resourceDao;

	@Resource
	public ConfigDao configDao;

	@Resource
	public LogDao logDao;

	@Resource
	public BulletinDao bulletinDao;

}
