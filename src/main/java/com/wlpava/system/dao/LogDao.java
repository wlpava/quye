/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wlpava.system.entity.Log;

/**
 * 系统管理->日志管理Dao
 * 
 * @author wenlp
 */
public interface LogDao extends PagingAndSortingRepository<Log, Integer>, JpaSpecificationExecutor<Log> {

	Log findByOperator(String operator);

}
