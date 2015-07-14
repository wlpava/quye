/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wlpava.system.entity.Config;

/**
 * 系统管理->配置管理Dao
 * 
 * @author wenlp
 */
public interface ConfigDao extends PagingAndSortingRepository<Config, Integer>, JpaSpecificationExecutor<Config> {
	Config findByName(String name);

	Config findByCode(String code);

}