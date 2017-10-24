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
@Table(name="policy_advisor_commission_share")
public class PolicyAdvisorCommissionShare implements Serializable {

	private static final long serialVersionUID = 6661086870704099646L;
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="policy")
	private Policy policy;
	
	@ManyToOne
	@JoinColumn(name="advisor")
	private Advisor advisor;
	
	@Column(name = "policy_premium_commission", nullable = false)
	private String policyPremiumCommission;
	
	@Column(name = "share_percent", nullable = false)
	private String sharePercent;
	
	@Column(name = "subject_to_BSC", nullable = false)
	private String subjectToBSC;
	
	@Column(name = "BSC_score", nullable = false)
	private String BSCscore;
	
	@Column(name = "BSC_revised_score", nullable = false)
	private String BSCrevisedScore;
	
	@Column(name = "quarter_of_the_year", nullable = false)
	private String quarterOfTheYear;
	
	@Column(name = "commission_before_BSC", nullable = false)
	private String commissionBeforeBSC;
	
	@Column(name = "commission_after_BSC", nullable = false)
	private String commissionAfterBSC;
	
	@Column(name = "plan_commission", nullable = false)
	private String planCommission;
	
	@Column(name = "riderCommission", nullable = false)
	private String riderCommission;
	
	@Column(name = "final_plan_commission", nullable = false)
	private String finalPlanCommission;
	
	@Column(name = "createdAt", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
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
	 * @return the policyPremiumCommission
	 */
	public String getPolicyPremiumCommission() {
		return policyPremiumCommission;
	}

	/**
	 * @param policyPremiumCommission the policyPremiumCommission to set
	 */
	public void setPolicyPremiumCommission(String policyPremiumCommission) {
		this.policyPremiumCommission = policyPremiumCommission;
	}

	/**
	 * @return the sharePercent
	 */
	public String getSharePercent() {
		return sharePercent;
	}

	/**
	 * @param sharePercent the sharePercent to set
	 */
	public void setSharePercent(String sharePercent) {
		this.sharePercent = sharePercent;
	}

	/**
	 * @return the subjectToBSC
	 */
	public String getSubjectToBSC() {
		return subjectToBSC;
	}

	/**
	 * @param subjectToBSC the subjectToBSC to set
	 */
	public void setSubjectToBSC(String subjectToBSC) {
		this.subjectToBSC = subjectToBSC;
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
	 * @return the bSCrevisedScore
	 */
	public String getBSCrevisedScore() {
		return BSCrevisedScore;
	}

	/**
	 * @param bSCrevisedScore the bSCrevisedScore to set
	 */
	public void setBSCrevisedScore(String bSCrevisedScore) {
		BSCrevisedScore = bSCrevisedScore;
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
	 * @return the commissionBeforeBSC
	 */
	public String getCommissionBeforeBSC() {
		return commissionBeforeBSC;
	}

	/**
	 * @param commissionBeforeBSC the commissionBeforeBSC to set
	 */
	public void setCommissionBeforeBSC(String commissionBeforeBSC) {
		this.commissionBeforeBSC = commissionBeforeBSC;
	}

	/**
	 * @return the commissionAfterBSC
	 */
	public String getCommissionAfterBSC() {
		return commissionAfterBSC;
	}

	/**
	 * @param commissionAfterBSC the commissionAfterBSC to set
	 */
	public void setCommissionAfterBSC(String commissionAfterBSC) {
		this.commissionAfterBSC = commissionAfterBSC;
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
	 * @return the finalPlanCommission
	 */
	public String getFinalPlanCommission() {
		return finalPlanCommission;
	}

	/**
	 * @param finalPlanCommission the finalPlanCommission to set
	 */
	public void setFinalPlanCommission(String finalPlanCommission) {
		this.finalPlanCommission = finalPlanCommission;
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
