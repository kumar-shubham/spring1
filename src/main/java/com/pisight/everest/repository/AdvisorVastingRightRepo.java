package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.AdvisorVestingRights;

@Repository
@RepositoryRestResource(exported = false)
public interface AdvisorVastingRightRepo extends CrudRepository<AdvisorVestingRights, UUID> {
	List<AdvisorVestingRights> findAll();

	AdvisorVestingRights findByProcessId(String id);

	@Transactional
	List<AdvisorVestingRights> deleteByProcessId(String id);

}
