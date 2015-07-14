package com.wlpava.quye.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wlpava.core.persistence.BaseEntity;

/**
 * 报名挂实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "apply_detail", catalog = "quye")
public class ApplyDetail extends BaseEntity<Integer> {
	private Apply apply;
	private String userName;
	private String loginName;
	private String identityCard;
	private String urgentName;
	private String urgentPhone;

	// Constructors

	/** default constructor */
	public ApplyDetail() {
	}

	/** minimal constructor */
	public ApplyDetail(Apply apply, String userName, String loginName,
			String identityCard) {
		this.apply = apply;
		this.userName = userName;
		this.loginName = loginName;
		this.identityCard = identityCard;
	}

	/** full constructor */
	public ApplyDetail(Apply apply, String userName, String loginName,
			String identityCard, String urgentName, String urgentPhone) {
		this.apply = apply;
		this.userName = userName;
		this.loginName = loginName;
		this.identityCard = identityCard;
		this.urgentName = urgentName;
		this.urgentPhone = urgentPhone;
	}

	// Property accessors

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apply_id", nullable = false)
	public Apply getApply() {
		return this.apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getUrgentName() {
		return this.urgentName;
	}

	public void setUrgentName(String urgentName) {
		this.urgentName = urgentName;
	}

	public String getUrgentPhone() {
		return this.urgentPhone;
	}

	public void setUrgentPhone(String urgentPhone) {
		this.urgentPhone = urgentPhone;
	}

}