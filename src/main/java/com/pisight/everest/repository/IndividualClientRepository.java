package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.IndividualClient;

@Repository
@RepositoryRestResource(exported = false)
public interface IndividualClientRepository extends CrudRepository<IndividualClient, UUID>{

	List<IndividualClient> findAll();

	IndividualClient findByProcessId(String id);

	@Transactional
	List<IndividualClient> deleteByProcessId(String id);
	
}
