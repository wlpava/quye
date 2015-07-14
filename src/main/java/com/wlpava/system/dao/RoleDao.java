/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wlpava.system.entity.Role;

/**
 * 系统管理->角色管理Dao
 * 
 * @author wenlp
 */
public interface RoleDao extends PagingAndSortingRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
	Role findByName(String name);

}