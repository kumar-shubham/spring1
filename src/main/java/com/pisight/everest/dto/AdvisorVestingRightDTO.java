package com.pisight.everest.dto;

import java.util.Date;

public class AdvisorVestingRightDTO {
	
	private DropDownDTO vestingRight;
	
	private Date effectiveDate;
	
	private Date expiryDate;

	/**
	 * @return the vestingRight
	 */
	public DropDownDTO getVestingRight() {
		return vestingRight;
	}

	/**
	 * @param vestingRight the vestingRight to set
	 */
	public void setVestingRight(DropDownDTO vestingRight) {
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
}
