package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.BusinessClientAddress;

@Repository
@RepositoryRestResource(exported = false)
public interface BusinessClientAddressRepository extends CrudRepository<BusinessClientAddress, UUID> {

	List<BusinessClientAddress> findAll();

	BusinessClientAddress findByProcessId(String id);

	@Transactional
	List<BusinessClientAddress> deleteByProcessId(String id);
}
