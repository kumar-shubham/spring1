package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;

public class BusinessClientDTO {

	private String advisorId;
	
	private String name;

	private String businessIndustry;

	private String businessClass;

	private List<BusinessRegistrationDetailsDTO> registrationList = new ArrayList<>();

	private List<BusinessClientContactDTO> contacts = new ArrayList<>();

	private List<BusinessClientAddressDTO> addresses = new ArrayList<>();

	private List<BusinessClientEmailDTO> emails = new ArrayList<>();

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the businessIndustry
	 */
	public String getBusinessIndustry() {
		return businessIndustry;
	}

	/**
	 * @param businessIndustry
	 *            the businessIndustry to set
	 */
	public void setBusinessIndustry(String businessIndustry) {
		this.businessIndustry = businessIndustry;
	}

	/**
	 * @return the businessClass
	 */
	public String getBusinessClass() {
		return businessClass;
	}

	/**
	 * @param businessClass
	 *            the businessClass to set
	 */
	public void setBusinessClass(String businessClass) {
		this.businessClass = businessClass;
	}

	/**
	 * @return the registrationList
	 */
	public List<BusinessRegistrationDetailsDTO> getRegistrationList() {
		return registrationList;
	}

	/**
	 * @param registrationList
	 *            the registrationList to set
	 */
	public void setRegistrationList(List<BusinessRegistrationDetailsDTO> registrationList) {
		this.registrationList = registrationList;
	}

	/**
	 * @return the contacts
	 */
	public List<BusinessClientContactDTO> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts
	 *            the contacts to set
	 */
	public void setContacts(List<BusinessClientContactDTO> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the addresses
	 */
	public List<BusinessClientAddressDTO> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<BusinessClientAddressDTO> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the emails
	 */
	public List<BusinessClientEmailDTO> getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(List<BusinessClientEmailDTO> emails) {
		this.emails = emails;
	}

}
