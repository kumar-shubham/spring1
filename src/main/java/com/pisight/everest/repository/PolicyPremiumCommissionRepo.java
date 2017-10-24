package com.pisight.everest.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.pisight.everest.entities.PolicyPremiumCommission;

public interface PolicyPremiumCommissionRepo extends CrudRepository<PolicyPremiumCommission, UUID>{

	PolicyPremiumCommission findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);

}
