package com.pisight.everest.dto;

import java.util.UUID;

public class PolicyPlanRequest {
	
	private UUID id;
	
	private UUID carrierId;

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
	 * @return the carrierId
	 */
	public UUID getCarrierId() {
		return carrierId;
	}

	/**
	 * @param carrierId the carrierId to set
	 */
	public void setCarrierId(UUID carrierId) {
		this.carrierId = carrierId;
	}
}
