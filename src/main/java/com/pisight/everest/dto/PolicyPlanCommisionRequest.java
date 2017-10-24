package com.pisight.everest.dto;

import java.util.Date;
import java.util.UUID;

public class PolicyPlanCommisionRequest {
	
	private UUID planTermId;
	
	private Date fromMonth;
	
	private Date toMonth;
	
	private float commissionRate;
	
	private Date effectiveDate;
	
	private String remark;
	
	private boolean status = false;

	/**
	 * @return the planTermId
	 */
	public UUID getPlanTermId() {
		return planTermId;
	}

	/**
	 * @param planTermId the planTermId to set
	 */
	public void setPlanTermId(UUID planTermId) {
		this.planTermId = planTermId;
	}

	/**
	 * @return the fromMonth
	 */
	public Date getFromMonth() {
		return fromMonth;
	}

	/**
	 * @param fromMonth the fromMonth to set
	 */
	public void setFromMonth(Date fromMonth) {
		this.fromMonth = fromMonth;
	}

	/**
	 * @return the toMonth
	 */
	public Date getToMonth() {
		return toMonth;
	}

	/**
	 * @param toMonth the toMonth to set
	 */
	public void setToMonth(Date toMonth) {
		this.toMonth = toMonth;
	}

	/**
	 * @return the commissionRate
	 */
	public float getCommissionRate() {
		return commissionRate;
	}

	/**
	 * @param commissionRate the commissionRate to set
	 */
	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
}
