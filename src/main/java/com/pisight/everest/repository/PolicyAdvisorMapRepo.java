package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pisight.everest.entities.PolicyAdvisorMap;

public interface PolicyAdvisorMapRepo extends CrudRepository<PolicyAdvisorMap, UUID> {
	List<PolicyAdvisorMap> findAll();

	PolicyAdvisorMap findByProcessId(String id);

	@Transactional
	List<PolicyAdvisorMap> deleteByProcessId(String id);
}
