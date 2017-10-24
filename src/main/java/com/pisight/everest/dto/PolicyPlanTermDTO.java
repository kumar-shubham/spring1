package com.pisight.everest.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PolicyPlanTermDTO {
	
	private UUID id;
	
	private Date fromMonth;
	
	private Date toMonth;
	
	private boolean active;
	
	List<PolicyPlanCommisionRateDTO> commissionRates;


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
	 * @return the commissionRates
	 */
	public List<PolicyPlanCommisionRateDTO> getCommissionRates() {
		return commissionRates;
	}

	/**
	 * @param commissionRates the commissionRates to set
	 */
	public void setCommissionRates(List<PolicyPlanCommisionRateDTO> commissionRates) {
		this.commissionRates = commissionRates;
	}
}
