package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name="advisor_rider_premium_commission")
public class AdvisorRiderPremiumCommission implements Serializable {
	
	private static final long serialVersionUID = 5408896547561945962L;


	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	
	@ManyToOne
	@JoinColumn(name="advisor_premium_commission_id")
	private AdvisorPremiumCommission advisorPremiumCommission;
	
	@ManyToOne
	@JoinColumn(name="policy_rider_premium_id")
	private PolicyRiderPremium policyRiderPremium;
	
	@Column(name="final_commission")
	private String finalCommission;
	
	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@Column(name = "status", nullable = false, columnDefinition = "bit(1) default 1")
	private boolean status;
	
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
	 * @return the advisorPremiumCommission
	 */
	public AdvisorPremiumCommission getAdvisorPremiumCommission() {
		return advisorPremiumCommission;
	}

	/**
	 * @param advisorPremiumCommission the advisorPremiumCommission to set
	 */
	public void setAdvisorPremiumCommission(AdvisorPremiumCommission advisorPremiumCommission) {
		this.advisorPremiumCommission = advisorPremiumCommission;
	}

	/**
	 * @return the policyRiderPremium
	 */
	public PolicyRiderPremium getPolicyRiderPremium() {
		return policyRiderPremium;
	}

	/**
	 * @param policyRiderPremium the policyRiderPremium to set
	 */
	public void setPolicyRiderPremium(PolicyRiderPremium policyRiderPremium) {
		this.policyRiderPremium = policyRiderPremium;
	}

	/**
	 * @return the finalCommission
	 */
	public String getFinalCommission() {
		return finalCommission;
	}

	/**
	 * @param finalCommission the finalCommission to set
	 */
	public void setFinalCommission(String finalCommission) {
		this.finalCommission = finalCommission;
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
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
