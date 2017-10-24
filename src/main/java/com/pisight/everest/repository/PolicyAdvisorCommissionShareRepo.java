package com.pisight.everest.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pisight.everest.entities.Advisor;
import com.pisight.everest.entities.PolicyAdvisorCommissionShare;

public interface PolicyAdvisorCommissionShareRepo extends CrudRepository<PolicyAdvisorCommissionShare, UUID>{

	PolicyAdvisorCommissionShare findPolicyAdvisorCommissionShareByAdvisorId(Advisor advisor);

	PolicyAdvisorCommissionShare findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);

}
