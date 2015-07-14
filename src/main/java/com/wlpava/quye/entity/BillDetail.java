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
 * 账单明细实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "bill_detail", catalog = "quye")
public class BillDetail extends BaseEntity<Integer> {
	private User user;
	private Bill bill;
	private Float fee;
	private Date createTime;

	// Constructors

	/** default constructor */
	public BillDetail() {
	}

	/** full constructor */
	public BillDetail(User user, Bill bill, Float fee,
			Date createTime) {
		this.user = user;
		this.bill = bill;
		this.fee = fee;
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

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}