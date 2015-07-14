/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.wlpava.core.persistence.BaseEntity;

/**
 * 系统管理->资源实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "sys_resource", catalog = "quye")
public class Resource extends BaseEntity<Integer> {
	private String name; // 资源名称
	private String type; // 资源类型
	private String url; // 资源路径
	private String permission; // 权限字符串
	private Integer parentId; // 父编号
	private String parentIds; // 父编号列表
	private String iconPath; // 图标路径
	private String catagory; // 分组
	private String description; // 描述
	private Boolean status = Boolean.TRUE;

	public static enum TypeEnum {
		menu("菜单"), button("按钮");

		private final String info;

		private TypeEnum(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Transient
	public boolean isRootNode() {
		return parentId == 0;
	}

	public String makeSelfAsParentIds() {
		return getParentIds() + getId() + "/";
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
