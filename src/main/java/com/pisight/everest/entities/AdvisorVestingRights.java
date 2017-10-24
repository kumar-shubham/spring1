package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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
@Table(name = "advisor_vesting_rights")
public class AdvisorVestingRights implements Serializable {

	private static final long serialVersionUID = 6558295510047921645L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_additonal_detail")
	AdvisorAdditionalDetails advisorAdditonalDetail;
	
	@ManyToOne
	@JoinColumn(name = "vesting_right", nullable = false)
	private DropDownList vestingRight;
	
	@Column(name = "effective_ate")
	private Date effectiveDate;

	@Column(name = "expiry_date")
	private Date expiryDate;
	
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
	 * @return the vestingRight
	 */
	public DropDownList getVestingRight() {
		return vestingRight;
	}

	/**
	 * @param vestingRight the vestingRight to set
	 */
	public void setVestingRight(DropDownList vestingRight) {
		this.vestingRight = vestingRight;
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
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
	 * @return the advisorAdditonalDetail
	 */
	public AdvisorAdditionalDetails getAdvisorAdditonalDetail() {
		return advisorAdditonalDetail;
	}

	/**
	 * @param advisorAdditonalDetail the advisorAdditonalDetail to set
	 */
	public void setAdvisorAdditonalDetail(AdvisorAdditionalDetails advisorAdditonalDetail) {
		this.advisorAdditonalDetail = advisorAdditonalDetail;
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
