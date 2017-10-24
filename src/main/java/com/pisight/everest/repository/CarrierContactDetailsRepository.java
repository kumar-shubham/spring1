package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.CarrierAddressDetails;
import com.pisight.everest.entities.CarrierContactDetails;
@Repository
@RepositoryRestResource(exported = false)
public interface CarrierContactDetailsRepository extends CrudRepository<CarrierContactDetails, UUID> {
	List<CarrierContactDetails> findAll();
	
	CarrierContactDetails findByProcessId(String id);

	@Transactional
	List<CarrierContactDetails> deleteByProcessId(String id);
}


