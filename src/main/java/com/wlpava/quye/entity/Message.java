package com.wlpava.quye.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wlpava.core.persistence.BaseEntity;

/**
 * 消息实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "message", catalog = "quye")
public class Message extends BaseEntity<Integer> {
	private Integer fromUserId;
	private Integer toUserId;
	private String content;
	private Date createTime;
	private Short status;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Integer toUserId, Integer fromUserId,
			String content, Date createTime, Short status) {
		this.toUserId = toUserId;
		this.fromUserId = fromUserId;
		this.content = content;
		this.createTime = createTime;
		this.status = status;
	}

	// Property accessors

	public Integer getIntegerByToUserId() {
		return this.toUserId;
	}

	public void setIntegerByToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	public Integer getFromUserId() {
		return this.fromUserId;
	}

	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
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

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}