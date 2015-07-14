package com.wlpava.quye.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wlpava.core.persistence.BaseEntity;

/**
 * 行程实体类
 * 
 * @author wenlp
 */
@Entity
@Table(name = "routing", catalog = "quye")
public class Routing extends BaseEntity<Integer> {

	private Activity activity;
	private Date routingDate;
	private String way;
	private String dinner;
	private String stay;
	private String description;
	private String scenery;

	// Constructors

	/** default constructor */
	public Routing() {
	}

	/** minimal constructor */
	public Routing(Activity activity, Date routingDate, String way,
			String dinner, String stay, String description) {
		this.activity = activity;
		this.routingDate = routingDate;
		this.way = way;
		this.dinner = dinner;
		this.stay = stay;
		this.description = description;
	}

	/** full constructor */
	public Routing(Activity activity, Date routingDate, String way,
			String dinner, String stay, String description, String scenery) {
		this.activity = activity;
		this.routingDate = routingDate;
		this.way = way;
		this.dinner = dinner;
		this.stay = stay;
		this.description = description;
		this.scenery = scenery;
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

	public Date getRoutingDate() {
		return this.routingDate;
	}

	public void setRoutingDate(Date routingDate) {
		this.routingDate = routingDate;
	}

	public String getWay() {
		return this.way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getDinner() {
		return this.dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getStay() {
		return this.stay;
	}

	public void setStay(String stay) {
		this.stay = stay;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScenery() {
		return this.scenery;
	}

	public void setScenery(String scenery) {
		this.scenery = scenery;
	}

}