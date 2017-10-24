package com.pisight.everest.dto;

import java.util.UUID;

public class PolicyAdvisorDTO {

	private UUID id;
	
	private String advisorRole;
	
	private String commissionPercent;

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
	 * @return the advisorRole
	 */
	public String getAdvisorRole() {
		return advisorRole;
	}

	/**
	 * @param advisorRole the advisorRole to set
	 */
	public void setAdvisorRole(String advisorRole) {
		this.advisorRole = advisorRole;
	}

	/**
	 * @return the commissionPercent
	 */
	public String getCommissionPercent() {
		return commissionPercent;
	}

	/**
	 * @param commissionPercent the commissionPercent to set
	 */
	public void setCommissionPercent(String commissionPercent) {
		this.commissionPercent = commissionPercent;
	}
	
	
}
