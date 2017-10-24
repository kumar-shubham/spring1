package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeAddresses;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeAddressRepo extends CrudRepository<EmployeeAddresses, UUID> {
	List<EmployeeAddresses> findAll();

	EmployeeAddresses findByProcessId(String id);

	@Transactional
	List<EmployeeAddresses> deleteByProcessId(String id);

}
