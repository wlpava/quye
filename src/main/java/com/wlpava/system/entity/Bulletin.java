/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.wlpava.core.persistence.BaseEntity;

/**
 * 系统管理->公告实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "sys_bulletin", catalog = "quye")
public class Bulletin extends BaseEntity<Integer> {
	private String title;
	private String picture;
	private String description;
	private String source;
	private String content;
	private Date createTime;

	/** default constructor */
	public Bulletin() {
	}

	/** full constructor */
	public Bulletin(String title, String picture, String description, String source, String content, Date createTime) {
		this.title = title;
		this.picture = picture;
		this.description = description;
		this.source = source;
		this.content = content;
		this.createTime = createTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}