package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pisight.everest.entities.Policy;
import com.pisight.everest.entities.PolicyPremium;

public interface PolicyPremiumRepo extends CrudRepository<PolicyPremium, UUID>{

	PolicyPremium findByPolicyId(Policy policy);

	PolicyPremium findByProcessId(String id);

	@Transactional
	List<PolicyPremium> deleteByProcessId(String id);

}
