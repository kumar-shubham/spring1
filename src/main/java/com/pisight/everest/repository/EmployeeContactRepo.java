package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeContactNumbers;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeContactRepo extends CrudRepository<EmployeeContactNumbers, UUID> {
	List<EmployeeContactNumbers> findAll();

	EmployeeContactNumbers findByProcessId(String id);

	@Transactional
	List<EmployeeContactNumbers> deleteByProcessId(String id);

}
