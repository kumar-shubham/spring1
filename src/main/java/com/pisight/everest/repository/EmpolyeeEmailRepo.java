package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeEmails;

@Repository
@RepositoryRestResource(exported = false)
public interface EmpolyeeEmailRepo extends CrudRepository<EmployeeEmails, UUID> {
	List<EmployeeEmails> findAll();

	EmployeeEmails findByProcessId(String id);

	@Transactional
	List<EmployeeEmails> deleteByProcessId(String id);

}
