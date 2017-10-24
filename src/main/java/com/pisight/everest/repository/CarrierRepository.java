package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.constants.QueryConstant;
import com.pisight.everest.entities.Carrier;

@Repository
@RepositoryRestResource(exported = false)
public interface CarrierRepository extends CrudRepository<Carrier, UUID>{

	List<Carrier> findAll();
	
	@Query(QueryConstant.GET_CARRIER_BY_NAME)
	Carrier fetchCarrierByName(@Param("name") String name);
	
	@Query(QueryConstant.GET_CARRIER_BY_ABBR)
	Carrier fetchCarrierByAbbr(@Param("abbreviation") String abbreviation);

	Carrier findByProcessId(String id);

	@Transactional
	List<Carrier> deleteByProcessId(String id);
}
