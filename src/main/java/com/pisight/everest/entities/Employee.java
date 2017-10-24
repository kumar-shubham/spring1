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
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -8999856626004660283L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "uuid-char")
	private UUID id;

	@OneToOne
	@JoinColumn(name = "user_id", unique = true, nullable = false, updatable = false)
	private User user;

	@GenericGenerator(name = "employee_id", strategy = "employee_id")
	@GeneratedValue(generator = "employee_id")
	@Column(name = "employee_id", unique = true, nullable = false)
	private String employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "display_name")
	private String displayName;

	@ManyToOne
	@JoinColumn(name = "gender")
	private DropDownList gender;
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Column(name = "date_of_resignation")
	private Date dateOfResignation;

	@Column(name = "icon", columnDefinition = "MEDIUMBLOB")
	private byte[] profileImage;

	@ManyToOne
	@JoinColumn(name = "job_title")
	private DropDownList jobTitle;

	@ManyToOne
	@JoinColumn(name = "secondary_job_title")
	private DropDownList secondaryjobTitle;

	@ManyToOne
	@JoinColumn(name = "location")
	private DropDownList location;

	@ManyToOne
	@JoinColumn(name = "nationality")
	private DropDownList nationality;

	@ManyToOne
	@JoinColumn(name = "marital_status")
	private DropDownList maritalStatus;

	@ManyToOne
	@JoinColumn(name = "role_type")
	private DropDownList roleType;
	
	@Column(name = "summary", columnDefinition = "VARCHAR(1337)")
	private String summary;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updatedAt;

	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "entity_status")
	private EntityStatus entityStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeAddresses> employeeAddresses = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeAwardsAndAchievements> achievements = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeCertificationDetails> certificationDetails = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeContactNumbers> contactNumbers = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeEducationDetails> educationDetails = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeEmails> emails = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeExperienceDetails> experienceDetails = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeLanguage> employeeLanguages = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<EmployeeManager> employeeManagers = new ArrayList<>();

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @param employeeId
	 *            the employeeId to set
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
	 * @return the secondaryjobTitle
	 */
	public DropDownList getSecondaryjobTitle() {
		return secondaryjobTitle;
	}

	/**
	 * @param secondaryjobTitle
	 *            the secondaryjobTitle to set
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
	 * @param location
	 *            the location to set
	 */
	public void setLocation(DropDownList location) {
		this.location = location;
	}

	/**
	 * @return the gender
	 */
	public DropDownList getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(DropDownList gender) {
		this.gender = gender;
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
	 * @return the maritalStatus
	 */
	public DropDownList getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *            the maritalStatus to set
	 */
	public void setMaritalStatus(DropDownList maritalStatus) {
		this.maritalStatus = maritalStatus;
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
	 * @return the employeeAddresses
	 */
	public List<EmployeeAddresses> getEmployeeAddresses() {
		return employeeAddresses;
	}

	/**
	 * @param employeeAddresses
	 *            the employeeAddresses to set
	 */
	public void setEmployeeAddresses(List<EmployeeAddresses> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	/**
	 * @return the achievements
	 */
	public List<EmployeeAwardsAndAchievements> getAchievements() {
		return achievements;
	}

	/**
	 * @param achievements
	 *            the achievements to set
	 */
	public void setAchievements(List<EmployeeAwardsAndAchievements> achievements) {
		this.achievements = achievements;
	}

	/**
	 * @return the certificationDetails
	 */
	public List<EmployeeCertificationDetails> getCertificationDetails() {
		return certificationDetails;
	}

	/**
	 * @param certificationDetails
	 *            the certificationDetails to set
	 */
	public void setCertificationDetails(List<EmployeeCertificationDetails> certificationDetails) {
		this.certificationDetails = certificationDetails;
	}

	/**
	 * @return the contactNumbers
	 */
	public List<EmployeeContactNumbers> getContactNumbers() {
		return contactNumbers;
	}

	/**
	 * @param contactNumbers
	 *            the contactNumbers to set
	 */
	public void setContactNumbers(List<EmployeeContactNumbers> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	/**
	 * @return the educationDetails
	 */
	public List<EmployeeEducationDetails> getEducationDetails() {
		return educationDetails;
	}

	/**
	 * @param educationDetails
	 *            the educationDetails to set
	 */
	public void setEducationDetails(List<EmployeeEducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	/**
	 * @return the emails
	 */
	public List<EmployeeEmails> getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(List<EmployeeEmails> emails) {
		this.emails = emails;
	}

	/**
	 * @return the experienceDetails
	 */
	public List<EmployeeExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	/**
	 * @param experienceDetails
	 *            the experienceDetails to set
	 */
	public void setExperienceDetails(List<EmployeeExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	/**
	 * @return the employeeLanguages
	 */
	public List<EmployeeLanguage> getEmployeeLanguages() {
		return employeeLanguages;
	}

	/**
	 * @param employeeLanguages
	 *            the employeeLanguages to set
	 */
	public void setEmployeeLanguages(List<EmployeeLanguage> employeeLanguages) {
		this.employeeLanguages = employeeLanguages;
	}

	/**
	 * @return the roleType
	 */
	public DropDownList getRoleType() {
		return roleType;
	}
	

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}


	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}


	/**
	 * @param roleType
	 *            the roleType to set
	 */
	public void setRoleType(DropDownList roleType) {
		this.roleType = roleType;
	}


	/**
	 * @return the employeeManagers
	 */
	public List<EmployeeManager> getEmployeeManagers() {
		return employeeManagers;
	}

	/**
	 * @param employeeManagers
	 *            the employeeManagers to set
	 */
	public void setEmployeeManagers(List<EmployeeManager> employeeManagers) {
		this.employeeManagers = employeeManagers;
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
