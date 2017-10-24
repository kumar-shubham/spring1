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

import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name="policy_rider_premium")
public class PolicyRiderPremium implements Serializable{

	private static final long serialVersionUID = 6411073414308488747L;
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "policy_premium_id", nullable = false)
	private PolicyPremium policyPremium;
	
	@ManyToOne
	@JoinColumn(name="policy_rider")
	private PolicyRider policyRider;
	
	@Column(name = "loading_premium", nullable = false)
	private String loadingPremium;
	
	@Column(name = "premium", nullable = false)
	private String premium;
	
	@Column(name = "commision_model_premium", nullable = false)
	private String commisionModelPremium;
	
	@Column(name = "annualized_model_premium", nullable = false)
	private String annualizedModelPremium;
	
	@Column(name = "commission_annualized_premium", nullable = false)
	private String commissionAnnualizedPremium;
	
	@Column(name = "commission", nullable = false)
	private String commission;
	
	@ManyToOne
	@JoinColumn(name = "rider_commission_rate_id", nullable = false)
	private RiderCommissionRate commissionRate;
	
	@ManyToOne
	@JoinColumn(name="status")
	private DropDownList status;
	
	@Column(name = "status_date", columnDefinition="TIMESTAMP NULL")
	private Date statusDate;
	
	@Column(name = "effective_date", columnDefinition="TIMESTAMP NULL")
	private Date effectiveDate;
	
	@ManyToOne
	@JoinColumn(name="previous_record")
	private PolicyRiderPremium previousRecord;
	
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
	 * @return the policyRider
	 */
	public PolicyRider getPolicyRider() {
		return policyRider;
	}

	/**
	 * @param policyRider the policyRider to set
	 */
	public void setPolicyRider(PolicyRider policyRider) {
		this.policyRider = policyRider;
	}

	/**
	 * @return the loadingPremium
	 */
	public String getLoadingPremium() {
		return loadingPremium;
	}

	/**
	 * @param loadingPremium the loadingPremium to set
	 */
	public void setLoadingPremium(String loadingPremium) {
		this.loadingPremium = loadingPremium;
	}

	/**
	 * @return the policyPremium
	 */
	public String getPremium() {
		return premium;
	}

	/**
	 * @param policyPremium the policyPremium to set
	 */
	public void setPremium(String premium) {
		this.premium = premium;
	}

	/**
	 * @return the commisionModelPremium
	 */
	public String getCommisionModelPremium() {
		return commisionModelPremium;
	}

	/**
	 * @param commisionModelPremium the commisionModelPremium to set
	 */
	public void setCommisionModelPremium(String commisionModelPremium) {
		this.commisionModelPremium = commisionModelPremium;
	}

	/**
	 * @return the annualizedModelPremium
	 */
	public String getAnnualizedModelPremium() {
		return annualizedModelPremium;
	}

	/**
	 * @param annualizedModelPremium the annualizedModelPremium to set
	 */
	public void setAnnualizedModelPremium(String annualizedModelPremium) {
		this.annualizedModelPremium = annualizedModelPremium;
	}

	/**
	 * @return the commissionAnnualizedPremium
	 */
	public String getCommissionAnnualizedPremium() {
		return commissionAnnualizedPremium;
	}

	/**
	 * @param commissionAnnualizedPremium the commissionAnnualizedPremium to set
	 */
	public void setCommissionAnnualizedPremium(String commissionAnnualizedPremium) {
		this.commissionAnnualizedPremium = commissionAnnualizedPremium;
	}

	/**
	 * @return the commission
	 */
	public String getCommission() {
		return commission;
	}

	/**
	 * @param commission the commission to set
	 */
	public void setCommission(String commission) {
		this.commission = commission;
	}

	/**
	 * @return the commissionRate
	 */
	public RiderCommissionRate getCommissionRate() {
		return commissionRate;
	}

	/**
	 * @param commissionRate the commissionRate to set
	 */
	public void setCommissionRate(RiderCommissionRate commissionRate) {
		this.commissionRate = commissionRate;
	}

	/**
	 * @return the status
	 */
	public DropDownList getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(DropDownList status) {
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
	 * @return the previousRecord
	 */
	public PolicyRiderPremium getPreviousRecord() {
		return previousRecord;
	}

	/**
	 * @param previousRecord the previousRecord to set
	 */
	public void setPreviousRecord(PolicyRiderPremium previousRecord) {
		this.previousRecord = previousRecord;
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
