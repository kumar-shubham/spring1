package com.pisight.everest.repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.constants.QueryConstant;
import com.pisight.everest.entities.AdvisorIndividualClientMap;

@Repository
@RepositoryRestResource(exported = false)
public interface AdvisorIndividualClientMapRepo extends CrudRepository<AdvisorIndividualClientMap, UUID> {

	List<AdvisorIndividualClientMap> findAll();

	@Query(QueryConstant.GET_IND_CLIENT_MAP_BY_ADVISOR_ID)
	Set<AdvisorIndividualClientMap> fetchAdvisorIndividualClientMap(@Param("advisorId") UUID advisorid);

	AdvisorIndividualClientMap findByProcessId(String id);

	@Transactional
	Set<AdvisorIndividualClientMap> deleteByProcessId(String id);
}
