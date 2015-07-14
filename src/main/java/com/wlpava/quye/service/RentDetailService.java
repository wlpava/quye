/****************************************************************** * Copyright (c) 2015 By Wlpava ******************************************************************/package com.wlpava.quye.service;import java.util.List;import java.util.Map;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.data.domain.Page;import org.springframework.data.domain.PageRequest;import org.springframework.data.jpa.domain.Specification;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import com.wlpava.core.web.DynamicSpecifications;import com.wlpava.core.web.SearchFilter;import com.wlpava.quye.QuyeService;import com.wlpava.quye.entity.RentDetail;/** * XXX管理->XXX管理Service *  * @author wenlp */@Service@Transactional(readOnly = true)public class RentDetailService extends QuyeService {	private static Logger log = LoggerFactory.getLogger(RentDetailService.class);	public Page<RentDetail> getPageable(Map<String, Object> searchParams, Integer pageNumber, Integer pageSize) {		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);		Specification<RentDetail> specification = DynamicSpecifications.bySearchFilter(filters.values(), RentDetail.class);		return quyeDaos.rentDetailDao.findAll(specification, pageRequest);	}	public RentDetail findOne(Integer rentDetailId) {		return quyeDaos.rentDetailDao.findOne(rentDetailId);	}	public List<RentDetail> findAll() {		return (List<RentDetail>) quyeDaos.rentDetailDao.findAll();	}		@Transactional(readOnly = false)	public RentDetail create(RentDetail rentDetail) {		return quyeDaos.rentDetailDao.save(rentDetail);	}	@Transactional(readOnly = false)	public RentDetail update(RentDetail rentDetail) {		return quyeDaos.rentDetailDao.save(rentDetail);	}	@Transactional(readOnly = false)	public void delete(Integer rentDetailId) {		quyeDaos.rentDetailDao.delete(rentDetailId);	}}