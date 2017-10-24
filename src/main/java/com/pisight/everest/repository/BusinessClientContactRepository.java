package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.BusinessClientContact;
import com.pisight.everest.entities.CarrierAddressDetails;

@Repository
@RepositoryRestResource(exported = false)
public interface BusinessClientContactRepository extends CrudRepository<BusinessClientContact, UUID> {
	
	List<BusinessClientContact> findAll();
	
	BusinessClientContact findByProcessId(String id);

	@Transactional
	List<BusinessClientContact> deleteByProcessId(String id);
}

