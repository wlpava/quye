package com.wlpava.quye.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wlpava.core.persistence.BaseEntity;
import com.wlpava.system.entity.User;

/**
 * 知识实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "knowledge", catalog = "quye")
public class Knowledge extends BaseEntity<Integer> {
	private User user;
	private String title;
	private String picture;
	private String content;
	private Date createTime;

	// Constructors

	/** default constructor */
	public Knowledge() {
	}

	/** full constructor */
	public Knowledge(User user, String title, String picture,
			String content, Date createTime) {
		this.user = user;
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.createTime = createTime;
	}

	// Property accessors

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sys_user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

}