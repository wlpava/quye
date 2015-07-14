package com.wlpava.quye.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.wlpava.core.persistence.BaseEntity;
import com.wlpava.system.entity.User;

/**
 * 报名实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "apply", catalog = "quye")
public class Apply extends BaseEntity<Integer> {
	private User user;
	private Activity activity;
	private Short count;
	private Date applyTime;
	private Date auditTime;
	private Boolean isCashier;
	private List<ApplyDetail> applyDetails = Lists.newArrayList();

	// Constructors

	/** default constructor */
	public Apply() {
	}

	/** minimal constructor */
	public Apply(User user, Activity activity, Short count,
			Date applyTime, Boolean isCashier) {
		this.user = user;
		this.activity = activity;
		this.count = count;
		this.applyTime = applyTime;
		this.isCashier = isCashier;
	}

	/** full constructor */
	public Apply(User user, Activity activity, Short count,
			Date applyTime, Date auditTime, Boolean isCashier,
			List<ApplyDetail> applyDetails) {
		this.user = user;
		this.activity = activity;
		this.count = count;
		this.applyTime = applyTime;
		this.auditTime = auditTime;
		this.isCashier = isCashier;
		this.applyDetails = applyDetails;
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

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_id", nullable = false)
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Short getCount() {
		return this.count;
	}

	public void setCount(Short count) {
		this.count = count;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Boolean getIsCashier() {
		return this.isCashier;
	}

	public void setIsCashier(Boolean isCashier) {
		this.isCashier = isCashier;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apply")
	public List<ApplyDetail> getApplyDetails() {
		return this.applyDetails;
	}

	public void setApplyDetails(List<ApplyDetail> applyDetails) {
		this.applyDetails = applyDetails;
	}

}