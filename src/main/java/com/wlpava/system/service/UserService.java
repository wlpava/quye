/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlpava.core.web.DynamicSpecifications;
import com.wlpava.core.web.SearchFilter;
import com.wlpava.system.BaseService;
import com.wlpava.system.entity.User;
import com.wlpava.system.exception.ServiceException;

/**
 * 系统管理->用户管理Service
 * 
 * @author wenlp
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private RoleService roleService;

	public Page<User> getPageable(Map<String, Object> searchParams, int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<User> spec = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
		return systemDaos.userDao.findAll(spec, pageRequest);
	}

	@Transactional(readOnly = false)
	public User create(User user) {
		passwordHelper.encryptPassword(user);
		return systemDaos.userDao.save(user);
	}

	@Transactional(readOnly = false)
	public User update(User user) {
		return systemDaos.userDao.save(user);
	}

	@Transactional(readOnly = false)
	public void delete(Integer userId) {
		if (userId == 1) {
			throw new ServiceException("不能删除超级管理员用户");
		}
		systemDaos.userDao.delete(userId);
	}

	public User findOne(Integer userId) {
		return systemDaos.userDao.findOne(userId);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	@Transactional(readOnly = false)
	public void changePassword(Integer userId, String newPassword) {
		User user = findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		update(user);
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param loginName
	 * @return
	 */
	public User findByLoginName(String loginName) {
		return systemDaos.userDao.findByLoginName(loginName);
	}

	/**
	 * 根据用户类型查找用户
	 * 
	 * @param userType
	 * @return
	 */
	public List<User> findByType(Integer userType) {
		return systemDaos.userDao.findByType(userType);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String loginName) {
		User user = findByLoginName(loginName);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findRoles(user.getRoleIds().toArray(new Integer[0]));
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String loginName) {
		User user = findByLoginName(loginName);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findPermissions(user.getRoleIds().toArray(new Integer[0]));
	}

	public User findByPhone(String phone) {
		return systemDaos.userDao.findByPhone(phone);
	}

}
