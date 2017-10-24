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
import com.pisight.everest.entities.Advisor;

@Repository
@RepositoryRestResource(exported = false)
public interface AdvisorRepository extends CrudRepository<Advisor, UUID> {
	
	List<Advisor> findAll();
	
	@Query(QueryConstant.GET_ADVISOR_BY_EMP_ID)
	Advisor fetchAdvisorByEmployeeID(@Param("userId") String id);

	Advisor findByProcessId(String id);

	@Transactional
	List<Advisor> deleteByProcessId(String id);

}
