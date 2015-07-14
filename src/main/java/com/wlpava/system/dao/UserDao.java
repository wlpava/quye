/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wlpava.system.entity.User;

/**
 * 系统管理->用户管理Dao
 * 
 * @author wenlp
 */
public interface UserDao extends PagingAndSortingRepository<User, Integer>, JpaSpecificationExecutor<User> {
	User findByLoginName(String operator);

	List<User> findByType(Integer userType);

	User findByPhone(String phone);

}
