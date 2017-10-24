package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarrierResponse {
	
	private UUID id;
	
	private String abbreviation;
	
	private String name;
	
	private byte[] icon = null;
	
	private List<CarrierAddressDTO> addresses = new ArrayList<CarrierAddressDTO>();
	
	private List<CarrierContactDTO> contacts = new ArrayList<CarrierContactDTO>();
	
	private boolean status = false;
	
	private String message;
	
	private int errorCode;
	

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
	 * @return the addresses
	 */
	public List<CarrierAddressDTO> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<CarrierAddressDTO> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the contacts
	 */
	public List<CarrierContactDTO> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<CarrierContactDTO> contacts) {
		this.contacts = contacts;
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

}
