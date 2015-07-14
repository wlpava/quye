/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.wlpava.core.persistence.BaseEntity;

/**
 * 系统管理->角色实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "sys_role", catalog = "quye")
public class Role extends BaseEntity<Integer> {
	private String name; // 角色标识 程序中判断使用,如"admin"
	private String description; // 角色描述,UI界面显示使用
	private List<Integer> resourceIds; // 拥有的资源
	private Boolean status = Boolean.TRUE; // 是否可用

	public Role() {
	}

	public Role(String name, String description, Boolean status) {
		this.name = name;
		this.description = description;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public List<Integer> getResourceIds() {
		if (resourceIds == null) {
			resourceIds = new ArrayList<Integer>();
		}
		return resourceIds;
	}

	public void setResourceIds(List<Integer> resourceIds) {
		this.resourceIds = resourceIds;
	}

	@Column(name = "resource_ids")
	public String getResourceIdsStr() {
		if (CollectionUtils.isEmpty(resourceIds)) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (Integer resourceId : resourceIds) {
			s.append(resourceId);
			s.append(",");
		}
		return s.toString();
	}

	public void setResourceIdsStr(String resourceIdsStr) {
		if (StringUtils.isEmpty(resourceIdsStr)) {
			return;
		}
		resourceIds = new ArrayList<Integer>();
		String[] resourceIdStrs = resourceIdsStr.split(",");
		for (String resourceIdStr : resourceIdStrs) {
			if (StringUtils.isEmpty(resourceIdStr)) {
				continue;
			}
			getResourceIds().add(Integer.valueOf(resourceIdStr));
		}
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
