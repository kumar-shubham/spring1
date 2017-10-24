package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pisight.everest.entities.PolicyAdvisorMap;

public interface PolicyAdvisorRepo extends CrudRepository<PolicyAdvisorMap, UUID> {

	List<PolicyAdvisorMap> findAll();
	
	PolicyAdvisorRepo findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);
}
