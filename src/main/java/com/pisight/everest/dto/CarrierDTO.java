package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;

public class CarrierDTO {

	private String name;

	private String abbreviation;

	private byte[] icon;

	private boolean status;
	
	private List<CarrierAddressDTO> carrierAddress=new ArrayList<>();
	
	private List<CarrierContactDTO> carrierContacts=new ArrayList<>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the icon
	 */
	public byte[] getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(byte[] icon) {
		this.icon = icon;
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

	/**
	 * @return the carrierAddress
	 */
	public List<CarrierAddressDTO> getCarrierAddress() {
		return carrierAddress;
	}

	/**
	 * @param carrierAddress the carrierAddress to set
	 */
	public void setCarrierAddress(List<CarrierAddressDTO> carrierAddress) {
		this.carrierAddress = carrierAddress;
	}

	/**
	 * @return the carrierContacts
	 */
	public List<CarrierContactDTO> getCarrierContacts() {
		return carrierContacts;
	}

	/**
	 * @param carrierContacts the carrierContacts to set
	 */
	public void setCarrierContacts(List<CarrierContactDTO> carrierContacts) {
		this.carrierContacts = carrierContacts;
	}
}
