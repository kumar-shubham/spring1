package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.entities.HouseholdMember;

@Repository
@RepositoryRestResource(exported = false)
public interface HouseholdMemberRepository extends CrudRepository<HouseholdMember, UUID>{

	List<HouseholdMember> findAll();

	HouseholdMember findByProcessId(String id);

	@Transactional
	List<HouseholdMember> deleteByProcessId(String id);
}
