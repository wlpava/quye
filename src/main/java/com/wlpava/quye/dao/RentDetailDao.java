/****************************************************************** * Copyright (c) 2015 By Wlpava ******************************************************************/package com.wlpava.quye.dao;import org.springframework.data.jpa.repository.JpaSpecificationExecutor;import org.springframework.data.repository.PagingAndSortingRepository;import com.wlpava.quye.entity.RentDetail;/** * XXX管理->XXX管理Dao *  * @author wenlp */public interface RentDetailDao extends PagingAndSortingRepository<RentDetail, Integer>, JpaSpecificationExecutor<RentDetail> {	// 示例//	RentDetail findByName(String name);}