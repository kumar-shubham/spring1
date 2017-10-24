package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.AdditionalContactDetails;

@Repository
@RepositoryRestResource(exported = false)
public interface AdditionalContactDetailsRepository extends CrudRepository<AdditionalContactDetails, UUID> {
	
	List<AdditionalContactDetails> findAll();

	AdditionalContactDetails findByProcessId(String id);

	@Transactional
	List<AdditionalContactDetails> deleteByProcessId(String id);
}
