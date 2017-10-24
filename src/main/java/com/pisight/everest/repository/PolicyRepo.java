package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.pisight.everest.entities.Policy;
import com.pisight.everest.entities.PolicyPlan;

public interface PolicyRepo extends CrudRepository<Policy, UUID> {
	
	List<Policy> findAll();
	
	Policy findByPolicyPlan(PolicyPlan plan);

	Policy findByProcessId(String id);

	@Transactional
	List<Policy> deleteByProcessId(String id);

}
