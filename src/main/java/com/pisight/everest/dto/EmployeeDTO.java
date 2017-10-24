package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDTO {

	private String userId;

	private String userRole;

	private String employeeId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String displayName;

	private DropDownDTO gender;

	private Date dateOfJoining;

	private Date dateOfResignation;

	private byte[] profileImage;

	private DropDownDTO jobTitle;

	private DropDownDTO secondaryjobTitle;

	private DropDownDTO location;

	private DropDownDTO nationality;

	private DropDownDTO maritalStatus;

	private DropDownDTO roleType;

	private String remarks;

	private AdvisorAdditionDetailDTO advisorDetails;

	private List<EmployeeAddressDTO> employeeAddress = new ArrayList<EmployeeAddressDTO>();

	private List<EmployeeAwardsDTO> awardsandAchievements = new ArrayList<EmployeeAwardsDTO>();

	private List<EmployeeCertificationsDTO> employeeCertifications = new ArrayList<EmployeeCertificationsDTO>();

	private List<EmployeeContactDTO> employeeContacts = new ArrayList<EmployeeContactDTO>();

	private List<EmployeeEducationDTO> employeeEducation = new ArrayList<EmployeeEducationDTO>();

	private List<EmployeeEmailsDTO> employeeEmails = new ArrayList<EmployeeEmailsDTO>();

	private List<EmployeeExperienceDTO> employeeExperience = new ArrayList<EmployeeExperienceDTO>();

	private List<EmployeeLanguageDTO> employeeLanguage = new ArrayList<EmployeeLanguageDTO>();

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param middleName
	 *            the middleName to set
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
	 * @param lastName
	 *            the lastName to set
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
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the gender
	 */
	public DropDownDTO getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(DropDownDTO gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining
	 *            the dateOfJoining to set
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
	 * @param dateOfResignation
	 *            the dateOfResignation to set
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
	 * @param profileImage
	 *            the profileImage to set
	 */
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	/**
	 * @return the jobTitle
	 */
	public DropDownDTO getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(DropDownDTO jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the secondaryjobTitle
	 */
	public DropDownDTO getSecondaryjobTitle() {
		return secondaryjobTitle;
	}

	/**
	 * @param secondaryjobTitle
	 *            the secondaryjobTitle to set
	 */
	public void setSecondaryjobTitle(DropDownDTO secondaryjobTitle) {
		this.secondaryjobTitle = secondaryjobTitle;
	}

	/**
	 * @return the location
	 */
	public DropDownDTO getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(DropDownDTO location) {
		this.location = location;
	}

	/**
	 * @return the nationality
	 */
	public DropDownDTO getNationality() {
		return nationality;
	}

	/**
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(DropDownDTO nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the maritalStatus
	 */
	public DropDownDTO getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *            the maritalStatus to set
	 */
	public void setMaritalStatus(DropDownDTO maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the roleType
	 */
	public DropDownDTO getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType
	 *            the roleType to set
	 */
	public void setRoleType(DropDownDTO roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the advisorDetails
	 */
	public AdvisorAdditionDetailDTO getAdvisorDetails() {
		return advisorDetails;
	}

	/**
	 * @param advisorDetails
	 *            the advisorDetails to set
	 */
	public void setAdvisorDetails(AdvisorAdditionDetailDTO advisorDetails) {
		this.advisorDetails = advisorDetails;
	}

	/**
	 * @return the employeeAddress
	 */
	public List<EmployeeAddressDTO> getEmployeeAddress() {
		return employeeAddress;
	}

	/**
	 * @param employeeAddress
	 *            the employeeAddress to set
	 */
	public void setEmployeeAddress(List<EmployeeAddressDTO> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	/**
	 * @return the awardsandAchievements
	 */
	public List<EmployeeAwardsDTO> getAwardsandAchievements() {
		return awardsandAchievements;
	}

	/**
	 * @param awardsandAchievements
	 *            the awardsandAchievements to set
	 */
	public void setAwardsandAchievements(List<EmployeeAwardsDTO> awardsandAchievements) {
		this.awardsandAchievements = awardsandAchievements;
	}

	/**
	 * @return the employeeCertifications
	 */
	public List<EmployeeCertificationsDTO> getEmployeeCertifications() {
		return employeeCertifications;
	}

	/**
	 * @param employeeCertifications
	 *            the employeeCertifications to set
	 */
	public void setEmployeeCertifications(List<EmployeeCertificationsDTO> employeeCertifications) {
		this.employeeCertifications = employeeCertifications;
	}

	/**
	 * @return the employeeContacts
	 */
	public List<EmployeeContactDTO> getEmployeeContacts() {
		return employeeContacts;
	}

	/**
	 * @param employeeContacts
	 *            the employeeContacts to set
	 */
	public void setEmployeeContacts(List<EmployeeContactDTO> employeeContacts) {
		this.employeeContacts = employeeContacts;
	}

	/**
	 * @return the employeeEducation
	 */
	public List<EmployeeEducationDTO> getEmployeeEducation() {
		return employeeEducation;
	}

	/**
	 * @param employeeEducation
	 *            the employeeEducation to set
	 */
	public void setEmployeeEducation(List<EmployeeEducationDTO> employeeEducation) {
		this.employeeEducation = employeeEducation;
	}

	/**
	 * @return the employeeEmails
	 */
	public List<EmployeeEmailsDTO> getEmployeeEmails() {
		return employeeEmails;
	}

	/**
	 * @param employeeEmails
	 *            the employeeEmails to set
	 */
	public void setEmployeeEmails(List<EmployeeEmailsDTO> employeeEmails) {
		this.employeeEmails = employeeEmails;
	}

	/**
	 * @return the employeeExperience
	 */
	public List<EmployeeExperienceDTO> getEmployeeExperience() {
		return employeeExperience;
	}

	/**
	 * @param employeeExperience
	 *            the employeeExperience to set
	 */
	public void setEmployeeExperience(List<EmployeeExperienceDTO> employeeExperience) {
		this.employeeExperience = employeeExperience;
	}

	/**
	 * @return the employeeLanguage
	 */
	public List<EmployeeLanguageDTO> getEmployeeLanguage() {
		return employeeLanguage;
	}

	/**
	 * @param employeeLanguage
	 *            the employeeLanguage to set
	 */
	public void setEmployeeLanguage(List<EmployeeLanguageDTO> employeeLanguage) {
		this.employeeLanguage = employeeLanguage;
	}
}
