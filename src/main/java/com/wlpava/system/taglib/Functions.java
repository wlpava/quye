/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.taglib;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.wlpava.core.utils.DateUtil;
import com.wlpava.core.utils.SpringUtils;
import com.wlpava.system.entity.Resource;
import com.wlpava.system.entity.Role;
import com.wlpava.system.service.ResourceService;
import com.wlpava.system.service.RoleService;

/**
 * 页面辅助方法类
 * 
 * @author wenlp
 */
public class Functions {

	public static boolean in(Iterable iterable, Object element) {
		if (iterable == null) {
			return false;
		}
		return CollectionUtils.contains(iterable.iterator(), element);
	}

	public static String dateTime(Date date) {
		if (date == null) {
			return "";
		}
		return DateUtil.formatDate(date);
	}

	public static String floatFormat(Float price) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(price);
	}

	public static String booleanFormat(Boolean isTrue) {
		if (isTrue) {
			return "是";
		} else {
			return "否";
		}
	}

	public static String intToString(Map<Integer, String> map, Integer mapId) {
		return map.get(mapId);
	}

	public static String roleName(Integer roleId) {
		Role role = getRoleService().findOne(roleId);
		if (role == null) {
			return "";
		}
		return role.getDescription();
	}

	public static String roleNames(Collection<Integer> roleIds) {
		if (CollectionUtils.isEmpty(roleIds)) {
			return "";
		}

		StringBuilder s = new StringBuilder();
		for (Integer roleId : roleIds) {
			Role role = getRoleService().findOne(roleId);
			if (role == null) {
				return "";
			}
			s.append(role.getDescription());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}

	public static String resourceName(Integer resourceId) {
		Resource resource = getResourceService().findOne(resourceId);
		if (resource == null) {
			return "";
		}
		return resource.getName();
	}

	public static String resourceNames(Collection<Integer> resourceIds) {
		if (CollectionUtils.isEmpty(resourceIds)) {
			return "";
		}

		StringBuilder s = new StringBuilder();
		for (Integer resourceId : resourceIds) {
			Resource resource = getResourceService().findOne(resourceId);
			if (resource == null) {
				return "";
			}
			s.append(resource.getName());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}

	private static RoleService roleService;
	private static ResourceService resourceService;

	public static RoleService getRoleService() {
		if (roleService == null) {
			roleService = SpringUtils.getBean(RoleService.class);
		}
		return roleService;
	}

	public static ResourceService getResourceService() {
		if (resourceService == null) {
			resourceService = SpringUtils.getBean(ResourceService.class);
		}
		return resourceService;
	}

}
