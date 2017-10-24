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
import com.pisight.everest.entities.Department;

@Repository
@RepositoryRestResource(exported = false)
public interface DepartmentRepository extends CrudRepository<Department, UUID> {
	List<Department> findAll();
	
	@Query(QueryConstant.GET_DEPT_BY_NAME)
	Department fetchDeptByName(@Param("name") String name);
	
	@Query(QueryConstant.GET_DEPT_BY_DEPT_ID)
	Department fetchDeptByDeptId(@Param("deptId") String deptId);

	Department findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);
	
}
