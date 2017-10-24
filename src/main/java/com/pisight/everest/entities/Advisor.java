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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;

@Entity
@Table(name = "advisor")
public class Advisor implements Serializable {

	private static final long serialVersionUID = -2863029239841992676L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;
	
	@OneToOne
	@JoinColumn(name = "employee_id", unique = true, nullable = false, updatable = false)
	private Employee employee;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "BSCscore")
	private String BSCscore;

	@Column(name = "icon", columnDefinition = "MEDIUMBLOB")
	private byte[] profileImage;

	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@Column(name = "status", nullable = false, columnDefinition = "bit(1) default 1")
	private boolean status;
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
	
	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorAddress> addressList = new ArrayList<AdvisorAddress>();

	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorEducationDetails> educationdetails = new ArrayList<AdvisorEducationDetails>();

	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorExperienceDetails> experienceDetails = new ArrayList<AdvisorExperienceDetails>();

	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorIndividualClientMap> advisorIndividualClientMap=new ArrayList<>();
	
	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisorBusinessClientMap> advisorBusinessClientMap=new ArrayList<>();
	
	@OneToMany(mappedBy = "primaryAdvisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Policy> policies=new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AdvisoryGroupAdvisorMap> advisoryGroups = new ArrayList<>();
	
	
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
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the profileImage
	 */
	public byte[] getProfileImage() {
		return profileImage;
	}

	/**
	 * @param profileImage the profileImage to set
	 */
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
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
	 * @param updatedAt the updatedAt to set
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
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the bSCscore
	 */
	public String getBSCscore() {
		return BSCscore;
	}

	/**
	 * @param bSCscore the bSCscore to set
	 */
	public void setBSCscore(String bSCscore) {
		BSCscore = bSCscore;
	}

	/**
	 * @return the addressList
	 */
	public List<AdvisorAddress> getAddressList() {
		return addressList;
	}

	/**
	 * @param addressList the addressList to set
	 */
	public void setAddressList(List<AdvisorAddress> addressList) {
		this.addressList = addressList;
	}

	/**
	 * @return the educationdetails
	 */
	public List<AdvisorEducationDetails> getEducationdetails() {
		return educationdetails;
	}

	/**
	 * @param educationdetails the educationdetails to set
	 */
	public void setEducationdetails(List<AdvisorEducationDetails> educationdetails) {
		this.educationdetails = educationdetails;
	}

	/**
	 * @return the experienceDetails
	 */
	public List<AdvisorExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	/**
	 * @param experienceDetails the experienceDetails to set
	 */
	public void setExperienceDetails(List<AdvisorExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	/**
	 * @return the advisorIndividualClientMap
	 */
	public List<AdvisorIndividualClientMap> getAdvisorIndividualClientMap() {
		return advisorIndividualClientMap;
	}

	/**
	 * @param advisorIndividualClientMap the advisorIndividualClientMap to set
	 */
	public void setAdvisorIndividualClientMap(List<AdvisorIndividualClientMap> advisorIndividualClientMap) {
		this.advisorIndividualClientMap = advisorIndividualClientMap;
	}

	/**
	 * @return the advisorBusinessClientMap
	 */
	public List<AdvisorBusinessClientMap> getAdvisorBusinessClientMap() {
		return advisorBusinessClientMap;
	}

	/**
	 * @param advisorBusinessClientMap the advisorBusinessClientMap to set
	 */
	public void setAdvisorBusinessClientMap(List<AdvisorBusinessClientMap> advisorBusinessClientMap) {
		this.advisorBusinessClientMap = advisorBusinessClientMap;
	}

	/**
	 * @return the policies
	 */
	public List<Policy> getPolicies() {
		return policies;
	}

	/**
	 * @param policies the policies to set
	 */
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
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
	public Constants.EntityStatus getEntityStatus() {
		return entityStatus;
	}

	/**
	 * @param entityStatus the entityStatus to set
	 */
	public void setEntityStatus(Constants.EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	/**
	 * @return the advisoryGroups
	 */
	public List<AdvisoryGroupAdvisorMap> getAdvisoryGroups() {
		return advisoryGroups;
	}

	/**
	 * @param advisoryGroups the advisoryGroups to set
	 */
	public void setAdvisoryGroups(List<AdvisoryGroupAdvisorMap> advisoryGroups) {
		this.advisoryGroups = advisoryGroups;
	}
}
