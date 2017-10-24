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
import com.pisight.everest.entities.Employee;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends CrudRepository<Employee, UUID>{

	List<Employee> findAll();
	
	@Query(QueryConstant.GET_EMPLOYEE_BY_USER_ID)
	Employee fetchEmployeeByUserId(@Param("userId") UUID userId);

	@Query(QueryConstant.GET_EMPLOYEE_BY_EMP_ID)
	Employee fetchEmployeeByEmpId(@Param("empId") String empId);

	Employee findByProcessId(String id);

	@Transactional
	List<Employee> deleteByProcessId(String id);
}
