package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name = "individual_client")
public class IndividualClient extends Client implements Serializable {

	private static final long serialVersionUID = -6840196882636373478L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "company")
	private String company;

	@ManyToOne
	@JoinColumn(name = "nationality")
	private DropDownList nationality;

	@ManyToOne
	@JoinColumn(name = "ethnicity")
	private DropDownList ethnicity;

	@ManyToOne
	@JoinColumn(name = "occupation")
	private DropDownList occupation;

	@ManyToOne
	@JoinColumn(name = "job_title")
	private DropDownList jobTitle;

	@Column(name = "postal_code")
	private String postalCode;

	@ManyToOne
	@JoinColumn(name = "martial_status")
	private DropDownList martialStatus;

	@ManyToOne
	@JoinColumn(name = "pep")
	private DropDownList pep; // politically exposed person

	@ManyToOne
	@JoinColumn(name = "accredited_investor")
	private DropDownList accreditedInvestor;

	@ManyToOne
	@JoinColumn(name = "consent")
	private DropDownList consent;

	@ManyToOne
	@JoinColumn(name = "sms")
	private DropDownList sms;

	@ManyToOne
	@JoinColumn(name = "fax")
	private DropDownList fax;

	@ManyToOne
	@JoinColumn(name = "can_call")
	private DropDownList call;

	@ManyToOne
	@JoinColumn(name = "no_consent")
	private DropDownList noConsent;

	@ManyToOne
	@JoinColumn(name = "do_not_call_client")
	private DropDownList doNotCallClient;

	@ManyToOne
	@JoinColumn(name = "do_not_sms_client")
	private DropDownList doNotSMSClient;

	@ManyToOne
	@JoinColumn(name = "do_not_fax_client")
	private DropDownList doNotFaxClient;

	@ManyToOne
	@JoinColumn(name = "selected_client")
	private DropDownList selectedClient;

	@Column(name = "withdraw_consent_date")
	private Date withdrawConsentDate;
	
//	@Transient
//	private static final String clientType="Individual";

	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@Column(name = "status", nullable = false, columnDefinition = "bit(1) default 1")
	private boolean status = false;
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<IndividualClientIdentity> idList = new ArrayList<IndividualClientIdentity>();

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<IndividualClientContact> contacts = new ArrayList<IndividualClientContact>();
	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<IndividualClientAddress> addresses = new ArrayList<IndividualClientAddress>();

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<IndividualClientEmail> emails = new ArrayList<IndividualClientEmail>();

	@JsonIgnore
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private HouseHoldDetail householdDetail;
	
	@JsonIgnore
	@OneToMany(mappedBy = "individualClient", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorIndividualClientMap> advisorIndividualClientMaps=new ArrayList<>();
	
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
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
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the nationality
	 */
	public DropDownList getNationality() {
		return nationality;
	}

	/**
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(DropDownList nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the ethnicity
	 */
	public DropDownList getEthnicity() {
		return ethnicity;
	}

	/**
	 * @param ethnicity
	 *            the ethnicity to set
	 */
	public void setEthnicity(DropDownList ethnicity) {
		this.ethnicity = ethnicity;
	}

	/**
	 * @return the occupation
	 */
	public DropDownList getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation
	 *            the occupation to set
	 */
	public void setOccupation(DropDownList occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the jobTitle
	 */
	public DropDownList getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(DropDownList jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the martialStatus
	 */
	public DropDownList getMartialStatus() {
		return martialStatus;
	}

	/**
	 * @param martialStatus
	 *            the martialStatus to set
	 */
	public void setMartialStatus(DropDownList martialStatus) {
		this.martialStatus = martialStatus;
	}

	/**
	 * @return the pep
	 */
	public DropDownList getPep() {
		return pep;
	}

	/**
	 * @param pep
	 *            the pep to set
	 */
	public void setPep(DropDownList pep) {
		this.pep = pep;
	}

	/**
	 * @return the accreditedInvestor
	 */
	public DropDownList getAccreditedInvestor() {
		return accreditedInvestor;
	}

	/**
	 * @param accreditedInvestor
	 *            the accreditedInvestor to set
	 */
	public void setAccreditedInvestor(DropDownList accreditedInvestor) {
		this.accreditedInvestor = accreditedInvestor;
	}

	/**
	 * @return the consent
	 */
	public DropDownList getConsent() {
		return consent;
	}

	/**
	 * @param consent
	 *            the consent to set
	 */
	public void setConsent(DropDownList consent) {
		this.consent = consent;
	}

	/**
	 * @return the sms
	 */
	public DropDownList getSms() {
		return sms;
	}

	/**
	 * @param sms
	 *            the sms to set
	 */
	public void setSms(DropDownList sms) {
		this.sms = sms;
	}

	/**
	 * @return the fax
	 */
	public DropDownList getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(DropDownList fax) {
		this.fax = fax;
	}

	/**
	 * @return the call
	 */
	public DropDownList getCall() {
		return call;
	}

	/**
	 * @param call
	 *            the call to set
	 */
	public void setCall(DropDownList call) {
		this.call = call;
	}

	/**
	 * @return the noConsent
	 */
	public DropDownList getNoConsent() {
		return noConsent;
	}

	/**
	 * @param noConsent
	 *            the noConsent to set
	 */
	public void setNoConsent(DropDownList noConsent) {
		this.noConsent = noConsent;
	}

	/**
	 * @return the doNotCallClient
	 */
	public DropDownList getDoNotCallClient() {
		return doNotCallClient;
	}

	/**
	 * @param doNotCallClient
	 *            the doNotCallClient to set
	 */
	public void setDoNotCallClient(DropDownList doNotCallClient) {
		this.doNotCallClient = doNotCallClient;
	}

	/**
	 * @return the doNotSMSClient
	 */
	public DropDownList getDoNotSMSClient() {
		return doNotSMSClient;
	}

	/**
	 * @param doNotSMSClient
	 *            the doNotSMSClient to set
	 */
	public void setDoNotSMSClient(DropDownList doNotSMSClient) {
		this.doNotSMSClient = doNotSMSClient;
	}

	/**
	 * @return the doNotFaxClient
	 */
	public DropDownList getDoNotFaxClient() {
		return doNotFaxClient;
	}

	/**
	 * @param doNotFaxClient
	 *            the doNotFaxClient to set
	 */
	public void setDoNotFaxClient(DropDownList doNotFaxClient) {
		this.doNotFaxClient = doNotFaxClient;
	}

	/**
	 * @return the selectedClient
	 */
	public DropDownList getSelectedClient() {
		return selectedClient;
	}

	/**
	 * @param selectedClient
	 *            the selectedClient to set
	 */
	public void setSelectedClient(DropDownList selectedClient) {
		this.selectedClient = selectedClient;
	}

	/**
	 * @return the withdrawConsentDate
	 */
	public Date getWithdrawConsentDate() {
		return withdrawConsentDate;
	}

	/**
	 * @param withdrawConsentDate
	 *            the withdrawConsentDate to set
	 */
	public void setWithdrawConsentDate(Date withdrawConsentDate) {
		this.withdrawConsentDate = withdrawConsentDate;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	
	

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
	 * @return the entityStatus
	 */
	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	/**
	 * @param entityStatus the entityStatus to set
	 */
	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * @return the contacts
	 */
	public List<IndividualClientContact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts
	 *            the contacts to set
	 */
	public void setContacts(List<IndividualClientContact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the addresses
	 */
	public List<IndividualClientAddress> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<IndividualClientAddress> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the emails
	 */
	public List<IndividualClientEmail> getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(List<IndividualClientEmail> emails) {
		this.emails = emails;
	}

	/**
	 * @return the householdDetail
	 */
	public HouseHoldDetail getHouseholdDetail() {
		return householdDetail;
	}

	/**
	 * @param householdDetail
	 *            the householdDetail to set
	 */
	public void setHouseholdDetail(HouseHoldDetail householdDetail) {
		this.householdDetail = householdDetail;
	}

	/**
	 * @return the idList
	 */
	public List<IndividualClientIdentity> getIdList() {
		return idList;
	}

	/**
	 * @param idList the idList to set
	 */
	public void setIdList(List<IndividualClientIdentity> idList) {
		this.idList = idList;
	}

	/**
	 * @return the advisorIndividualClientMaps
	 */
	public List<AdvisorIndividualClientMap> getAdvisorIndividualClientMaps() {
		return advisorIndividualClientMaps;
	}

	/**
	 * @param advisorIndividualClientMaps the advisorIndividualClientMaps to set
	 */
	public void setAdvisorIndividualClientMaps(List<AdvisorIndividualClientMap> advisorIndividualClientMaps) {
		this.advisorIndividualClientMaps = advisorIndividualClientMaps;
	}
	
	

}
