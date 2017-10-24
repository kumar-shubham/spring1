package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.constants.QueryConstant;
import com.pisight.everest.entities.RiderCommissionRate;

@Repository
@RepositoryRestResource(exported = false)
public interface RiderCommissionRateRepository extends CrudRepository<RiderCommissionRate, UUID>{

	List<RiderCommissionRate> findAll();

	
	@Query(QueryConstant.GET_RIDERCOMMISIONRATE_BY_POLICYPLAN_ID)
	List<RiderCommissionRate> fetchCommisionRates(@Param("riderId")UUID planRider);
	
	RiderCommissionRate findByProcessId(String id);

	@Transactional
	List<RiderCommissionRate> deleteByProcessId(String id);
}
