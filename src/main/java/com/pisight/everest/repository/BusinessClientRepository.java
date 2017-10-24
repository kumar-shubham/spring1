package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.BusinessClient;


@Repository
@RepositoryRestResource(exported = false)
public interface BusinessClientRepository extends CrudRepository<BusinessClient, UUID>{
	List<BusinessClient> findAll();

	BusinessClient findByProcessId(String id);

	@Transactional
	List<BusinessClient> deleteByProcessId(String id);
}
