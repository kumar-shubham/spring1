package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name="policy_premium_commission")
public class PolicyPremiumCommission implements Serializable {

	private static final long serialVersionUID = -7766416078108026604L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@OneToOne
	@JoinColumn(name="policyPremium")
	private PolicyPremium policyPremium;
	
	@Column(name = "plan_commission", nullable = false)
	private String planCommission;
	
	@Column(name = "rider_commission", nullable = false)
	private String riderCommission;
	
	@Column(name = "createdAt", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
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
	 * @return the policyPremium
	 */
	public PolicyPremium getPremium() {
		return policyPremium;
	}

	/**
	 * @param policyPremium the policyPremium to set
	 */
	public void setPremium(PolicyPremium policyPremium) {
		this.policyPremium = policyPremium;
	}

	/**
	 * @return the planCommission
	 */
	public String getPlanCommission() {
		return planCommission;
	}

	/**
	 * @param planCommission the planCommission to set
	 */
	public void setPlanCommission(String planCommission) {
		this.planCommission = planCommission;
	}

	/**
	 * @return the riderCommission
	 */
	public String getRiderCommission() {
		return riderCommission;
	}

	/**
	 * @param riderCommission the riderCommission to set
	 */
	public void setRiderCommission(String riderCommission) {
		this.riderCommission = riderCommission;
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
	 * @return the policyPremium
	 */
	public PolicyPremium getPolicyPremium() {
		return policyPremium;
	}

	/**
	 * @param policyPremium the policyPremium to set
	 */
	public void setPolicyPremium(PolicyPremium policyPremium) {
		this.policyPremium = policyPremium;
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
