package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.AdvisoryGroup;

@Repository
@RepositoryRestResource(exported = false)
public interface AdvisoryGroupRepo extends CrudRepository<AdvisoryGroup, UUID> {
	List<AdvisoryGroup> findAll();

	AdvisoryGroup findByProcessId(String id);

	@Transactional
	List<AdvisoryGroup> deleteByProcessId(String id);
}
