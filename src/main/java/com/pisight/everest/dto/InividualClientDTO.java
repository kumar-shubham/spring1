package com.pisight.everest.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class InividualClientDTO {

	String userId;
	String advisorId;
	DropDownDTO clientType;
	String clientName;
	Date dob;
	DropDownDTO nationality;
	DropDownDTO ethnicity;
	DropDownDTO martialStatus;
	String company;
	DropDownDTO occupation;
	DropDownDTO jobTitle;
	DropDownDTO pep;
	DropDownDTO accreditedInvestor;
	DropDownDTO cka;
	DropDownDTO consent;
	DropDownDTO phCall;
	DropDownDTO sms;
	DropDownDTO fax;
	Date withdrawConsentDate;
	DropDownDTO noConsent;
	DropDownDTO doNotCallClient;
	DropDownDTO doNotSMSClient;
	DropDownDTO doNotFaxClient;
	DropDownDTO selectedClient;
	
	private IndividualClientHouseHoldDetailDTO houseHoldDetail;

	private List<IndividualClientAddressesDTO> addresses = new ArrayList<IndividualClientAddressesDTO>();

	private List<IndividualClientEmailDTO> emails = new ArrayList<IndividualClientEmailDTO>();

	private List<IndividualClientPhoneNumbersDTO> phoneContacts = new ArrayList<IndividualClientPhoneNumbersDTO>();

	private List<IndividualClientIdentityDetailDTO> identityList = new ArrayList<IndividualClientIdentityDetailDTO>();



	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public DropDownDTO getClientType() {
		return clientType;
	}

	public void setClientType(DropDownDTO clientType) {
		this.clientType = clientType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public DropDownDTO getNationality() {
		return nationality;
	}

	public void setNationality(DropDownDTO nationality) {
		this.nationality = nationality;
	}

	public DropDownDTO getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(DropDownDTO ethnicity) {
		this.ethnicity = ethnicity;
	}

	public DropDownDTO getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(DropDownDTO martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public DropDownDTO getOccupation() {
		return occupation;
	}

	public void setOccupation(DropDownDTO occupation) {
		this.occupation = occupation;
	}

	public DropDownDTO getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(DropDownDTO jobTitle) {
		this.jobTitle = jobTitle;
	}

	public DropDownDTO getPep() {
		return pep;
	}

	public void setPep(DropDownDTO pep) {
		this.pep = pep;
	}

	public DropDownDTO getAccreditedInvestor() {
		return accreditedInvestor;
	}

	public void setAccreditedInvestor(DropDownDTO accreditedInvestor) {
		this.accreditedInvestor = accreditedInvestor;
	}

	public DropDownDTO getCka() {
		return cka;
	}

	public void setCka(DropDownDTO cka) {
		this.cka = cka;
	}

	public DropDownDTO getConsent() {
		return consent;
	}

	public void setConsent(DropDownDTO consent) {
		this.consent = consent;
	}

	public DropDownDTO getPhCall() {
		return phCall;
	}

	public void setPhCall(DropDownDTO phCall) {
		this.phCall = phCall;
	}

	public DropDownDTO getSms() {
		return sms;
	}

	public void setSms(DropDownDTO sms) {
		this.sms = sms;
	}

	public DropDownDTO getFax() {
		return fax;
	}

	public void setFax(DropDownDTO fax) {
		this.fax = fax;
	}

	public Date getWithdrawConsentDate() {
		return withdrawConsentDate;
	}

	public void setWithdrawConsentDate(Date withdrawConsentDate) {
		this.withdrawConsentDate = withdrawConsentDate;
	}

	public DropDownDTO getNoConsent() {
		return noConsent;
	}

	public void setNoConsent(DropDownDTO noConsent) {
		this.noConsent = noConsent;
	}

	public DropDownDTO getDoNotCallClient() {
		return doNotCallClient;
	}

	public void setDoNotCallClient(DropDownDTO doNotCallClient) {
		this.doNotCallClient = doNotCallClient;
	}

	public DropDownDTO getDoNotSMSClient() {
		return doNotSMSClient;
	}

	public void setDoNotSMSClient(DropDownDTO doNotSMSClient) {
		this.doNotSMSClient = doNotSMSClient;
	}

	public DropDownDTO getDoNotFaxClient() {
		return doNotFaxClient;
	}

	public void setDoNotFaxClient(DropDownDTO doNotFaxClient) {
		this.doNotFaxClient = doNotFaxClient;
	}

	public DropDownDTO getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(DropDownDTO selectedClient) {
		this.selectedClient = selectedClient;
	}

	public IndividualClientHouseHoldDetailDTO getHouseHoldDetail() {
		return houseHoldDetail;
	}

	public void setHouseHoldDetail(IndividualClientHouseHoldDetailDTO houseHoldDetail) {
		this.houseHoldDetail = houseHoldDetail;
	}

	public List<IndividualClientAddressesDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<IndividualClientAddressesDTO> addresses) {
		this.addresses = addresses;
	}

	public List<IndividualClientEmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<IndividualClientEmailDTO> emails) {
		this.emails = emails;
	}

	public List<IndividualClientPhoneNumbersDTO> getPhoneContacts() {
		return phoneContacts;
	}

	public void setPhoneContacts(List<IndividualClientPhoneNumbersDTO> phoneContacts) {
		this.phoneContacts = phoneContacts;
	}

	public List<IndividualClientIdentityDetailDTO> getIdentityList() {
		return identityList;
	}

	public void setIdentityList(List<IndividualClientIdentityDetailDTO> identityList) {
		this.identityList = identityList;
	}


}
