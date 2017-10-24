package com.pisight.everest.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name="business_client")
public class BusinessClient extends Client implements Serializable{

	private static final long serialVersionUID = -1922508069068080876L;
	
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="business_industry")
	private String businessIndustry;
	
	@Column(name="business_class")
	private String businessClass;
	
	@Transient
	private static final String clientType="Business";
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private List<BusinessRegistrationDetail> registrationDetails = new ArrayList<BusinessRegistrationDetail>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private List<BusinessClientContact> contacts = new ArrayList<BusinessClientContact>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private List<BusinessClientAddress> addresses = new ArrayList<BusinessClientAddress>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private List<BusinessClientEmail> emails = new ArrayList<BusinessClientEmail>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "businessClient", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorBusinessClientMap> advisorBusinessClientMaps=new ArrayList<>();
	
	

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
	 * @return the businessIndustry
	 */
	public String getBusinessIndustry() {
		return businessIndustry;
	}

	/**
	 * @param businessIndustry the businessIndustry to set
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
	 * @param businessClass the businessClass to set
	 */
	public void setBusinessClass(String businessClass) {
		this.businessClass = businessClass;
	}

	/**
	 * @return the registrationDetails
	 */
	public List<BusinessRegistrationDetail> getRegistrationDetails() {
		return registrationDetails;
	}

	/**
	 * @param registrationDetails the registrationDetails to set
	 */
	public void setRegistrationDetails(List<BusinessRegistrationDetail> registrationDetails) {
		this.registrationDetails = registrationDetails;
	}

	/**
	 * @return the contacts
	 */
	public List<BusinessClientContact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<BusinessClientContact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the addresses
	 */
	public List<BusinessClientAddress> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<BusinessClientAddress> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the emails
	 */
	public List<BusinessClientEmail> getEmails() {
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List<BusinessClientEmail> emails) {
		this.emails = emails;
	}

	/**
	 * @return the clienttype
	 */
	public static String getClienttype() {
		return clientType;
	}

	/**
	 * @return the advisorBusinessClientMaps
	 */
	public List<AdvisorBusinessClientMap> getAdvisorBusinessClientMaps() {
		return advisorBusinessClientMaps;
	}

	/**
	 * @param advisorBusinessClientMaps the advisorBusinessClientMaps to set
	 */
	public void setAdvisorBusinessClientMaps(List<AdvisorBusinessClientMap> advisorBusinessClientMaps) {
		this.advisorBusinessClientMaps = advisorBusinessClientMaps;
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
}
