package com.pisight.everest.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pisight.everest.entities.PolicyRiderPremium;

public interface PolicyRiderPremiumRepo extends CrudRepository<PolicyRiderPremium, UUID>{
	
	PolicyRiderPremium findByProcessId(String id);

	@Transactional
	List<PolicyRiderPremium> deleteByProcessId(String id);
}
