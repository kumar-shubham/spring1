package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.PolicyPlanRider;


@Repository
@RepositoryRestResource(exported = false)
public interface PolicyPlanRiderRepository extends CrudRepository<PolicyPlanRider, UUID>{

	List<PolicyPlanRider> findAll();
	
	PolicyPlanRider findByProcessId(String id);

	@Transactional
	List<PolicyPlanRider> deleteByProcessId(String id);
}
