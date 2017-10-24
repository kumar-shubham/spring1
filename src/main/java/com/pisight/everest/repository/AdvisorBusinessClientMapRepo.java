package com.pisight.everest.repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pisight.everest.constants.QueryConstant;
import com.pisight.everest.entities.AdvisorBusinessClientMap;

public interface AdvisorBusinessClientMapRepo extends CrudRepository<AdvisorBusinessClientMap, UUID> {

	List<AdvisorBusinessClientMap> findAll();

	@Query(QueryConstant.GET_BUSINESS_CLIENT_MAP_BY_ADVISOR_ID)
	Set<AdvisorBusinessClientMap> fetchAdvisorBusinessClientMap(@Param("advisorId") UUID advisorid);

	AdvisorBusinessClientMap findByProcessId(String id);

	@Transactional
	Set<AdvisorBusinessClientMap> deleteByProcessId(String id);
}
