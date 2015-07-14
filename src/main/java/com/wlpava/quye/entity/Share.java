package com.wlpava.quye.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wlpava.core.persistence.BaseEntity;
import com.wlpava.system.entity.User;

/**
 * 分享实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "share", catalog = "quye")
public class Share extends BaseEntity<Integer> {
	private User user;
	private String title;
	private String pictures;

	// Constructors

	/** default constructor */
	public Share() {
	}

	/** minimal constructor */
	public Share(User user, String pictures) {
		this.user = user;
		this.pictures = pictures;
	}

	/** full constructor */
	public Share(User user, String title, String pictures) {
		this.user = user;
		this.title = title;
		this.pictures = pictures;
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

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

}