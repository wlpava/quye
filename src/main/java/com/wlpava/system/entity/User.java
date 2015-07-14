/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.wlpava.core.persistence.BaseEntity;
import com.wlpava.quye.entity.Activity;
import com.wlpava.quye.entity.Apply;
import com.wlpava.quye.entity.BillDetail;
import com.wlpava.quye.entity.Knowledge;
import com.wlpava.quye.entity.Share;

/**
 * 系统管理->用户实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "sys_user", catalog = "quye")
public class User extends BaseEntity<Integer> {
	private String userName;
	private String loginName;
	private String password;
	private String salt;
	private List<Integer> roleIds;
	private String phone;
	private String email;
	private Integer type; // 用户类型
	private Integer status;
	private Date createTime;
	private Date loginTime;
	private String loginIp;
	private String identity_card;
	private String real_name;
	private String urgent_name;
	private String urgent_phone;
	private List<Activity> activities = Lists.newArrayList();
	private List<Apply> applys = Lists.newArrayList();
	private List<BillDetail> billDetails = Lists.newArrayList();
	private List<Knowledge> knowledges = Lists.newArrayList();
	private List<Share> shares = Lists.newArrayList();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Transient
	public String getCredentialsSalt() {
		return salt; // loginName + salt;
	}

	@Transient
	public List<Integer> getRoleIds() {
		if (roleIds == null) {
			roleIds = new ArrayList<Integer>();
		}
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	@Column(name = "role_ids")
	public String getRoleIdsStr() {
		if (CollectionUtils.isEmpty(roleIds)) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (Integer roleId : roleIds) {
			s.append(roleId);
			s.append(",");
		}
		return s.toString();
	}

	public void setRoleIdsStr(String roleIdsStr) {
		if (StringUtils.isEmpty(roleIdsStr)) {
			return;
		}
		roleIds = new ArrayList<Integer>();
		String[] roleIdStrs = roleIdsStr.split(",");
		for (String roleIdStr : roleIdStrs) {
			if (StringUtils.isEmpty(roleIdStr)) {
				continue;
			}
			getRoleIds().add(Integer.valueOf(roleIdStr));
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getIdentity_card() {
		return identity_card;
	}

	public void setIdentity_card(String identity_card) {
		this.identity_card = identity_card;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getUrgent_name() {
		return urgent_name;
	}

	public void setUrgent_name(String urgent_name) {
		this.urgent_name = urgent_name;
	}

	public String getUrgent_phone() {
		return urgent_phone;
	}

	public void setUrgent_phone(String urgent_phone) {
		this.urgent_phone = urgent_phone;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Apply> getApplys() {
		return applys;
	}

	public void setApplys(List<Apply> applys) {
		this.applys = applys;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Knowledge> getKnowledges() {
		return knowledges;
	}

	public void setKnowledges(List<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
