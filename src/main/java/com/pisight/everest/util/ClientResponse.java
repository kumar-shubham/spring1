package com.pisight.everest.util;
import java.util.ArrayList;
import java.util.List;

import com.pisight.everest.entities.BusinessClient;
import com.pisight.everest.entities.IndividualClient;

public class ClientResponse {
	
	String message;
	
	int errorCode;
	
	String status;

	List<IndividualClient> individualClients = new ArrayList<>();

	List<BusinessClient> businessClients = new ArrayList<>();
	

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the individualClients
	 */
	public List<IndividualClient> getIndividualClients() {
		return individualClients;
	}

	/**
	 * @param individualClients the individualClients to set
	 */
	public void setIndividualClients(List<IndividualClient> individualClients) {
		this.individualClients = individualClients;
	}

	/**
	 * @return the businessClients
	 */
	public List<BusinessClient> getBusinessClients() {
		return businessClients;
	}

	/**
	 * @param businessClients the businessClients to set
	 */
	public void setBusinessClients(List<BusinessClient> businessClients) {
		this.businessClients = businessClients;
	}
}
