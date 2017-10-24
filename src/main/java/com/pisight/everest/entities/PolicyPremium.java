package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name = "policy_premium")
public class PolicyPremium  implements Serializable{


	private static final long serialVersionUID = 8072613348316005836L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "policy")
	private Policy policy;
	
	@Column(name = "premium", nullable = false)
	private String premium;
	
	@Column(name = "loading_premium", nullable = false)
	private String loadingPremium;
	
	@Column(name = "commission_model_premium", nullable = false)
	private String  commissionModelPremium;
	
	@Column(name = "annualized_premium", nullable = false)
	private String annualizedPremium;
	
	@Column(name = "commission_annualized_premium", nullable = false)
	private String commissionAnnualizedPremium;

	@Column(name = "rider_premium", nullable = false)
	private String riderPremium;
	
	@Column(name = "premium_with_rider", nullable = false)
	private String premiumWithRider;
	
	@Column(name = "rider_annualized_premium", nullable = false)
	private String riderAnnualizedPremium;

	@Column(name = "annualized_premium_with_rider", nullable = false)
	private String annualizedPremiumWithRider;

	@Column(name = "payment_mode", nullable = false)
	private String paymentMode;

	@Column(name = "payment_frequency", nullable = false)
	private String paymentFrequency;

	@Column(name = "effective_date", nullable = false)
	private Date effectiveDate;
	
	@Column(name = "commission", nullable = false)
	private String commission;
	
	@Column(name = "quarterOfTheYear", nullable = false)
	private String quarterOfTheYear;
	
	@ManyToOne
	@JoinColumn(name = "policy_plan_commission_rate_id", nullable = false)
	private PolicyPlanCommissionRate planCommissionRate;

	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	

	@OneToMany(mappedBy = "policyPremium", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PolicyRiderPremium> riderPremiumList = new ArrayList<>();

	
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
	 * @return the policy
	 */
	public Policy getPolicy() {
		return policy;
	}

	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(Policy policy) {
		this.policy = policy;
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
	 * @return the commissionModelPremium
	 */
	public String getCommissionModelPremium() {
		return commissionModelPremium;
	}

	/**
	 * @param commissionModelPremium the commissionModelPremium to set
	 */
	public void setCommissionModelPremium(String commissionModelPremium) {
		this.commissionModelPremium = commissionModelPremium;
	}

	/**
	 * @return the annualizedPremium
	 */
	public String getAnnualizedPremium() {
		return annualizedPremium;
	}

	/**
	 * @param annualizedPremium the annualizedPremium to set
	 */
	public void setAnnualizedPremium(String annualizedPremium) {
		this.annualizedPremium = annualizedPremium;
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
	 * @return the riderPremium
	 */
	public String getRiderPremium() {
		return riderPremium;
	}

	/**
	 * @param riderPremium the riderPremium to set
	 */
	public void setRiderPremium(String riderPremium) {
		this.riderPremium = riderPremium;
	}

	/**
	 * @return the premiumWithRider
	 */
	public String getPremiumWithRider() {
		return premiumWithRider;
	}

	/**
	 * @param premiumWithRider the premiumWithRider to set
	 */
	public void setPremiumWithRider(String premiumWithRider) {
		this.premiumWithRider = premiumWithRider;
	}

	/**
	 * @return the riderAnnualizedPremium
	 */
	public String getRiderAnnualizedPremium() {
		return riderAnnualizedPremium;
	}

	/**
	 * @param riderAnnualizedPremium the riderAnnualizedPremium to set
	 */
	public void setRiderAnnualizedPremium(String riderAnnualizedPremium) {
		this.riderAnnualizedPremium = riderAnnualizedPremium;
	}

	/**
	 * @return the annualizedPremiumWithRider
	 */
	public String getAnnualizedPremiumWithRider() {
		return annualizedPremiumWithRider;
	}

	/**
	 * @param annualizedPremiumWithRider the annualizedPremiumWithRider to set
	 */
	public void setAnnualizedPremiumWithRider(String annualizedPremiumWithRider) {
		this.annualizedPremiumWithRider = annualizedPremiumWithRider;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the paymentFrequency
	 */
	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	/**
	 * @param paymentFrequency the paymentFrequency to set
	 */
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
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
	 * @return the planCommissionRate
	 */
	public PolicyPlanCommissionRate getPlanCommissionRate() {
		return planCommissionRate;
	}

	/**
	 * @param planCommissionRate the planCommissionRate to set
	 */
	public void setPlanCommissionRate(PolicyPlanCommissionRate planCommissionRate) {
		this.planCommissionRate = planCommissionRate;
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
	 * @return the riderPremiumList
	 */
	public List<PolicyRiderPremium> getRiderPremiumList() {
		return riderPremiumList;
	}

	/**
	 * @param riderPremiumList the riderPremiumList to set
	 */
	public void setRiderPremiumList(List<PolicyRiderPremium> riderPremiumList) {
		this.riderPremiumList = riderPremiumList;
	}

	/**
	 * @return the quarterOfTheYear
	 */
	public String getQuarterOfTheYear() {
		return quarterOfTheYear;
	}

	/**
	 * @param quarterOfTheYear the quarterOfTheYear to set
	 */
	public void setQuarterOfTheYear(String quarterOfTheYear) {
		this.quarterOfTheYear = quarterOfTheYear;
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
