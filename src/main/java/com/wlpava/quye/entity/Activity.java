/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.quye.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.wlpava.core.persistence.BaseEntity;
import com.wlpava.system.entity.User;

/**
 * 活动实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "activity", catalog = "quye")
public class Activity extends BaseEntity<Integer> {
	private User user;
	private String area;
	private Short type;
	private String title;
	private String picture;
	private Short scenicIdx;
	private Short hardIdx;
	private Float budget;
	private Float prepay;
	private Integer maxPerson;
	private Date startDate;
	private Date endDate;
	private String assemblePlace;
	private String contact;
	private String content;
	private Date applyEndTime;
	private Boolean needInsurance;
	private String equipment;
	private Date createTime;
	private Date auditTime;
	private Integer status;
	private List<Bill> bills = Lists.newArrayList();
	private List<Apply> applies = Lists.newArrayList();
	private List<RentDetail> rentDetails = Lists.newArrayList();
	private List<Routing> routings = Lists.newArrayList();

	// Constructors

	/** default constructor */
	public Activity() {
	}

	/** minimal constructor */
	public Activity(User user, String area, Short type, String title,
			String picture, Short scenicIdx, Short hardIdx, Float budget,
			Integer maxPerson, Date startDate, Date endDate,
			String assemblePlace, String contact, String content,
			Date applyEndTime, Boolean needInsurance, String equipment,
			Date createTime, Integer status) {
		this.user = user;
		this.area = area;
		this.type = type;
		this.title = title;
		this.picture = picture;
		this.scenicIdx = scenicIdx;
		this.hardIdx = hardIdx;
		this.budget = budget;
		this.maxPerson = maxPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assemblePlace = assemblePlace;
		this.contact = contact;
		this.content = content;
		this.applyEndTime = applyEndTime;
		this.needInsurance = needInsurance;
		this.equipment = equipment;
		this.createTime = createTime;
		this.status = status;
	}

	/** full constructor */
	public Activity(User user, String area, Short type, String title,
			String picture, Short scenicIdx, Short hardIdx, Float budget,
			Float prepay, Integer maxPerson, Date startDate, Date endDate,
			String assemblePlace, String contact, String content,
			Date applyEndTime, Boolean needInsurance, String equipment,
			Date createTime, Date auditTime, Integer status,
			List<Bill> bills, List<Apply> applies, List<RentDetail> rentDetails, List<Routing> routings) {
		this.user = user;
		this.area = area;
		this.type = type;
		this.title = title;
		this.picture = picture;
		this.scenicIdx = scenicIdx;
		this.hardIdx = hardIdx;
		this.budget = budget;
		this.prepay = prepay;
		this.maxPerson = maxPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assemblePlace = assemblePlace;
		this.contact = contact;
		this.content = content;
		this.applyEndTime = applyEndTime;
		this.needInsurance = needInsurance;
		this.equipment = equipment;
		this.createTime = createTime;
		this.auditTime = auditTime;
		this.status = status;
		this.bills = bills;
		this.applies = applies;
		this.rentDetails = rentDetails;
		this.routings = routings;
	}

	// Property accessors

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Short getScenicIdx() {
		return this.scenicIdx;
	}

	public void setScenicIdx(Short scenicIdx) {
		this.scenicIdx = scenicIdx;
	}

	public Short getHardIdx() {
		return this.hardIdx;
	}

	public void setHardIdx(Short hardIdx) {
		this.hardIdx = hardIdx;
	}

	public Float getBudget() {
		return this.budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
	}

	public Float getPrepay() {
		return this.prepay;
	}

	public void setPrepay(Float prepay) {
		this.prepay = prepay;
	}

	public Integer getMaxPerson() {
		return this.maxPerson;
	}

	public void setMaxPerson(Integer maxPerson) {
		this.maxPerson = maxPerson;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAssemblePlace() {
		return this.assemblePlace;
	}

	public void setAssemblePlace(String assemblePlace) {
		this.assemblePlace = assemblePlace;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getApplyEndTime() {
		return this.applyEndTime;
	}

	public void setApplyEndTime(Date applyEndTime) {
		this.applyEndTime = applyEndTime;
	}

	public Boolean getNeedInsurance() {
		return this.needInsurance;
	}

	public void setNeedInsurance(Boolean needInsurance) {
		this.needInsurance = needInsurance;
	}

	public String getEquipment() {
		return this.equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "activity")
	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "activity")
	public List<Apply> getApplies() {
		return this.applies;
	}

	public void setApplies(List<Apply> applies) {
		this.applies = applies;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "activity")
	public List<RentDetail> getRentDetails() {
		return this.rentDetails;
	}

	public void setRentDetails(List<RentDetail> rentDetails) {
		this.rentDetails = rentDetails;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "activity")
	public List<Routing> getRoutings() {
		return this.routings;
	}

	public void setRoutings(List<Routing> routings) {
		this.routings = routings;
	}

}