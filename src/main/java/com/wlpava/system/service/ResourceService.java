/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wlpava.core.web.DynamicSpecifications;
import com.wlpava.core.web.SearchFilter;
import com.wlpava.system.BaseService;
import com.wlpava.system.entity.Resource;

/**
 * 系统管理->资源管理Service
 * 
 * @author wenlp
 */
@Service
@Transactional(readOnly = true)
public class ResourceService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(ResourceService.class);

	public Page<Resource> getPageable(Map<String, Object> searchParams, int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<Resource> spec = DynamicSpecifications.bySearchFilter(filters.values(), Resource.class);
		return systemDaos.resourceDao.findAll(spec, pageRequest);
	}

	@Transactional(readOnly = false)
	public Resource create(Resource resource) {
		return systemDaos.resourceDao.save(resource);
	}

	@Transactional(readOnly = false)
	public Resource update(Resource resource) {
		return systemDaos.resourceDao.save(resource);
	}

	@Transactional(readOnly = false)
	public void delete(Integer resourceId) {
		Resource resource = findOne(resourceId);
		systemDaos.resourceDao.deleteByParentIds(resource.makeSelfAsParentIds() + "%");
		systemDaos.resourceDao.delete(resourceId);
	}

	public Resource findOne(Integer resourceId) {
		return systemDaos.resourceDao.findOne(resourceId);
	}

	public List<Resource> findAll() {
		return systemDaos.resourceDao.findAll();
	}

	/**
	 * 得到资源对应的权限字符串
	 * 
	 * @param resourceIds
	 * @return
	 */
	public Set<String> findPermissions(Set<Integer> resourceIds) {
		Set<String> permissions = new HashSet<String>();
		for (Integer resourceId : resourceIds) {
			Resource resource = findOne(resourceId);
			if ((resource != null) && !StringUtils.isEmpty(resource.getPermission())) {
				permissions.add(resource.getPermission());
			}
		}
		return permissions;
	}

	/**
	 * 根据用户权限得到菜单
	 * 
	 * @param permissions
	 * @return
	 */
	public List<Resource> findMenus(Set<String> permissions) {
		List<Resource> allResources = findAll();
		List<Resource> menus = new ArrayList<Resource>();
		for (Resource resource : allResources) {
			if (resource.isRootNode()) {
				continue;
			}
			if (!resource.getType().equals(Resource.TypeEnum.menu.name())) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			menus.add(resource);
		}
		return menus;
	}

	private boolean hasPermission(Set<String> permissions, Resource resource) {
		if (StringUtils.isEmpty(resource.getPermission())) {
			return true;
		}
		for (String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(resource.getPermission());
			if (p1.implies(p2) || p2.implies(p1)) {
				return true;
			}
		}
		return false;
	}

}
