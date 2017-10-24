package com.pisight.everest.dto;

import java.util.Date;

public class AdvisorAdditionDetailDTO {

	private String ContractId;
	
	private String  advisoryGroup;
	
	private AdvisorVestingRightDTO advisorVestingRights;
	
	private Date effectiveDateOfTransPenalty;
	
	private DropDownDTO yearOfTransPenalty;
	
	private Date expirationDateOfTransPenalty;
	
	private DropDownDTO joinedCompetitor;
	
	private Date lastCommisionDate;
	
	private DropDownDTO selectedFAR;
	
	private String BSCscore;
	
	private String advisoryGroupId;

	/**
	 * @return the contractId
	 */
	public String getContractId() {
		return ContractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(String contractId) {
		ContractId = contractId;
	}

	/**
	 * @return the advisoryGroup
	 */
	public String getAdvisoryGroup() {
		return advisoryGroup;
	}

	/**
	 * @param advisoryGroup the advisoryGroup to set
	 */
	public void setAdvisoryGroup(String advisoryGroup) {
		this.advisoryGroup = advisoryGroup;
	}


	/**
	 * @return the advisorVestingRights
	 */
	public AdvisorVestingRightDTO getAdvisorVestingRights() {
		return advisorVestingRights;
	}

	/**
	 * @param advisorVestingRights the advisorVestingRights to set
	 */
	public void setAdvisorVestingRights(AdvisorVestingRightDTO advisorVestingRights) {
		this.advisorVestingRights = advisorVestingRights;
	}

	/**
	 * @return the effectiveDateOfTransPenalty
	 */
	public Date getEffectiveDateOfTransPenalty() {
		return effectiveDateOfTransPenalty;
	}

	/**
	 * @param effectiveDateOfTransPenalty the effectiveDateOfTransPenalty to set
	 */
	public void setEffectiveDateOfTransPenalty(Date effectiveDateOfTransPenalty) {
		this.effectiveDateOfTransPenalty = effectiveDateOfTransPenalty;
	}

	/**
	 * @return the expirationDateOfTransPenalty
	 */
	public Date getExpirationDateOfTransPenalty() {
		return expirationDateOfTransPenalty;
	}

	/**
	 * @param expirationDateOfTransPenalty the expirationDateOfTransPenalty to set
	 */
	public void setExpirationDateOfTransPenalty(Date expirationDateOfTransPenalty) {
		this.expirationDateOfTransPenalty = expirationDateOfTransPenalty;
	}

	
	/**
	 * @return the yearOfTransPenalty
	 */
	public DropDownDTO getYearOfTransPenalty() {
		return yearOfTransPenalty;
	}

	/**
	 * @param yearOfTransPenalty the yearOfTransPenalty to set
	 */
	public void setYearOfTransPenalty(DropDownDTO yearOfTransPenalty) {
		this.yearOfTransPenalty = yearOfTransPenalty;
	}

	/**
	 * @return the joinedCompetitor
	 */
	public DropDownDTO getJoinedCompetitor() {
		return joinedCompetitor;
	}

	/**
	 * @param joinedCompetitor the joinedCompetitor to set
	 */
	public void setJoinedCompetitor(DropDownDTO joinedCompetitor) {
		this.joinedCompetitor = joinedCompetitor;
	}

	/**
	 * @return the lastCommisionDate
	 */
	public Date getLastCommisionDate() {
		return lastCommisionDate;
	}

	/**
	 * @param lastCommisionDate the lastCommisionDate to set
	 */
	public void setLastCommisionDate(Date lastCommisionDate) {
		this.lastCommisionDate = lastCommisionDate;
	}

	/**
	 * @return the selectedFAR
	 */
	public DropDownDTO getSelectedFAR() {
		return selectedFAR;
	}

	/**
	 * @param selectedFAR the selectedFAR to set
	 */
	public void setSelectedFAR(DropDownDTO selectedFAR) {
		this.selectedFAR = selectedFAR;
	}

	/**
	 * @return the bSCscore
	 */
	public String getBSCscore() {
		return BSCscore;
	}

	/**
	 * @param bSCscore the bSCscore to set
	 */
	public void setBSCscore(String bSCscore) {
		BSCscore = bSCscore;
	}
	/**
	 * @return the advisoryGroupId
	 */
	public String getAdvisoryGroupId() {
		return advisoryGroupId;
	}

	/**
	 * @param advisoryGroupId the advisoryGroupId to set
	 */
	public void setAdvisoryGroupId(String advisoryGroupId) {
		this.advisoryGroupId = advisoryGroupId;
	}
}
