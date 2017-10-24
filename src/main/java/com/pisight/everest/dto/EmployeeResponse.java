package com.pisight.everest.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.pisight.everest.entities.DropDownList;

public class EmployeeResponse {

	
	private UUID id;
	
	private String employeeId;
	
	private String firstName;
	
	private String middleName;

	private String lastName;
	
	private String displayName;
	
	private DropDownList gender;
	
	private Date dateOfJoining;
	
	private Date dateOfResignation;
	
	private byte[] profileImage;
	
	private DropDownList jobTitle;
	
	private DropDownList secondaryjobTitle;
	
	private DropDownList location;
	
	private DropDownList nationality;
	
	private DropDownList maritalStatus;
	
	private DropDownList roleType;
	
	private String remarks;
	
	private List<EmployeeAddressDTO> addressList= new ArrayList<>();
	
	private List<EmployeeAwardsDTO> awardsList = new ArrayList<>();
	
	private List<EmployeeCertificationsDTO> certificationsList= new ArrayList<>();
	
	private List<EmployeeContactDTO> contactList= new ArrayList<>();
	
	private List<EmployeeEducationDTO> educationList = new ArrayList<>();
	
	private List<EmployeeEmailsDTO> emailsList = new ArrayList<>();
	
	private List<EmployeeExperienceDTO> employeeExperienceList = new ArrayList<>();
	
	private List<EmployeeLanguageDTO> employeeLanguageList = new ArrayList<>();
	
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
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the gender
	 */
	public DropDownList getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(DropDownList gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the dateOfResignation
	 */
	public Date getDateOfResignation() {
		return dateOfResignation;
	}

	/**
	 * @param dateOfResignation the dateOfResignation to set
	 */
	public void setDateOfResignation(Date dateOfResignation) {
		this.dateOfResignation = dateOfResignation;
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
	 * @return the jobTitle
	 */
	public DropDownList getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(DropDownList jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the secondaryjobTitle
	 */
	public DropDownList getSecondaryjobTitle() {
		return secondaryjobTitle;
	}

	/**
	 * @param secondaryjobTitle the secondaryjobTitle to set
	 */
	public void setSecondaryjobTitle(DropDownList secondaryjobTitle) {
		this.secondaryjobTitle = secondaryjobTitle;
	}

	/**
	 * @return the location
	 */
	public DropDownList getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(DropDownList location) {
		this.location = location;
	}

	/**
	 * @return the nationality
	 */
	public DropDownList getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(DropDownList nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the maritalStatus
	 */
	public DropDownList getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(DropDownList maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the roleType
	 */
	public DropDownList getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(DropDownList roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the addressList
	 */
	public List<EmployeeAddressDTO> getAddressList() {
		return addressList;
	}

	/**
	 * @param addressList the addressList to set
	 */
	public void setAddressList(List<EmployeeAddressDTO> addressList) {
		this.addressList = addressList;
	}

	/**
	 * @return the awardsList
	 */
	public List<EmployeeAwardsDTO> getAwardsList() {
		return awardsList;
	}

	/**
	 * @param awardsList the awardsList to set
	 */
	public void setAwardsList(List<EmployeeAwardsDTO> awardsList) {
		this.awardsList = awardsList;
	}

	/**
	 * @return the certificationsList
	 */
	public List<EmployeeCertificationsDTO> getCertificationsList() {
		return certificationsList;
	}

	/**
	 * @param certificationsList the certificationsList to set
	 */
	public void setCertificationsList(List<EmployeeCertificationsDTO> certificationsList) {
		this.certificationsList = certificationsList;
	}

	/**
	 * @return the contactList
	 */
	public List<EmployeeContactDTO> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<EmployeeContactDTO> contactList) {
		this.contactList = contactList;
	}

	/**
	 * @return the educationList
	 */
	public List<EmployeeEducationDTO> getEducationList() {
		return educationList;
	}

	/**
	 * @param educationList the educationList to set
	 */
	public void setEducationList(List<EmployeeEducationDTO> educationList) {
		this.educationList = educationList;
	}

	/**
	 * @return the emailsList
	 */
	public List<EmployeeEmailsDTO> getEmailsList() {
		return emailsList;
	}

	/**
	 * @param emailsList the emailsList to set
	 */
	public void setEmailsList(List<EmployeeEmailsDTO> emailsList) {
		this.emailsList = emailsList;
	}

	/**
	 * @return the employeeExperienceList
	 */
	public List<EmployeeExperienceDTO> getEmployeeExperienceList() {
		return employeeExperienceList;
	}

	/**
	 * @param employeeExperienceList the employeeExperienceList to set
	 */
	public void setEmployeeExperienceList(List<EmployeeExperienceDTO> employeeExperienceList) {
		this.employeeExperienceList = employeeExperienceList;
	}

	/**
	 * @return the employeeLanguageList
	 */
	public List<EmployeeLanguageDTO> getEmployeeLanguageList() {
		return employeeLanguageList;
	}

	/**
	 * @param employeeLanguageList the employeeLanguageList to set
	 */
	public void setEmployeeLanguageList(List<EmployeeLanguageDTO> employeeLanguageList) {
		this.employeeLanguageList = employeeLanguageList;
	}

}
