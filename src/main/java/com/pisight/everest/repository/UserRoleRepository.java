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
import com.pisight.everest.entities.CarrierAddressDetails;
import com.pisight.everest.entities.UserRole;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRoleRepository extends CrudRepository<UserRole, UUID>{

	List<UserRole> findAll();
	
	@Query(QueryConstant.GET_USER_ROLE_BY_ROLE)
	UserRole fetchUserRoleByUserRole(@Param("role") String role);
	
	UserRole findByProcessId(String id);

	@Transactional
	List<UserRole> deleteByProcessId(String id);
}
