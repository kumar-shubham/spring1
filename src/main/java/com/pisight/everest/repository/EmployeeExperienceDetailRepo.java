package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeExperienceDetails;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeExperienceDetailRepo extends CrudRepository<EmployeeExperienceDetails, UUID> {
	List<EmployeeExperienceDetails> findAll();

	EmployeeExperienceDetails findByProcessId(String id);

	@Transactional
	List<EmployeeExperienceDetails> deleteByProcessId(String id);

}
