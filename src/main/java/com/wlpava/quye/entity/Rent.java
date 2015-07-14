package com.wlpava.quye.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.wlpava.core.persistence.BaseEntity;

/**
 * 租用实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "rent", catalog = "quye")
public class Rent extends BaseEntity<Integer> {
	private Short type;
	private Float fee;
	private String unit;
	private String note;
	private List<RentDetail> rentDetails = Lists.newArrayList();

	// Constructors

	/** default constructor */
	public Rent() {
	}

	/** minimal constructor */
	public Rent(Short type, Float fee, String unit, String note) {
		this.type = type;
		this.fee = fee;
		this.unit = unit;
		this.note = note;
	}

	/** full constructor */
	public Rent(Short type, Float fee, String unit, String note, List<ApplyDetail> billDetails) {
		this.type = type;
		this.fee = fee;
		this.unit = unit;
		this.note = note;
		this.rentDetails = rentDetails;
	}

	// Property accessors

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rent")
	public List<RentDetail> getRentDetails() {
		return this.rentDetails;
	}

	public void setRentDetails(List<RentDetail> billDetails) {
		this.rentDetails = rentDetails;
	}

}