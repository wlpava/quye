/****************************************************************** * Copyright (c) 2015 By Wlpava ******************************************************************/package com.wlpava.quye.dao;import org.springframework.data.jpa.repository.JpaSpecificationExecutor;import org.springframework.data.repository.PagingAndSortingRepository;import com.wlpava.quye.entity.Rent;/** * XXX管理->XXX管理Dao *  * @author wenlp */public interface RentDao extends PagingAndSortingRepository<Rent, Integer>, JpaSpecificationExecutor<Rent> {	// 示例//	Rent findByName(String name);}