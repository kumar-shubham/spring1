package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.EmployeeAwardsAndAchievements;

@Repository
@RepositoryRestResource(exported = false)
public interface EmployeeAwardsAndAchivementRepo  extends CrudRepository<EmployeeAwardsAndAchievements, UUID>{
	List<EmployeeAwardsAndAchievements> findAll();

	EmployeeAwardsAndAchievements findByProcessId(String id);

	@Transactional
	List<EmployeeAwardsAndAchievements> deleteByProcessId(String id);
	
}
