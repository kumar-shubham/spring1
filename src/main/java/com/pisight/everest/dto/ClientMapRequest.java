package com.pisight.everest.dto;

import java.util.UUID;

public class ClientMapRequest {

	private String advisorID;

	private UUID clientId;

	private String type;

	private String processId;

	/**
	 * @return the advisorID
	 */
	public String getAdvisorID() {
		return advisorID;
	}
	/**
	 * @param advisorID
	 *            the advisorID to set
	 */
	public void setAdvisorID(String advisorID) {
		this.advisorID = advisorID;
	}
	/**
	 * @return the clientId
	 */
	public UUID getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * @param processId
	 *            the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
