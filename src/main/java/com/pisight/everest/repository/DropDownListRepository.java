package com.pisight.everest.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pisight.everest.constants.QueryConstant;
import com.pisight.everest.entities.DropDownList;

@Repository
@RepositoryRestResource(exported = false)
public interface DropDownListRepository extends CrudRepository<DropDownList, UUID> {
	List<DropDownList> findAll();

	@Query(QueryConstant.GET_DROPDOWNLIST_BY_TYPE_VALUE)
	DropDownList fetchDropDownList(@Param("type") String type, @Param("value") String value);

	DropDownList findByProcessId(String id);

	@Transactional
	void deleteByProcessId(String id);

	@Modifying
	@Query("UPDATE DropDownList ddl SET c.value = :value WHERE c.type = :type")
	int updateDropDownList(@Param("type") int companyId, @Param("value") String address);

}
