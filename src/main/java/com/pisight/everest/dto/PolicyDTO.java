package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PolicyDTO {

	private String id;

	private UUID policyPlanId;
	
	private UUID policyPlanTermId;
	
	private int numberOfPremiums;

	private Date effectiveDate;

	private DropDownDTO status;

	private Date statusDate;

	private UUID primaryAdvisorId;
	
	private List<PolicyAdvisorDTO> allAdvisors = new ArrayList<PolicyAdvisorDTO>();

	private String buyerType;
	
	private UUID buyerId;
	
	private String insuredType;
	
	private UUID insuredId;
	
	private UUID advisoryGroupId;
	
	private String premiumFrequency;
	
	private String basicFaceValue;
	
	private String numberOfPremiumPaid;
	
	private boolean BSCapplied;
	
	private List<UUID> riders = new ArrayList<UUID>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the policyPlanId
	 */
	public UUID getPolicyPlanId() {
		return policyPlanId;
	}

	/**
	 * @param policyPlanId the policyPlanId to set
	 */
	public void setPolicyPlanId(UUID policyPlanId) {
		this.policyPlanId = policyPlanId;
	}

	/**
	 * @return the policyPlanTermId
	 */
	public UUID getPolicyPlanTermId() {
		return policyPlanTermId;
	}

	/**
	 * @param policyPlanTermId the policyPlanTermId to set
	 */
	public void setPolicyPlanTermId(UUID policyPlanTermId) {
		this.policyPlanTermId = policyPlanTermId;
	}

	/**
	 * @return the numberOfPremiums
	 */
	public int getNumberOfPremiums() {
		return numberOfPremiums;
	}

	/**
	 * @param numberOfPremiums the numberOfPremiums to set
	 */
	public void setNumberOfPremiums(int numberOfPremiums) {
		this.numberOfPremiums = numberOfPremiums;
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
	 * @return the status
	 */
	public DropDownDTO getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(DropDownDTO status) {
		this.status = status;
	}

	/**
	 * @return the statusDate
	 */
	public Date getStatusDate() {
		return statusDate;
	}

	/**
	 * @param statusDate the statusDate to set
	 */
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	/**
	 * @return the primaryAdvisorId
	 */
	public UUID getPrimaryAdvisorId() {
		return primaryAdvisorId;
	}

	/**
	 * @param primaryAdvisorId the primaryAdvisorId to set
	 */
	public void setPrimaryAdvisorId(UUID primaryAdvisorId) {
		this.primaryAdvisorId = primaryAdvisorId;
	}

	/**
	 * @return the allAdvisors
	 */
	public List<PolicyAdvisorDTO> getAllAdvisors() {
		return allAdvisors;
	}

	/**
	 * @param allAdvisors the allAdvisors to set
	 */
	public void setAllAdvisors(List<PolicyAdvisorDTO> allAdvisors) {
		this.allAdvisors = allAdvisors;
	}

	/**
	 * @return the buyerType
	 */
	public String getBuyerType() {
		return buyerType;
	}

	/**
	 * @param buyerType the buyerType to set
	 */
	public void setBuyerType(String buyerType) {
		this.buyerType = buyerType;
	}

	/**
	 * @return the buyerId
	 */
	public UUID getBuyerId() {
		return buyerId;
	}

	/**
	 * @param buyerId the buyerId to set
	 */
	public void setBuyerId(UUID buyerId) {
		this.buyerId = buyerId;
	}

	/**
	 * @return the insuredType
	 */
	public String getInsuredType() {
		return insuredType;
	}

	/**
	 * @param insuredType the insuredType to set
	 */
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	/**
	 * @return the insuredId
	 */
	public UUID getInsuredId() {
		return insuredId;
	}

	/**
	 * @param insuredId the insuredId to set
	 */
	public void setInsuredId(UUID insuredId) {
		this.insuredId = insuredId;
	}

	/**
	 * @return the advisoryGroupId
	 */
	public UUID getAdvisoryGroupId() {
		return advisoryGroupId;
	}

	/**
	 * @param advisoryGroupId the advisoryGroupId to set
	 */
	public void setAdvisoryGroupId(UUID advisoryGroupId) {
		this.advisoryGroupId = advisoryGroupId;
	}

	/**
	 * @return the premiumFrequency
	 */
	public String getPremiumFrequency() {
		return premiumFrequency;
	}

	/**
	 * @param premiumFrequency the premiumFrequency to set
	 */
	public void setPremiumFrequency(String premiumFrequency) {
		this.premiumFrequency = premiumFrequency;
	}

	/**
	 * @return the basicFaceValue
	 */
	public String getBasicFaceValue() {
		return basicFaceValue;
	}

	/**
	 * @param basicFaceValue the basicFaceValue to set
	 */
	public void setBasicFaceValue(String basicFaceValue) {
		this.basicFaceValue = basicFaceValue;
	}

	/**
	 * @return the numberOfPremiumPaid
	 */
	public String getNumberOfPremiumPaid() {
		return numberOfPremiumPaid;
	}

	/**
	 * @param numberOfPremiumPaid the numberOfPremiumPaid to set
	 */
	public void setNumberOfPremiumPaid(String numberOfPremiumPaid) {
		this.numberOfPremiumPaid = numberOfPremiumPaid;
	}

	/**
	 * @return the bSCapplied
	 */
	public boolean isBSCapplied() {
		return BSCapplied;
	}

	/**
	 * @param bSCapplied the bSCapplied to set
	 */
	public void setBSCapplied(boolean bSCapplied) {
		BSCapplied = bSCapplied;
	}

	/**
	 * @return the riders
	 */
	public List<UUID> getRiders() {
		return riders;
	}

	/**
	 * @param riders the riders to set
	 */
	public void setRiders(List<UUID> riders) {
		this.riders = riders;
	}
}
