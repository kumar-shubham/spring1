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

/**
 * @author kumar
 *
 */
@Entity
@Table(name="policy")
public class Policy   implements Serializable{

	private static final long serialVersionUID = -4812977746941423314L;

	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="policy_plan")
	private PolicyPlan policyPlan;
	
	@ManyToOne
	@JoinColumn(name="policy_planTerm")
	private PolicyPlanTerm policyPlanTerm;
	
	@Column(name="no_of_premiums")
	private int numberOfPremiums;
	
	@Column(name = "effective_date", nullable = false)
	private Date effectiveDate;
	
	@ManyToOne
	@JoinColumn(name="status")
	private DropDownList status;
	
	@Column(name = "status_date", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date statusDate;
	
	@ManyToOne
	@JoinColumn(name="primary_advisor")
	private Advisor primaryAdvisor;
	
	@ManyToOne
	@JoinColumn(name="individual_buyer")
	private IndividualClient individualBuyer;
	
	@ManyToOne
	@JoinColumn(name="business_buyer")
	private BusinessClient businessBuyer;
	
	@ManyToOne
	@JoinColumn(name="individual_insured")
	private IndividualClient individualInsured;
	
	@ManyToOne
	@JoinColumn(name="business_nsured")
	private BusinessClient businessInsured;
	
	@ManyToOne
	@JoinColumn(name="advisory_group")
	private AdvisoryGroup advisoryGroup;
	
	@Column(name = "premium_frequency", nullable = false)
	private String premiumFrequency;
	
	@Column(name = "basic_face_value", nullable = false)
	private String basicFaceValue;

	@Column(name = "number_of_premium_paid", nullable = false)
	private String numberOfPremiumPaid;
	
	@Column(name = "BSCapplied", nullable = false, columnDefinition="bit(1) default 0")
	private boolean BSCapplied;
	
	@Column(name = "active", nullable = false, columnDefinition = "bit(1) default 1")
	private boolean active;

	@Column(name = "process_id")
	private String processId;

	@Column(name = "entity_status")
	private EntityStatus entityStatus;

	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;
	
	@OneToMany(mappedBy="policy",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<PolicyAdvisorMap> allAdvisors=new ArrayList<>();

	
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
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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
	 * @return the policyPlan
	 */
	public PolicyPlan getPolicyPlan() {
		return policyPlan;
	}

	/**
	 * @param policyPlan the policyPlan to set
	 */
	public void setPolicyPlan(PolicyPlan policyPlan) {
		this.policyPlan = policyPlan;
	}

	/**
	 * @return the policyPlanTerm
	 */
	public PolicyPlanTerm getPolicyPlanTerm() {
		return policyPlanTerm;
	}

	/**
	 * @param policyPlanTerm the policyPlanTerm to set
	 */
	public void setPolicyPlanTerm(PolicyPlanTerm policyPlanTerm) {
		this.policyPlanTerm = policyPlanTerm;
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
	public void setNumberOfPremiums(int numberOfPremium) {
		this.numberOfPremiums = numberOfPremium;
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
	 * @return the individualBuyer
	 */
	public IndividualClient getIndividualBuyer() {
		return individualBuyer;
	}

	/**
	 * @param individualBuyer the individualBuyer to set
	 */
	public void setIndividualBuyer(IndividualClient individualBuyer) {
		this.individualBuyer = individualBuyer;
	}

	/**
	 * @return the businessBuyer
	 */
	public BusinessClient getBusinessBuyer() {
		return businessBuyer;
	}

	/**
	 * @param businessBuyer the businessBuyer to set
	 */
	public void setBusinessBuyer(BusinessClient businessBuyer) {
		this.businessBuyer = businessBuyer;
	}

	/**
	 * @return the individualInsured
	 */
	public IndividualClient getIndividualInsured() {
		return individualInsured;
	}

	/**
	 * @param individualInsured the individualInsured to set
	 */
	public void setIndividualInsured(IndividualClient individualInsured) {
		this.individualInsured = individualInsured;
	}

	/**
	 * @return the primaryAdvisor
	 */
	public Advisor getPrimaryAdvisor() {
		return primaryAdvisor;
	}

	/**
	 * @param primaryAdvisor the primaryAdvisor to set
	 */
	public void setPrimaryAdvisor(Advisor primaryAdvisor) {
		this.primaryAdvisor = primaryAdvisor;
	}

	/**
	 * @return the businessInsured
	 */
	public BusinessClient getBusinessInsured() {
		return businessInsured;
	}

	/**
	 * @param businessInsured the businessInsured to set
	 */
	public void setBusinessInsured(BusinessClient businessInsured) {
		this.businessInsured = businessInsured;
	}

	/**
	 * @return the advisoryGroup
	 */
	public AdvisoryGroup getAdvisoryGroup() {
		return advisoryGroup;
	}

	/**
	 * @param advisoryGroup the advisoryGroup to set
	 */
	public void setAdvisoryGroup(AdvisoryGroup advisoryGroup) {
		this.advisoryGroup = advisoryGroup;
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
	 * @return the allAdvisors
	 */
	public List<PolicyAdvisorMap> getAllAdvisors() {
		return allAdvisors;
	}

	/**
	 * @param allAdvisors the allAdvisors to set
	 */
	public void setAllAdvisors(List<PolicyAdvisorMap> allAdvisors) {
		this.allAdvisors = allAdvisors;
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

}
