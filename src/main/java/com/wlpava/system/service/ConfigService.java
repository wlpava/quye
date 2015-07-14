/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.service;

import java.util.List;
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
import com.wlpava.system.entity.Config;

/**
 * 系统管理->配置管理Service
 * 
 * @author wenlp
 */
@Service
@Transactional(readOnly = true)
public class ConfigService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(ConfigService.class);

	public Page<Config> getPageable(Map<String, Object> searchParams, int pageNumber, int pageSize) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<Config> spec = DynamicSpecifications.bySearchFilter(filters.values(), Config.class);
		return systemDaos.configDao.findAll(spec, pageRequest);
	}

	@Transactional(readOnly = false)
	public Config create(Config resource) {
		return systemDaos.configDao.save(resource);
	}

	@Transactional(readOnly = false)
	public Config update(Config resource) {
		return systemDaos.configDao.save(resource);
	}

	@Transactional(readOnly = false)
	public void delete(Integer resourceId) {
		systemDaos.configDao.delete(resourceId);
	}

	public Config findOne(Integer resourceId) {
		return systemDaos.configDao.findOne(resourceId);
	}

	public List<Config> findAll() {
		return (List<Config>) systemDaos.configDao.findAll();
	}

	public Config findByName(String name) {
		return systemDaos.configDao.findByName(name);
	}

	public Config findByCode(String code) {
		return systemDaos.configDao.findByCode(code);
	}

	public String getStreamerPath() {
		return systemDaos.configDao.findByCode("streamer_ip").getValue() + ":" + systemDaos.configDao.findByCode("streamer_port").getValue() + "/"
				+ systemDaos.configDao.findByCode("streamer_root").getValue();
	}

	public String getValue(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
