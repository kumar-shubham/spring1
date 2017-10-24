package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name="rider")
public class Rider implements Serializable{

	private static final long serialVersionUID = -713496197258814890L;
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rider", cascade=CascadeType.ALL)
	private Set<PolicyPlanRider> policyPlanRiders = new HashSet<PolicyPlanRider>();

	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the policyPlanRiders
	 */
	public Set<PolicyPlanRider> getPolicyPlanRiders() {
		return policyPlanRiders;
	}

	/**
	 * @param policyPlanRiders the policyPlanRiders to set
	 */
	public void setPolicyPlanRiders(Set<PolicyPlanRider> policyPlanRiders) {
		this.policyPlanRiders = policyPlanRiders;
	}

	/**
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return the entityStatus
	 */
	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	/**
	 * @param entityStatus the entityStatus to set
	 */
	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}
}
