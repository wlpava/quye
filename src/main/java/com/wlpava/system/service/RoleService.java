/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.service;

import java.util.HashSet;
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
import com.wlpava.system.entity.Role;

/**
 * 系统管理->角色管理Service
 * 
 * @author wenlp
 */
@Service
@Transactional(readOnly = true)
public class RoleService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private ResourceService resourceService;

	public Page<Role> getPageable(Map<String, Object> searchParams, int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<Role> spec = DynamicSpecifications.bySearchFilter(filters.values(), Role.class);
		return systemDaos.roleDao.findAll(spec, pageRequest);
	}

	@Transactional(readOnly = false)
	public Role create(Role resource) {
		return systemDaos.roleDao.save(resource);
	}

	@Transactional(readOnly = false)
	public Role update(Role resource) {
		return systemDaos.roleDao.save(resource);
	}

	@Transactional(readOnly = false)
	public void delete(Integer resourceId) {
		systemDaos.roleDao.delete(resourceId);
	}

	public Role findOne(Integer resourceId) {
		return systemDaos.roleDao.findOne(resourceId);
	}

	/**
	 * 根据角色编号得到角色标识符列表
	 * 
	 * @param roleIds
	 * @return
	 */
	public Set<String> findRoles(Integer... roleIds) {
		Set<String> roles = new HashSet<String>();
		for (Integer roleId : roleIds) {
			Role role = findOne(roleId);
			if (role != null) {
				roles.add(role.getName());
			}
		}
		return roles;
	}

	/**
	 * 根据角色编号得到权限字符串列表
	 * 
	 * @param roleIds
	 * @return
	 */
	public Set<String> findPermissions(Integer[] roleIds) {
		Set<Integer> resourceIds = new HashSet<Integer>();
		for (Integer roleId : roleIds) {
			Role role = findOne(roleId);
			if (role != null) {
				resourceIds.addAll(role.getResourceIds());
			}
		}
		return resourceService.findPermissions(resourceIds);
	}

	public List<Role> findAll() {
		return (List<Role>) systemDaos.roleDao.findAll();
	}

	public Role findByName(String name) {
		return systemDaos.roleDao.findByName(name);
	}

}
