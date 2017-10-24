package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;

public class PremiumDTO {
	
	private String processId;
	
	private String premium;
	
	private String loadingPremium;
	
	private List<RiderPremiumDTO> riderPremium = new ArrayList<RiderPremiumDTO>();

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
	 * @return the premium
	 */
	public String getPremium() {
		return premium;
	}

	/**
	 * @param premium the premium to set
	 */
	public void setPremium(String premium) {
		this.premium = premium;
	}

	/**
	 * @return the loadingPremium
	 */
	public String getLoadingPremium() {
		return loadingPremium;
	}

	/**
	 * @param loadingPremium the loadingPremium to set
	 */
	public void setLoadingPremium(String loadingPremium) {
		this.loadingPremium = loadingPremium;
	}

	/**
	 * @return the riderPremium
	 */
	public List<RiderPremiumDTO> getRiderPremium() {
		return riderPremium;
	}

	/**
	 * @param riderPremium the riderPremium to set
	 */
	public void setRiderPremium(List<RiderPremiumDTO> riderPremium) {
		this.riderPremium = riderPremium;
	}
}
