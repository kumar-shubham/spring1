package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;

public class ClientRequest {

	String advisorId;
	
	String type;
	
	List<String> clientID=new ArrayList<>();

	/**
	 * @return the advisorId
	 */
	public String getAdvisorId() {
		return advisorId;
	}

	/**
	 * @param advisorId the advisorId to set
	 */
	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the clientID
	 */
	public List<String> getClientID() {
		return clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(List<String> clientID) {
		this.clientID = clientID;
	}

	
}
