package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.pisight.everest.entities.AdvisoryGroupAdvisorMap;

@Repository
@RepositoryRestResource(exported = false)
public interface AdvisoryGroupAdvisorMapRepo extends CrudRepository<AdvisoryGroupAdvisorMap, UUID> {

	List<AdvisoryGroupAdvisorMap> findAll();

	AdvisoryGroupAdvisorMap findByProcessId(String id);

	@Transactional
	List<AdvisoryGroupAdvisorMap> deleteByProcessId(String id);

}
