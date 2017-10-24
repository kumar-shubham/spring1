package com.pisight.everest.dto;

public class RiderPremiumDTO {
	
	private String id;
	
	private String premium;
	
	private String loadingPremium;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	
}
