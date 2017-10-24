package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.PolicyPlanTerm;

@Repository
@RepositoryRestResource(exported = false)
public interface PolicyPlanTermRepository extends CrudRepository<PolicyPlanTerm, UUID>{

	List<PolicyPlanTerm> findAll();
	
	PolicyPlanTerm findByProcessId(String id);

	@Transactional
	List<PolicyPlanTerm> deleteByProcessId(String id);

}
