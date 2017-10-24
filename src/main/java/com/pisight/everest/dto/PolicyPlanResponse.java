package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PolicyPlanResponse {
	
	private UUID id;
	
	private String name;
	
	private Date effectiveDate;
	
	private Date expirationDate;
	
	private boolean approved;
	
	private boolean active;
	
	private DropDownDTO planType;
	
	private List<PolicyPlanTermDTO> planTerms = new ArrayList<PolicyPlanTermDTO>();
	
	private Set<PolicyPlanRiderDTO> policyPlanRiders = new HashSet<PolicyPlanRiderDTO>();

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
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the planType
	 */
	public DropDownDTO getPlanType() {
		return planType;
	}

	/**
	 * @param planType the planType to set
	 */
	public void setPlanType(DropDownDTO planType) {
		this.planType = planType;
	}

	/**
	 * @return the planTerms
	 */
	public List<PolicyPlanTermDTO> getPlanTerms() {
		return planTerms;
	}

	/**
	 * @param planTerms the planTerms to set
	 */
	public void setPlanTerms(List<PolicyPlanTermDTO> planTerms) {
		this.planTerms = planTerms;
	}

	/**
	 * @return the policyPlanRiders
	 */
	public Set<PolicyPlanRiderDTO> getPolicyPlanRiders() {
		return policyPlanRiders;
	}

	/**
	 * @param policyPlanRiders the policyPlanRiders to set
	 */
	public void setPolicyPlanRiders(Set<PolicyPlanRiderDTO> policyPlanRiders) {
		this.policyPlanRiders = policyPlanRiders;
	}
}
