package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.pisight.everest.entities.PolicyRider;

public interface PolicyRiderRepo extends CrudRepository<PolicyRider, UUID> {
	List<PolicyRider> findAll();

	PolicyRider findByProcessId(String id);

	@Transactional
	List<PolicyRider> deleteByProcessId(String id);
}
