package com.pisight.everest.dto;

import java.util.UUID;

public class IndividualClientHouseHoldMemberDTO {
	
	private UUID id;
	
	private String householdId;
	
	private String  memberName;
	
	private double  premium;
	
	private boolean head;

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
	 * @return the householdId
	 */
	public String getHouseholdId() {
		return householdId;
	}

	/**
	 * @param householdId the householdId to set
	 */
	public void setHouseholdId(String householdId) {
		this.householdId = householdId;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the policyPremium
	 */
	public double getPremium() {
		return premium;
	}

	/**
	 * @param policyPremium the policyPremium to set
	 */
	public void setPremium(double premium) {
		this.premium = premium;
	}

	/**
	 * @return the head
	 */
	public boolean isHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(boolean head) {
		this.head = head;
	}
}
