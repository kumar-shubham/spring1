package com.pisight.everest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;
import com.pisight.everest.dto.AdvisorAdditionDetailDTO;
import com.pisight.everest.dto.AdvisorVestingRightDTO;
import com.pisight.everest.dto.EmployeeAddressDTO;
import com.pisight.everest.dto.EmployeeAwardsDTO;
import com.pisight.everest.dto.EmployeeCertificationsDTO;
import com.pisight.everest.dto.EmployeeContactDTO;
import com.pisight.everest.dto.EmployeeDTO;
import com.pisight.everest.dto.EmployeeEducationDTO;
import com.pisight.everest.dto.EmployeeEmailsDTO;
import com.pisight.everest.dto.EmployeeExperienceDTO;
import com.pisight.everest.dto.EmployeeLanguageDTO;
import com.pisight.everest.dto.EmployeeRequest;
import com.pisight.everest.dto.EmployeeResponse;
import com.pisight.everest.entities.AddressEntity;
import com.pisight.everest.entities.Advisor;
import com.pisight.everest.entities.AdvisorAdditionalDetails;
import com.pisight.everest.entities.AdvisorVestingRights;
import com.pisight.everest.entities.AdvisoryGroup;
import com.pisight.everest.entities.AdvisoryGroupAdvisorMap;
import com.pisight.everest.entities.ContactEntity;
import com.pisight.everest.entities.Employee;
import com.pisight.everest.entities.EmployeeAddresses;
import com.pisight.everest.entities.EmployeeAwardsAndAchievements;
import com.pisight.everest.entities.EmployeeCertificationDetails;
import com.pisight.everest.entities.EmployeeContactNumbers;
import com.pisight.everest.entities.EmployeeEducationDetails;
import com.pisight.everest.entities.EmployeeEmails;
import com.pisight.everest.entities.EmployeeExperienceDetails;
import com.pisight.everest.entities.EmployeeLanguage;
import com.pisight.everest.entities.User;
import com.pisight.everest.exception.EverestException;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@Service
public class EmployeeServiceImpl extends BaseService {

	private static HashMap<String, Integer> processLevelMap = new HashMap<String, Integer>();

	/*----------------------------------------Employee-------------------------------------------------*/
	public JSONObject addEmployee(EmployeeDTO request) {

		String processId = null;

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		try {
			if (request == null) {
				ScriptLogger.writeInfo("Request is null");
				throw new EverestException("Invalid or Null Request");
			}

			String primaryEmail = getPrimaryEmailFromDto(request.getEmployeeEmails());

			if (primaryEmail == null) {
				ScriptLogger.writeInfo("primaryEmail is null");
				throw new EverestException("primaryEmail not found");
			}
			processId = generateRandomPassword();

			User user = new User();
			user.setActive(false);
			user.setUsername(primaryEmail);
			user.setPassword(generateRandomPassword());
			user.setEmail(primaryEmail);
			user.setUserRole(everestDAO.fetchUserRoleByRole(request.getUserRole()));
			user.setProcessId(processId);
			user.setEntityStatus(EntityStatus.Processing);

			User tempUser1 = everestDAO.fetchUserByEmail(primaryEmail);
			if (tempUser1 != null) {
				throw new EverestException("Email already exists");
			}
			everestDAO.saveUser(user);
			processLevelMap.put(processId, 1);
			/*--------------------------------------Employee-----------------------------------------*/

			Employee old = everestDAO.fetchEmployeeByEmpId(request.getEmployeeId());
			if (old != null) {
				throw new EverestException("An Employee with same employee Id already Exists");
			}

			Employee employee = new Employee();
			employee.setUser(user);

			employee.setEmployeeId(request.getEmployeeId());
			employee.setFirstName(request.getFirstName());
			employee.setMiddleName(request.getMiddleName());
			employee.setLastName(request.getLastName());
			employee.setDisplayName(request.getDisplayName());
			employee.setGender(fetchDropdown(request.getGender()));
			employee.setDateOfJoining(request.getDateOfJoining());
			employee.setDateOfResignation(request.getDateOfResignation());
			employee.setProfileImage(request.getProfileImage());
			employee.setJobTitle(fetchDropdown(request.getJobTitle()));
			employee.setSecondaryjobTitle(fetchDropdown(request.getSecondaryjobTitle()));
			employee.setLocation(fetchDropdown(request.getLocation()));
			employee.setNationality(fetchDropdown(request.getNationality()));
			employee.setMaritalStatus(fetchDropdown(request.getMaritalStatus()));
			employee.setRoleType(fetchDropdown(request.getRoleType()));
			employee.setRemarks(request.getRemarks());
			employee.setProcessId(processId);
			employee.setEntityStatus(EntityStatus.Processing);

			everestDAO.saveEmployee(employee);
			processLevelMap.put(processId, 2);
			if ("ADVISOR".equals(employee.getRoleType().getValue())) {
				saveAdvisorByRole(employee, request, processId);
			}
			// process level is now 6
			/*--------------------------------------get list of attributes-----------------------------------------*/

			List<EmployeeAddressDTO> employeeAddress = request.getEmployeeAddress();
			List<EmployeeAwardsDTO> awardsandAchievements = request.getAwardsandAchievements();
			List<EmployeeCertificationsDTO> employeeCertifications = request.getEmployeeCertifications();
			List<EmployeeContactDTO> employeeContacts = request.getEmployeeContacts();
			List<EmployeeEducationDTO> employeeEducation = request.getEmployeeEducation();
			List<EmployeeEmailsDTO> employeeEmails = request.getEmployeeEmails();
			List<EmployeeExperienceDTO> employeeExperience = request.getEmployeeExperience();
			List<EmployeeLanguageDTO> employeeLanguage = request.getEmployeeLanguage();

			EmployeeAddresses addresses = null;
			AddressEntity addressEntity = null;

			for (EmployeeAddressDTO addressDTO : employeeAddress) {
				addresses = new EmployeeAddresses();
				addresses.setEmployee(employee);

				addressEntity = new AddressEntity();
				addressEntity.setAddress1(addressDTO.getAddress1());
				addressEntity.setAddress2(addressDTO.getAddress2());
				addressEntity.setCity(addressDTO.getCity());
				addressEntity.setCountry(addressDTO.getCountry());
				addressEntity.setState(addressDTO.getState());
				addressEntity.setUnitNumber(addressDTO.getUnitNo());
				addressEntity.setProcessId(processId);
				addressEntity.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveAddressEntity(addressEntity);
				processLevelMap.put(processId, 7);
				addresses.setAddressEntity(addressEntity);
				addresses.setAddressType(fetchDropdown(addressDTO.getAddressType()));
				addresses.setProcessId(processId);
				addresses.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveEmployeeAddress(addresses);
				processLevelMap.put(processId, 8);
			}

			EmployeeAwardsAndAchievements achievements = null;

			for (EmployeeAwardsDTO awardsDTO : awardsandAchievements) {
				achievements = new EmployeeAwardsAndAchievements();
				achievements.setDescription(awardsDTO.getDescription());
				achievements.setEmployee(employee);
				achievements.setProcessId(processId);
				achievements.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveEmployeeAwardsAndAchievements(achievements);
				processLevelMap.put(processId, 9);
			}
			EmployeeCertificationDetails certificationDetails = null;

			for (EmployeeCertificationsDTO certificationsDTO : employeeCertifications) {
				certificationDetails = new EmployeeCertificationDetails();
				certificationDetails.setEmployee(employee);
				certificationDetails.setInstitute(certificationsDTO.getInstitute());
				certificationDetails.setName(certificationsDTO.getName());
				certificationDetails.setSpecialisation(certificationsDTO.getSpecialisation());
				certificationDetails.setStartDate(certificationsDTO.getStartDate());
				certificationDetails.setToDate(certificationsDTO.getToDate());
				certificationDetails.setSpecialisation(certificationsDTO.getSpecialisation());
				certificationDetails.setProcessId(processId);
				certificationDetails.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveEmployeeCertification(certificationDetails);
				processLevelMap.put(processId, 10);
			}

			EmployeeContactNumbers contactNumbers = null;
			ContactEntity contactEntity = null;

			for (EmployeeContactDTO contactDTO : employeeContacts) {
				contactNumbers = new EmployeeContactNumbers();
				contactNumbers.setEmployee(employee);
				contactNumbers.setPrimaryContact(contactDTO.isPrimaryContact());
				contactNumbers.setProcessId(processId);
				contactNumbers.setEntityStatus(EntityStatus.Processing);

				contactEntity = new ContactEntity();
				contactEntity.setAreaCode(contactDTO.getAreaCode());
				contactEntity.setCountryCode(contactDTO.getCountryCode());
				contactEntity.setNumber(contactDTO.getNumber());
				contactEntity.setType(fetchDropdown(contactDTO.getType()));
				contactEntity.setProcessId(processId);
				contactEntity.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveContactEntity(contactEntity);
				processLevelMap.put(processId, 11);
				contactNumbers.setContactEntity(contactEntity);
				contactNumbers.setType(fetchDropdown(contactDTO.getType()));
				everestDAO.saveEmployeeContact(contactNumbers);
				processLevelMap.put(processId, 12);
			}

			EmployeeEducationDetails educationDetails = null;

			for (EmployeeEducationDTO educationDTO : employeeEducation) {

				educationDetails = new EmployeeEducationDetails();
				educationDetails.setEmployee(employee);
				educationDetails.setFromDate(educationDTO.getFromDate());
				educationDetails.setToDate(educationDTO.getToDate());
				educationDetails.setInstituteName(educationDTO.getInstituteName());
				educationDetails.setPersuing(educationDTO.isPersuing());
				educationDetails.setProgramOrDegree(educationDTO.getProgramOrDegree());
				educationDetails.setSpecialisation(educationDTO.getSpecialisation());
				educationDetails.setStatus(educationDTO.isStatus());
				educationDetails.setProcessId(processId);
				educationDetails.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveEmployeeEducationDetails(educationDetails);
				processLevelMap.put(processId, 13);
			}

			EmployeeEmails emails = null;

			for (EmployeeEmailsDTO emailsDTO : employeeEmails) {

				emails = new EmployeeEmails();
				emails.setEmployee(employee);
				emails.setEmail(emailsDTO.getEmail());
				emails.setPrimary(emailsDTO.isPrimaryEmail());
				emails.setProcessId(processId);
				emails.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveEmployeeEmails(emails);
				processLevelMap.put(processId, 14);
			}

			EmployeeExperienceDetails experienceDetails = null;

			for (EmployeeExperienceDTO experienceDTO : employeeExperience) {
				experienceDetails = new EmployeeExperienceDetails();

				experienceDetails.setEmployee(employee);
				experienceDetails.setCompanyName(experienceDTO.getCompanyName());
				experienceDetails.setCurrentlyWorking(experienceDTO.isCurrentlyWorking());
				experienceDetails.setDesignation(experienceDTO.getDesignation());
				experienceDetails.setFromDate(experienceDTO.getFromDate());
				experienceDetails.setToDate(experienceDTO.getToDate());
				experienceDetails.setLocation(experienceDTO.getLocation());
				experienceDetails.setRoleDescription(experienceDTO.getRoleDescription());
				experienceDetails.setProcessId(processId);
				experienceDetails.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveEmployeeExperienceDetails(experienceDetails);
				processLevelMap.put(processId, 15);
			}

			EmployeeLanguage language = null;

			for (EmployeeLanguageDTO languageDTO : employeeLanguage) {
				language = new EmployeeLanguage();
				language.setEmployee(employee);
				language.setLanguage(languageDTO.getLanguage());
				language.setProficiency(fetchDropdown(languageDTO.getProficiency()));
				language.setProcessId(processId);
				language.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveEmployeeLanguage(language);
				processLevelMap.put(processId, 16);
			}

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Employee Added Sucessfully";
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in adding Employee", e);
			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in adding Employee";
			}
			deleteProcessingDetailsForAddEmployee(processId);
		}
		finally {
			if(processLevelMap.containsKey(processId)) {
				processLevelMap.remove(processId);
			}
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addEmployee>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	private void saveAdvisorByRole(Employee employee, EmployeeDTO request, String processId) {

		/*--------------------------------------AdvisorAdditionDetailDTO--and --AdvisorVestingRightDTO---------------------*/
		long start = System.currentTimeMillis();

		AdvisorAdditionDetailDTO advisorDetailsDTO = request.getAdvisorDetails();
		AdvisorVestingRightDTO advisorVestingRightDTO = advisorDetailsDTO.getAdvisorVestingRights();

		AdvisorAdditionalDetails additionalDetails = new AdvisorAdditionalDetails();
		AdvisorVestingRights advisorVestingRights = new AdvisorVestingRights();

		Advisor advisor = new Advisor();
		advisor.setEmployee(employee);
		advisor.setFirstName(request.getFirstName());
		advisor.setLastName(request.getLastName());
		advisor.setMiddleName(request.getMiddleName());
		advisor.setBSCscore(advisorDetailsDTO.getBSCscore());
		advisor.setProfileImage(request.getProfileImage());
		advisor.setProcessId(processId);
		advisor.setEntityStatus(EntityStatus.Processing);
		everestDAO.saveAdvisor(advisor);
		processLevelMap.put(processId, 3);
		advisorVestingRights.setVestingRight(fetchDropdown(advisorVestingRightDTO.getVestingRight()));
		advisorVestingRights.setEffectiveDate(advisorVestingRightDTO.getEffectiveDate());
		advisorVestingRights.setExpiryDate(advisorVestingRightDTO.getExpiryDate());
		advisorVestingRights.setAdvisorAdditonalDetail(additionalDetails);
		advisorVestingRights.setProcessId(processId);
		advisorVestingRights.setEntityStatus(EntityStatus.Processing);

		additionalDetails.setContractId(advisorDetailsDTO.getContractId());
		additionalDetails.setAdvisoryGroup(advisorDetailsDTO.getAdvisoryGroup());
		additionalDetails.setAdvisorVestingRights(advisorVestingRights);
		additionalDetails.setEffectiveDateOfTransPenalty(advisorDetailsDTO.getEffectiveDateOfTransPenalty());
		additionalDetails.setExpirationDateOfTransPenalty(advisorDetailsDTO.getExpirationDateOfTransPenalty());
		additionalDetails.setExpYearOfTransPenalty(fetchDropdown(advisorDetailsDTO.getYearOfTransPenalty()));
		additionalDetails.setJoinedCompetitor(fetchDropdown(advisorDetailsDTO.getJoinedCompetitor()));
		additionalDetails.setLastCommisionDate(additionalDetails.getLastCommisionDate());
		additionalDetails.setSelectedFAR(additionalDetails.getSelectedFAR());
		additionalDetails.setAdvisor(advisor);
		additionalDetails.setProcessId(processId);
		additionalDetails.setEntityStatus(EntityStatus.Processing);

		everestDAO.saveAdvisorAdditionalDetails(additionalDetails);
		processLevelMap.put(processId, 4);
		everestDAO.saveAdvisorVastingRight(advisorVestingRights);
		processLevelMap.put(processId, 5);

		String advisorGroupId = advisorDetailsDTO.getAdvisoryGroupId();
		AdvisoryGroup advisoryGroup = null;

		if (StringUtils.isNotEmpty(advisorGroupId)) {
			advisoryGroup = everestDAO.fetchAdvisoryGroup(UUID.fromString(advisorGroupId));
		}

		if (advisoryGroup != null) {

			AdvisoryGroupAdvisorMap advisoryGroupAdvisorMap = new AdvisoryGroupAdvisorMap();
			advisoryGroupAdvisorMap.setAdvisor(advisor);
			advisoryGroupAdvisorMap.setAdvisoryGroup(advisoryGroup);

			everestDAO.saveAdvisoryGroupAdvisorMap(advisoryGroupAdvisorMap);
			processLevelMap.put(processId, 6);
		}

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>saveAdvisorByRole>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);
	}

	public List<Employee> getEmployess() {
		return everestDAO.fetchEmployees();
	}

	public JSONObject getEmployeeByempId(EmployeeRequest request) {
		return getEmployee(request, "EMPLOYEE_ID");
	}

	public JSONObject getEmployeeByUserId(EmployeeRequest request) {
		return getEmployee(request, "USER_ID");
	}

	@SuppressWarnings("unchecked")
	public JSONObject getEmployee(EmployeeRequest request, String type) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		Employee employee = null;
		EmployeeResponse employeeResponse = new EmployeeResponse();

		try {
			if ("EMPLOYEE_ID".equals(type)) {

				if (StringUtils.isNotEmpty(request.getEmployeeId())) {
					employee = everestDAO.fetchEmployeeByEmpId(request.getEmployeeId());
				} else {
					throw new EverestException("Employee Id cannot be null");
				}
			} else if ("USER_ID".equals(type)) {

				if (StringUtils.isNotEmpty(request.getUserId())) {
					employee = everestDAO.fetchEmployeeByUserId(UUID.fromString(request.getUserId()));
				} else {
					throw new EverestException("UserId cannot be null");
				}
			}

			if (employee != null) {

				employeeResponse.setId(employee.getId());
				employeeResponse.setDisplayName(employee.getDisplayName());
				employeeResponse.setEmployeeId(employee.getEmployeeId());
				employeeResponse.setFirstName(employee.getFirstName());
				employeeResponse.setGender(employee.getGender());
				employeeResponse.setJobTitle(employee.getJobTitle());
				employeeResponse.setLastName(employee.getLastName());
				employeeResponse.setLocation(employee.getLocation());
				employeeResponse.setMaritalStatus(employee.getMaritalStatus());
				employeeResponse.setDateOfJoining(employee.getDateOfJoining());
				employeeResponse.setDateOfResignation(employee.getDateOfResignation());

				List<EmployeeAddresses> employeeAddresses = employee.getEmployeeAddresses();
				List<EmployeeAddressDTO> employeeAddressDTOs = new ArrayList<>();

				for (EmployeeAddresses address : employeeAddresses) {
					EmployeeAddressDTO addressDTO = new EmployeeAddressDTO();
					AddressEntity entity = address.getAddressEntity();
					addressDTO.setAddress1(entity.getAddress1());
					addressDTO.setAddress2(entity.getAddress2());
					addressDTO.setCity(entity.getCity());
					addressDTO.setCountry(entity.getCountry());
					addressDTO.setId(entity.getId());
					addressDTO.setPinCode(entity.getPinCode());
					addressDTO.setState(entity.getState());
					addressDTO.setUnitNo(entity.getUnitNumber());

					employeeAddressDTOs.add(addressDTO);
				}

				employeeResponse.setAddressList(employeeAddressDTOs);

				List<EmployeeAwardsAndAchievements> achievements = employee.getAchievements();
				List<EmployeeAwardsDTO> awardsDTOs = new ArrayList<>();

				for (EmployeeAwardsAndAchievements awardsAndAchievements : achievements) {
					EmployeeAwardsDTO employeeAwardsDTO = new EmployeeAwardsDTO();
					employeeAwardsDTO.setId(awardsAndAchievements.getId());
					employeeAwardsDTO.setDescription(awardsAndAchievements.getDescription());
					awardsDTOs.add(employeeAwardsDTO);
				}
				employeeResponse.setAwardsList(awardsDTOs);

				List<EmployeeCertificationDetails> certificationDetails = employee.getCertificationDetails();
				List<EmployeeCertificationsDTO> certificationsDTOs = new ArrayList<>();

				for (EmployeeCertificationDetails employeeCertificationDetails : certificationDetails) {
					EmployeeCertificationsDTO employeeCertificationsDTO = new EmployeeCertificationsDTO();
					employeeCertificationsDTO.setId(employeeCertificationDetails.getId());
					employeeCertificationsDTO.setInstitute(employeeCertificationDetails.getInstitute());
					employeeCertificationsDTO.setName(employeeCertificationDetails.getName());
					employeeCertificationsDTO.setSpecialisation(employeeCertificationDetails.getSpecialisation());
					employeeCertificationsDTO.setStartDate(employeeCertificationDetails.getStartDate());
					employeeCertificationsDTO.setToDate(employeeCertificationDetails.getToDate());

					certificationsDTOs.add(employeeCertificationsDTO);

				}
				employeeResponse.setCertificationsList(certificationsDTOs);

				List<EmployeeContactNumbers> contactNumbers = employee.getContactNumbers();
				List<EmployeeContactDTO> contactDTOs = new ArrayList<>();

				for (EmployeeContactNumbers employeeContactNumbers : contactNumbers) {
					EmployeeContactDTO contactDTO = new EmployeeContactDTO();
					ContactEntity entity = employeeContactNumbers.getContactEntity();

					contactDTO.setId(employeeContactNumbers.getId());
					contactDTO.setAreaCode(entity.getAreaCode());
					contactDTO.setCountryCode(entity.getCountryCode());
					contactDTO.setNumber(entity.getNumber());
					contactDTO.setType(convertDropDownListTodropDownDTO(entity.getType()));
					contactDTOs.add(contactDTO);

				}
				employeeResponse.setContactList(contactDTOs);

				List<EmployeeEducationDetails> educationDetails = employee.getEducationDetails();
				List<EmployeeEducationDTO> educationDTOs = new ArrayList<>();

				for (EmployeeEducationDetails employeeEducationDetails : educationDetails) {
					EmployeeEducationDTO employeeEducationDTO = new EmployeeEducationDTO();

					employeeEducationDTO.setId(employeeEducationDetails.getId());
					employeeEducationDTO.setFromDate(employeeEducationDetails.getFromDate());
					employeeEducationDTO.setInstituteName(employeeEducationDetails.getInstituteName());
					employeeEducationDTO.setPersuing(employeeEducationDetails.isPersuing());
					employeeEducationDTO.setProgramOrDegree(employeeEducationDetails.getProgramOrDegree());
					employeeEducationDTO.setSpecialisation(employeeEducationDetails.getSpecialisation());
					employeeEducationDTO.setStatus(employeeEducationDetails.isStatus());
					employeeEducationDTO.setToDate(employeeEducationDetails.getToDate());

					educationDTOs.add(employeeEducationDTO);
				}
				employeeResponse.setEducationList(educationDTOs);

				List<EmployeeEmails> emails = employee.getEmails();
				List<EmployeeEmailsDTO> emailsDTOs = new ArrayList<>();

				for (EmployeeEmails employeeEmails : emails) {
					EmployeeEmailsDTO employeeEmailsDTO = new EmployeeEmailsDTO();
					employeeEmailsDTO.setEmail(employeeEmails.getEmail());
					employeeEmailsDTO.setId(employeeEmails.getId());
					employeeEmailsDTO.setPrimaryEmail(employeeEmails.isPrimary());

					emailsDTOs.add(employeeEmailsDTO);
				}
				employeeResponse.setEmailsList(emailsDTOs);

				List<EmployeeExperienceDetails> experienceDetails = employee.getExperienceDetails();
				List<EmployeeExperienceDTO> experienceDTOs = new ArrayList<>();

				for (EmployeeExperienceDetails empExp : experienceDetails) {

					EmployeeExperienceDTO employeeExperienceDTO = new EmployeeExperienceDTO();
					employeeExperienceDTO.setId(empExp.getId());
					employeeExperienceDTO.setCompanyName(empExp.getCompanyName());
					employeeExperienceDTO.setCurrentlyWorking(empExp.isCurrentlyWorking());
					employeeExperienceDTO.setDesignation(empExp.getDesignation());
					employeeExperienceDTO.setFromDate(empExp.getFromDate());
					employeeExperienceDTO.setLocation(empExp.getLocation());
					employeeExperienceDTO.setRoleDescription(empExp.getRoleDescription());
					employeeExperienceDTO.setToDate(empExp.getToDate());

					experienceDTOs.add(employeeExperienceDTO);

				}
				employeeResponse.setEmployeeExperienceList(experienceDTOs);

				List<EmployeeLanguage> employeeLanguages = employee.getEmployeeLanguages();
				List<EmployeeLanguageDTO> languageDTOs = new ArrayList<>();

				for (EmployeeLanguage empLang : employeeLanguages) {
					EmployeeLanguageDTO employeeLanguageDTO = new EmployeeLanguageDTO();
					employeeLanguageDTO.setId(empLang.getId());
					employeeLanguageDTO.setLanguage(empLang.getLanguage());
					employeeLanguageDTO.setProficiency(convertDropDownListTodropDownDTO(empLang.getProficiency()));

					languageDTOs.add(employeeLanguageDTO);
				}
				employeeResponse.setEmployeeLanguageList(languageDTOs);

				errorCode = 0;
				responseStatus = Constants.SUCCESS;
				responseMessage = "Success";

			}
		} catch (Exception e) {

			ScriptLogger.writeInfo("Error in fetching Employee", e);

			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in fetching Employee";
			}
		}
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("employee", employeeResponse);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getEmployee>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;

	}

	private String getPrimaryEmailFromDto(List<EmployeeEmailsDTO> employeeEmails) {
		for (EmployeeEmailsDTO emailsDTO : employeeEmails) {
			if (emailsDTO.isPrimaryEmail()) {
				return emailsDTO.getEmail();
			}
		}
		return null;
	}

	/*----------------------------------------End Employee-------------------------------------------------*/

	/* ~~~~~~~~~~~~~~~~~~~~~~DeleteByProecssId~~~~~~~~~~~~~~~~~~~~~~~~ */

	private void deleteProcessingDetailsForAddEmployee(String processId) {
		ScriptLogger.writeInfo("inside delete for processId => " + processId);
		int processLevel = 0;
		if (processLevelMap.containsKey(processId)) {
			processLevel = processLevelMap.get(processId);
		}
		ScriptLogger.writeInfo("processLevel => " + processLevel);
		
		if (processLevel > 15) {
			everestDAO.deleteEmployeeLanguageByProcessId(processId);
		}
		if (processLevel > 14) {
			everestDAO.deleteEmployeeExperienceDetailsByProcessId(processId);
		}
		if (processLevel > 13) {
			everestDAO.deleteEmployeeEmailsByProcessId(processId);
		}
		if (processLevel > 12) {
			everestDAO.deleteEmployeeEducationDetailsByProcessId(processId);
		}
		if (processLevel > 11) {
			everestDAO.deleteEmployeeContactNumbersByProcessId(processId);
		}
		if (processLevel > 10) {
			everestDAO.deleteContactEntityByProcessId(processId);
		}
		if (processLevel > 9) {
			everestDAO.deleteEmployeeCertificationDetailsByProcessId(processId);
		}
		if (processLevel > 8) {
			everestDAO.deleteEmployeeAwardsAndAchievementsByProcessId(processId);
		}
		if (processLevel > 7) {
			everestDAO.deleteEmployeeAddressesByProcessId(processId);
		}
		if (processLevel > 6) {
			everestDAO.deleteAddressEntityByProcessId(processId);
		}
		if (processLevel > 5) {
			everestDAO.deleteAdvisoryGroupAdvisorMapByProcessId(processId);
		}
		if (processLevel > 4) {
			everestDAO.deleteAdvisorVestingRightsByProcessId(processId);
		}
		if (processLevel > 3) {
			everestDAO.deleteAdvisorAdditionalDetailsByProcessId(processId);
		}
		if (processLevel > 2) {
			everestDAO.deleteAdvisorByProcessId(processId);
		}
		if (processLevel > 1) {
			everestDAO.deleteEmployeeByProcessId(processId);
		}
		if (processLevel > 0) {
			everestDAO.deleteUserByProcessId(processId);
		}
	}
}


