package com.wlpava.quye.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wlpava.core.persistence.BaseEntity;

/**
 * 租用明细实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "rent_detail", catalog = "quye")
public class RentDetail extends BaseEntity<Integer> {

	private Rent rent;
	private Activity activity;
	private Short count;
	private Float fee;
	private String note;
	private Date createTime;

	// Constructors

	/** default constructor */
	public RentDetail() {
	}

	/** minimal constructor */
	public RentDetail(Rent rent, Activity activity, Float fee, String note,
			Date createTime) {
		this.rent = rent;
		this.activity = activity;
		this.fee = fee;
		this.note = note;
		this.createTime = createTime;
	}

	/** full constructor */
	public RentDetail(Rent rent, Activity activity, Short count, Float fee,
			String note, Date createTime) {
		this.rent = rent;
		this.activity = activity;
		this.count = count;
		this.fee = fee;
		this.note = note;
		this.createTime = createTime;
	}

	// Property accessors

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rent_id", nullable = false)
	public Rent getRent() {
		return this.rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
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

}