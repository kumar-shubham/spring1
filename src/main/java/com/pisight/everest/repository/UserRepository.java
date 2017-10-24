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
import com.pisight.everest.entities.User;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, UUID>{

	List<User> findAll();
	
	
	@Query(QueryConstant.GET_USER_BY_USERNAME)
	User fetchUserByUserName(@Param("username") String username);
	
	@Query(QueryConstant.GET_USER_BY_EMAIL)
	User fetchUserByEmail(@Param("email") String email);


	User findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);

	
}

