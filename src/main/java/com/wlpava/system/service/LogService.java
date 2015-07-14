/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlpava.core.web.DynamicSpecifications;
import com.wlpava.core.web.SearchFilter;
import com.wlpava.system.BaseService;
import com.wlpava.system.entity.Log;

/**
 * 系统管理->日志管理Service
 * 
 * @author wenlp
 */
@Service
@Transactional(readOnly = true)
public class LogService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(LogService.class);

	public Page<Log> getPageable(Map<String, Object> searchParams, int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<Log> spec = DynamicSpecifications.bySearchFilter(filters.values(), Log.class);
		return systemDaos.logDao.findAll(spec, pageRequest);
	}

	@Transactional(readOnly = false)
	public Log save(Log log) {
		return systemDaos.logDao.save(log);
	}

}
