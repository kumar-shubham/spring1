package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeCertificationDetails;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeCertificationRepo extends CrudRepository<EmployeeCertificationDetails, UUID> {
	List<EmployeeCertificationDetails> findAll();

	EmployeeCertificationDetails findByProcessId(String id);

	@Transactional
	List<EmployeeCertificationDetails> deleteByProcessId(String id);
}
