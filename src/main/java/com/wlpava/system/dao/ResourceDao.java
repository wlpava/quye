/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wlpava.system.entity.Resource;

/**
 * 系统管理->资源管理Dao
 * 
 * @author wenlp
 */
public interface ResourceDao extends PagingAndSortingRepository<Resource, Integer>, JpaSpecificationExecutor<Resource> {
	@Override
	@Query(value = "select * from sys_resource order by id asc, concat(parent_ids, id) asc", nativeQuery = true)
	List<Resource> findAll();

	@Modifying
	@Query("delete from Resource c where c.parentIds like ?1")
	int deleteByParentIds(String parentIds);

}
