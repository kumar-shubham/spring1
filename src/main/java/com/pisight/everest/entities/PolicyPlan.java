package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@Table(name="policy_plan")
public class PolicyPlan implements Serializable{

	private static final long serialVersionUID = -1521804613779733930L;
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "carrier_id", nullable = false)
	private Carrier carrier;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "effective_date", nullable = false)
	private Date effectiveDate;
	
	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@Column(name = "approved", nullable = false, columnDefinition="bit(1) default 0")
	private boolean approved;
	
	@Column(name = "active", nullable = false, columnDefinition="bit(1) default 0")
	private boolean active;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "plan_type")
	private DropDownList planType;
	
	@Column(name = "createdAt", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
	@OneToMany(mappedBy="policyPlan",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<PolicyPlanTerm> planTerms = new ArrayList<PolicyPlanTerm>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "policyPlan", cascade=CascadeType.ALL)
	private Set<PolicyPlanRider> policyPlanRiders = new HashSet<PolicyPlanRider>();

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
	 * @return the carrier
	 */
	public Carrier getCarrier() {
		return carrier;
	}

	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
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
	 * @return the planType
	 */
	public DropDownList getPlanType() {
		return planType;
	}

	/**
	 * @param planType the planType to set
	 */
	public void setPlanType(DropDownList planType) {
		this.planType = planType;
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
	 * @return the planTerms
	 */
	public List<PolicyPlanTerm> getPlanTerms() {
		return planTerms;
	}

	/**
	 * @param planTerms the planTerms to set
	 */
	public void setPlanTerms(List<PolicyPlanTerm> productOptions) {
		this.planTerms = productOptions;
	}

	/**
	 * @return the policyPlanRiders
	 */
	public Set<PolicyPlanRider> getPolicyPlanRiders() {
		return policyPlanRiders;
	}

	/**
	 * @param policyPlanRiders the policyPlanRiders to set
	 */
	public void setPolicyPlanRiders(Set<PolicyPlanRider> policyPlanRiders) {
		this.policyPlanRiders = policyPlanRiders;
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
