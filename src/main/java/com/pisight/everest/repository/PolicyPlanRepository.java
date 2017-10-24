package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.constants.QueryConstant;
import com.pisight.everest.entities.PolicyPlan;


@Repository
@RepositoryRestResource(exported = false)
public interface PolicyPlanRepository extends CrudRepository<PolicyPlan, UUID>{

	List<PolicyPlan> findAll();
	
	@Query(QueryConstant.GET_POLICY_PLANS_BY_CARRIER_ID)
	List<PolicyPlan> fetchPolicyPlansByCarrierId(@Param("carrierId") UUID carrierId);

	@Query(QueryConstant.GET_POLICY_PLANS_BY_NAME)
	PolicyPlan fetchPolicyPlansByName(@Param("name")String name);

	PolicyPlan findByProcessId(String id);

	@Transactional
	List<PolicyPlan> deleteByProcessId(String id);
	
}
