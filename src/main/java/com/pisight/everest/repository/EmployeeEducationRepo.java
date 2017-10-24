package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeEducationDetails;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeEducationRepo extends CrudRepository<EmployeeEducationDetails, UUID> {
	List<EmployeeEducationDetails> findAll();

	EmployeeEducationDetails findByProcessId(String id);

	@Transactional
	List<EmployeeEducationDetails> deleteByProcessId(String id);
}
