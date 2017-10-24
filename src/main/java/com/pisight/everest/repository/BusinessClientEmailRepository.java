package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.BusinessClientEmail;


@Repository
@RepositoryRestResource(exported = false)
public interface BusinessClientEmailRepository extends CrudRepository<BusinessClientEmail, UUID>{
	
	List<BusinessClientEmail> findAll();
	
	BusinessClientEmail findByProcessId(String id);

	@Transactional
	List<BusinessClientEmail> deleteByProcessId(String id);
}
