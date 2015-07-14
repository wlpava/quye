/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wlpava.core.persistence.BaseEntity;

/**
 * 系统管理->日志实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "sys_log", catalog = "quye")
public class Log extends BaseEntity<Integer> {
	private String operator;
	private Date operateTime;
	private String operate;
	private String source;
	private String description;

	public Log() {
	}

	public Log(String operator, Date operateTime, String operate,
			String source, String description) {
		this.operator = operator;
		this.operateTime = operateTime;
		this.operate = operate;
		this.source = source;
		this.description = description;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}