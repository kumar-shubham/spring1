package com.pisight.everest.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name = "advisor_additional_details")
public class AdvisorAdditionalDetails implements Serializable {
	
	private static final long serialVersionUID = 1346762604843519018L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@OneToOne
	@JoinColumn(name = "advisor_id", unique = true, nullable = false, updatable = false)
	private Advisor advisor;
	
	
	@Column(name = "contract_Id")
	private String ContractId;
	
	@Column(name = "advisory_group")
	private String  advisoryGroup;
	
	
	@OneToOne(mappedBy = "advisorAdditonalDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AdvisorVestingRights advisorVestingRights;
	
	@Column(name = "effectiveDate_of_TransPenalty")
	private Date effectiveDateOfTransPenalty;
	
	@Column(name = "expirationDate_of_transPenalty")
	private Date expirationDateOfTransPenalty;
	
	@ManyToOne
	@JoinColumn(name = "expiry_year_of_transPenalty")
	private DropDownList expYearOfTransPenalty;
	
	@ManyToOne
	@JoinColumn(name = "joined_competitor")
	private DropDownList joinedCompetitor;
	
	@Column(name = "last_commision_date")
	private Date lastCommisionDate;
	
	@ManyToOne
	@JoinColumn(name = "selected_FAR")
	private DropDownList selectedFAR;
	
	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
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
	 * @return the advisor
	 */
	public Advisor getAdvisor() {
		return advisor;
	}

	/**
	 * @param advisor the advisor to set
	 */
	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

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
	public AdvisorVestingRights getAdvisorVestingRights() {
		return advisorVestingRights;
	}

	/**
	 * @param advisorVestingRights the advisorVestingRights to set
	 */
	public void setAdvisorVestingRights(AdvisorVestingRights advisorVestingRights) {
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
	 * @return the expYearOfTransPenalty
	 */
	public DropDownList getExpYearOfTransPenalty() {
		return expYearOfTransPenalty;
	}

	/**
	 * @param expYearOfTransPenalty the expYearOfTransPenalty to set
	 */
	public void setExpYearOfTransPenalty(DropDownList expYearOfTransPenalty) {
		this.expYearOfTransPenalty = expYearOfTransPenalty;
	}

	/**
	 * @param expirationDateOfTransPenalty the expirationDateOfTransPenalty to set
	 */
	public void setExpirationDateOfTransPenalty(Date expirationDateOfTransPenalty) {
		this.expirationDateOfTransPenalty = expirationDateOfTransPenalty;
	}

	/**
	 * @return the joinedCompetitor
	 */
	public DropDownList getJoinedCompetitor() {
		return joinedCompetitor;
	}

	/**
	 * @param joinedCompetitor the joinedCompetitor to set
	 */
	public void setJoinedCompetitor(DropDownList joinedCompetitor) {
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
	public DropDownList getSelectedFAR() {
		return selectedFAR;
	}

	/**
	 * @param selectedFAR the selectedFAR to set
	 */
	public void setSelectedFAR(DropDownList selectedFAR) {
		this.selectedFAR = selectedFAR;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
	public Constants.EntityStatus getEntityStatus() {
		return entityStatus;
	}

	/**
	 * @param entityStatus the entityStatus to set
	 */
	public void setEntityStatus(Constants.EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}
}
