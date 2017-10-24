package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.Rider;


@Repository
@RepositoryRestResource(exported = false)
public interface RiderRepository extends CrudRepository<Rider, UUID>{
	
	List<Rider> findAll();

	Rider findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);
	
}
