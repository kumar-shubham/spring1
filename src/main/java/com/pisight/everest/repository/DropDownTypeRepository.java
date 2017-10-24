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
import com.pisight.everest.entities.DropDownType;

@Repository
@RepositoryRestResource(exported = false)
public interface DropDownTypeRepository extends CrudRepository<DropDownType, UUID> {
	
	List<DropDownType> findAll();
	
	@Query(QueryConstant.GET_DROPDOWNTYPE_BY_NAME)
	DropDownType fetchDropDownTypeByName(@Param("name") String name);

	DropDownType findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);

}
