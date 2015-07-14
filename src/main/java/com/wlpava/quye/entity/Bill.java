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

/**
 * 账单实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "bill", catalog = "quye")
public class Bill extends BaseEntity<Integer> {
	private Activity activity;
	private Integer type;
	private Float fee;
	private String note;
	private Date createTime;
	private List<BillDetail> billDetails = Lists.newArrayList();

	// Constructors

	/** default constructor */
	public Bill() {
	}

	/** minimal constructor */
	public Bill(Activity activity, Integer type, Float fee, String note,
			Date createTime) {
		this.activity = activity;
		this.type = type;
		this.fee = fee;
		this.note = note;
		this.createTime = createTime;
	}

	/** full constructor */
	public Bill(Activity activity, Integer type, Float fee, String note,
			Date createTime, List<BillDetail> billDetails) {
		this.activity = activity;
		this.type = type;
		this.fee = fee;
		this.note = note;
		this.createTime = createTime;
		this.billDetails = billDetails;
	}

	// Property accessors

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_id", nullable = false)
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bill")
	public List<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

}