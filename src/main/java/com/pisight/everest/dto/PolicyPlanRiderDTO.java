package com.pisight.everest.dto;

import java.util.List;
import java.util.UUID;

public class PolicyPlanRiderDTO {

	private UUID id;
	
	List<RiderCommissionRateDTO> riderCommissionRates;

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
	 * @return the riderCommissionRates
	 */
	public List<RiderCommissionRateDTO> getRiderCommissionRates() {
		return riderCommissionRates;
	}

	/**
	 * @param riderCommissionRates the riderCommissionRates to set
	 */
	public void setRiderCommissionRates(List<RiderCommissionRateDTO> riderCommissionRates) {
		this.riderCommissionRates = riderCommissionRates;
	}
}
