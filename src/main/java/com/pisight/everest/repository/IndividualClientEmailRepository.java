package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.IndividualClientEmail;

@Repository
@RepositoryRestResource(exported = false)
public interface IndividualClientEmailRepository extends CrudRepository<IndividualClientEmail, UUID> {

	List<IndividualClientEmail> findAll();

	IndividualClientEmail findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);

}
