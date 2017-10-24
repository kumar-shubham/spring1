package com.pisight.everest.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.pisight.everest.entities.AdditionalContactDetails;
import com.pisight.everest.entities.AddressEntity;
import com.pisight.everest.entities.Advisor;
import com.pisight.everest.entities.AdvisorAdditionalDetails;
import com.pisight.everest.entities.AdvisorBusinessClientMap;
import com.pisight.everest.entities.AdvisorIndividualClientMap;
import com.pisight.everest.entities.AdvisorVestingRights;
import com.pisight.everest.entities.AdvisoryGroup;
import com.pisight.everest.entities.AdvisoryGroupAdvisorMap;
import com.pisight.everest.entities.BusinessClient;
import com.pisight.everest.entities.BusinessClientAddress;
import com.pisight.everest.entities.BusinessClientContact;
import com.pisight.everest.entities.BusinessClientEmail;
import com.pisight.everest.entities.BusinessRegistrationDetail;
import com.pisight.everest.entities.Carrier;
import com.pisight.everest.entities.CarrierAddressDetails;
import com.pisight.everest.entities.CarrierContactDetails;
import com.pisight.everest.entities.ContactEntity;
import com.pisight.everest.entities.Department;
import com.pisight.everest.entities.DropDownList;
import com.pisight.everest.entities.DropDownType;
import com.pisight.everest.entities.Employee;
import com.pisight.everest.entities.EmployeeAddresses;
import com.pisight.everest.entities.EmployeeAwardsAndAchievements;
import com.pisight.everest.entities.EmployeeCertificationDetails;
import com.pisight.everest.entities.EmployeeContactNumbers;
import com.pisight.everest.entities.EmployeeEducationDetails;
import com.pisight.everest.entities.EmployeeEmails;
import com.pisight.everest.entities.EmployeeExperienceDetails;
import com.pisight.everest.entities.EmployeeLanguage;
import com.pisight.everest.entities.EmployeeManager;
import com.pisight.everest.entities.HouseHoldDetail;
import com.pisight.everest.entities.HouseholdMember;
import com.pisight.everest.entities.IndividualClient;
import com.pisight.everest.entities.IndividualClientAddress;
import com.pisight.everest.entities.IndividualClientContact;
import com.pisight.everest.entities.IndividualClientEmail;
import com.pisight.everest.entities.IndividualClientIdentity;
import com.pisight.everest.entities.LoginAuditTrail;
import com.pisight.everest.entities.Policy;
import com.pisight.everest.entities.PolicyAdvisorCommissionShare;
import com.pisight.everest.entities.PolicyAdvisorMap;
import com.pisight.everest.entities.PolicyPlan;
import com.pisight.everest.entities.PolicyPlanCommissionRate;
import com.pisight.everest.entities.PolicyPlanRider;
import com.pisight.everest.entities.PolicyPlanTerm;
import com.pisight.everest.entities.PolicyPremium;
import com.pisight.everest.entities.PolicyPremiumCommission;
import com.pisight.everest.entities.PolicyRider;
import com.pisight.everest.entities.PolicyRiderPremium;
import com.pisight.everest.entities.Rider;
import com.pisight.everest.entities.RiderCommissionRate;
import com.pisight.everest.entities.User;
import com.pisight.everest.entities.UserRole;

public interface EverestDAO {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~User related~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	User fetchUser(UUID id);

	User fetchUserByUsername(String username);

	User fetchUserByProcessId(String id);

	User fetchUserByEmail(String email);

	User saveUser(User user);

	UserRole fetchUserRole(UUID id);

	UserRole fetchUserRoleByRole(String role);

	List<UserRole> fetchUserRoles();

	UserRole saveUserRole(UserRole role);

	LoginAuditTrail saveLoginAuditTrail(LoginAuditTrail lat);

	void deleteUserByProcessId(String id);

	void removeUser(User user);

	void removeUserRole(UserRole role);



	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ Carrier ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	Carrier fetchCarrier(UUID id);

	Carrier fetchCarrierByName(String name);

	Carrier fetchCarrierByAbbr(String abbr);

	Carrier fetchCarrierByProcessId(String id);

	List<Carrier> deleteCarrierByProcessId(String id);

	List<Carrier> fetchCarriers();

	Carrier saveCarrier(Carrier carrier);

	void removeCarrier(Carrier carrier);

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ CarrierAddressDetails ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	CarrierAddressDetails saveCarrierAddressDetails(CarrierAddressDetails address);

	CarrierAddressDetails fetchCarrierAddressDetailsByProcessId(String id);

	List<CarrierAddressDetails> deleteCarrierAddressDetailsByProcessId(String id);

	void removeCarrierAddressDetails(CarrierAddressDetails address);

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ CarrierContactDetails ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	CarrierContactDetails saveCarrierContactDetails(CarrierContactDetails contact);

	CarrierContactDetails fetchCarrierContactDetailsByProcessId(String id);

	List<CarrierContactDetails> deleteCarrierContactDetailsByProcessId(String id);

	void removeCarrierContactDetails(CarrierContactDetails contact);


	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ BusinessClient ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	BusinessClient fetchBusinessClient(UUID id);

	BusinessClient fetchBusinessClientByProcessId(String id);

	List<BusinessClient> deleteBusinessClientByProcessId(String id);

	List<BusinessClient> fetchBusinessClients();

	BusinessClient saveBusinessClient(BusinessClient client);
	
	void removeBusinessClient(BusinessClient client);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ BusinessClientAddress ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	BusinessClientAddress saveBusinessClientAddress(BusinessClientAddress address);
	
	void removeBusinessClientAddress(BusinessClientAddress address);

	BusinessClientAddress fetchBusinessClientAddressDetailsByProcessId(String id);

	List<BusinessClientAddress> deleteBusinessClientAddressByProcessId(String id);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ BusinessClientContact ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	BusinessClientContact saveBusinessClientContact(BusinessClientContact contact);
	
	void removeBusinessClientContact(BusinessClientContact contact);

	BusinessClientContact fetchBusinessClientContactDetailsByProcessId(String id);

	List<BusinessClientContact> deleteBusinessClientContactByProcessId(String id);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ BusinessClientEmail ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	BusinessClientEmail saveBusinessClientEmail(BusinessClientEmail email);
	
	void removeBusinessClientEmail(BusinessClientEmail email);
	
	BusinessClientEmail fetchBusinessClientEmailByProcessId(String id);

	List<BusinessClientEmail> deleteBusinessClientEmailByProcessId(String id);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ BusinessRegistrationDetail ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	BusinessRegistrationDetail saveBusinessRegistrationDetail(BusinessRegistrationDetail reg);

	void removeBusinessRegistrationDetail(BusinessRegistrationDetail reg);

	BusinessRegistrationDetail fetchBusinessRegistrationDetailByProcessId(String id);

	void deleteBusinessRegistrationDetailByProcessId(String id);
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ IndividualClient ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	IndividualClient fetchIndividualClient(UUID id);

	IndividualClient fetchIndividualClientByProcessId(String id);

	List<IndividualClient> deleteIndividualClientByProcessId(String id);

	List<IndividualClient> fetchIndividualClients();

	IndividualClient saveIndividualClient(IndividualClient client);
	
	void removeIndividualClient(IndividualClient client);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ IndividualClientAddress ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	IndividualClientAddress saveIndividualClientAddress(IndividualClientAddress address);
	
	void removeIndividualClientAddress(IndividualClientAddress address);
	
	IndividualClientAddress fetchIndividualClientAddressByProcessId(String id);

	void deleteIndividualClientAddressByProcessId(String id);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ IndividualClientIdentity ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	IndividualClientIdentity saveIndividualClientIdentity(IndividualClientIdentity clientIdentity);
	
	IndividualClientIdentity fetchIndividualClientIdentityByProcessId(String id);

	void deleteIndividualClientIdentityByProcessId(String id);
	

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ IndividualClientContact ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	IndividualClientContact saveIndividualClientContact(IndividualClientContact contact);

	void removeIndividualClientContact(IndividualClientContact contact);
	
	IndividualClientContact fetchIndividualClientContactByProcessId(String id);

	void deleteIndividualClientContactByProcessId(String id);
	

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~ IndividualClientEmail ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	IndividualClientEmail saveIndividualClientEmail(IndividualClientEmail email);
	
	void removeIndividualClientEmail(IndividualClientEmail email);

	IndividualClientEmail fetchIndividualClientEmailByProcessId(String id);

	void deleteIndividualClientEmailByProcessId(String id);
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~	Policy~~~~~~~~~~~~~~~~~~~~~ */
	
	
	Policy fetchPolicy(UUID id);

	void removePolicy(Policy policy);

	Policy fetchPolicyByProcessId(String id);

	List<Policy> deletePolicyByProcessId(String id);

	Policy savePolicy(Policy policy);

	List<Policy> fetchPolicies();

	Policy fetchPolicyByPolicyPlan(PolicyPlan plan);

	/* ~~~~~~~~~~~~~~~~~~~~~~~~	PolicyRider~~~~~~~~~~~~~~~~~~~~~ */

	PolicyRider savePolicyRider(PolicyRider policyRider);

	PolicyRider fetchPolicyRider(UUID id);

	PolicyRider fetchPolicyRiderByProcessId(String id);

	List<PolicyRider> deletePolicyRiderByProcessId(String id);

	PolicyRiderPremium savePolicyRiderPremium(PolicyRiderPremium policyRiderPremium);

	void removePolicyRiderPremium(PolicyRiderPremium policyRiderPremium);

	/* ~~~~~~~~~~~~~~~~~~~~~~~~	PolicyPremium~~~~~~~~~~~~~~~~~~~~~ */

	PolicyPremium savePolicyPremium(PolicyPremium policyPremium);

	PolicyPremium fetchPolicyPremium(UUID id);

	PolicyPremium fetchPolicyPremiumByPolicy(Policy policcy);

	PolicyPremium fetchPolicyPremiumByProcessId(String id);

	List<PolicyPremium> deletePolicyPremiumByProcessId(String id);

	void removePolicyPremium(PolicyPremium policyPremium);

	/* ~~~~~~~~~~~~~~~~~~Policy Advisor Map~~~~~~~~~~~~~~~~~~~~~~~~~ */

	PolicyAdvisorMap savePolicyAdvisorMap(PolicyAdvisorMap policyAdvisorMap);

	PolicyAdvisorMap fetchPolicyAdvisorMap(UUID id);

	PolicyAdvisorMap fetchPolicyAdvisorMapByProcessId(String id);

	List<PolicyAdvisorMap> deletePolicyAdvisorMapPremiumByProcessId(String id);

	PolicyAdvisorMap savePolicyAdvisor(PolicyAdvisorMap policyAdvisorMap);

	void removePolicyAdvisor(PolicyAdvisorMap policyAdvisorMap);

	List<PolicyAdvisorMap> fetchPolicyAdvisors();

	/* ~~~~~~~~~~~~~~~~~~~~~~~~PolicyPremiumCommission~~~~~~~~~~~~~~~~~~~~~ */
	
	PolicyPremiumCommission savePolicyPremiumCommission(PolicyPremiumCommission policyPremiumCommission);

	PolicyPremiumCommission fetchPolicyPremiumCommission(UUID id);

	void removePolicyPremiumCommission(PolicyPremiumCommission policyPremiumCommission);

	PolicyPremiumCommission fetchPolicyPremiumCommissionByProcessId(String id);

	void deletePolicyPremiumCommissionByProcessId(String id);

	/* ~~~~~~~~~~~~~~~~~~~~~~~~PolicyAdvisorCommissionShare~~~~~~~~~~~~~~~~~~~~~ */

	PolicyAdvisorCommissionShare savePolicyAdvisorCommissionShare(
			PolicyAdvisorCommissionShare policyAdvisorCommissionShare);

	PolicyAdvisorCommissionShare fetchPolicyAdvisorCommissionShare(UUID id);

	PolicyAdvisorCommissionShare findPolicyAdvisorCommissionShareByAdvisor(Advisor advisor);

	PolicyAdvisorCommissionShare fetchPolicyAdvisorCommissionShareByProcessId(String id);

	void deletePolicyAdvisorCommissionShareByProcessId(String id);

	void removePolicyAdvisorCommissionShare(PolicyAdvisorCommissionShare policyAdvisorCommissionShare);

	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~PolicyPlan~~~~~~~~~~~~~~~~~~~~~ */
	
	PolicyPlan fetchPolicyPlan(UUID id);

	PolicyPlan fetchpoicyPlanByName(String name);

	PolicyPlan fetchPolicyPlanByProcessId(String id);

	List<PolicyPlan> deletePolicyPlanByProcessId(String id);

	List<PolicyPlan> fetchPolicyPlans();

	List<PolicyPlan> fetchPolicyPlansByCarrierID(UUID carrierId);

	PolicyPlan fetchPolicyPlanByCarrierId(UUID carrierId);

	PolicyPlan savePolicyPlan(PolicyPlan plan);
	
	void removePolicyPlan(PolicyPlan plan);

	
	/* ~~~~~~~~~~~~~~~~~PolicyPlanTerm~~~~~~~ */
	
	PolicyPlanTerm savePolicyPlanTerm(PolicyPlanTerm term);

	PolicyPlanTerm fetchPolicyPlanTermById(UUID id);

	void removePolicyPlanTerm(PolicyPlanTerm term);
	
	PolicyPlanTerm fetchPolicyPlanTermByProcessId(String id);

	void deletePolicyPlanTermByProcessId(String id);
	
	
	
	/* ~~~~~~~~~~~~~~~~~PolicyPlanRider~~~~~~~ */
	
	PolicyPlanRider savePolicyPlanRider(PolicyPlanRider planRider);

	PolicyPlanRider fetchPolicyPlanRider(UUID id);
	
	void removePolicyPlanRider(PolicyPlanRider planRider);

	PolicyPlanRider fetchPolicyPlanRiderByProcessId(String id);

	void deletePolicyPlanRiderByProcessId(String id);
	
	
	/* ~~~~~~~~~~~~~~~~~PolicyPlanCommissionRate~~~~~~~ */
	PolicyPlanCommissionRate savePolicyPlanCommissionRate(PolicyPlanCommissionRate term);

	PolicyPlanCommissionRate fetchPolicyPlanCommissionRateByProcessId(String id);
	
	void deletePolicyPlanCommissionRateByProcessId(String id);

	void removePolicyPlanCommissionRate(PolicyPlanCommissionRate term);

	
	/* ~~~~~~~~~~~~~~~~~Rider~~~~~~~~~~~~~~~~~~~ */
	
	Rider fetchRider(UUID id);

	List<Rider> fetchRiders();

	Rider saveRider(Rider rider);

	Rider fetchRiderByProcessId(String id);
	
	void deleteRiderByProcessId(String id);

	void removeRider(Rider rider);

	
	/* ~~~~~~~~~~~~~~~~~RiderCommissionRate~~~~~~~ */
	
	RiderCommissionRate saveRiderCommissionRate(RiderCommissionRate riderRate);

	List<RiderCommissionRate> fetchRiderCommisionRates(UUID planRider);

	void removeRiderCommissionRate(RiderCommissionRate riderRate);
	
	RiderCommissionRate fetchRiderCommissionRateByProcessId(String id);

	void deleteRiderCommissionRateByProcessId(String id);
	

	/* ~~~~~~~~~~~~~~~~~  AddressEntity  ~~~~~~~~~~~~~~~~~~~ */
	
	AddressEntity fetchAddressEntity(UUID id);

	List<AddressEntity> fetchAddressEntities();

	AddressEntity fetchAddressEntityByProcessId(String id);

	AddressEntity saveAddressEntity(AddressEntity address);

	void deleteAddressEntityByProcessId(String id);

	void removeAddressEntity(AddressEntity address);
	
	/* ~~~~~~~~~~~~~~~~~  ContactEntity  ~~~~~~~~~~~~~~~~~~~ */
	
	ContactEntity fetchContactEntity(UUID id);

	List<ContactEntity> fetchContactEntities();

	ContactEntity fetchContactEntityByProcessId(String id);

	ContactEntity saveContactEntity(ContactEntity contact);
	
	void deleteContactEntityByProcessId(String id);

	void removeContactEntity(ContactEntity contact);
	
	/* ~~~~~~~~~~~~~~~~~  AdditionalContactDetails  ~~~~~~~~~~~~~~~~~~~ */

	AdditionalContactDetails saveAdditionalContactDetails(AdditionalContactDetails contact);

	AdditionalContactDetails fetchAdditionalContactDetailsByProcessId(String id);

	void removeAdditionalContactDetails(AdditionalContactDetails contact);

	void deleteAdditionalContactDetailsByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~ Department ~~~~~~~~~~~~~~~ */
	
	Department fetchDepartment(UUID id);

	Department fetchDepartmentByName(String name);

	Department fetchDepartmentByDeptId(String deptId);

	Department saveDepartment(Department dept);

	Department fetchDepartmentByProcessId(String id);

	void removeDepartment(Department dept);

	void deleteDepartmentByProcessId(String id);


	/* ~~~~~~~~~~~~~~~~~ DropdownList ~~~~~~~~~~~~~~~ */
	
	DropDownList fetchDropDownList(UUID id);

	DropDownList fetchDropDownList(String type, String value);

	DropDownList saveDropDownList(DropDownList ddl);

	DropDownList fetchDropDownListByProcessId(String id);
	
	void updateDropDownlist(DropDownList ddl);

	void deleteDropDownListByProcessId(String id);

	void removeDropDownList(DropDownList ddl);

	/* ~~~~~~~~~~~~~~~~~ DropdownType ~~~~~~~~~~~~~~~ */

	DropDownType fetchDropDownType(UUID id);

	DropDownType fetchDropDownTypeByName(String type);

	DropDownType saveDropDownType(DropDownType ddt);

	DropDownType fetchDropDownTypeByProcessId(String id);

	void removeDropDownType(DropDownType ddt);

	void deleteDropDownTypeByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~ Employee ~~~~~~~~~~~~~~~ */

	Employee fetchEmployee(UUID id);

	List<Employee> fetchEmployees();

	Employee fetchEmployeeByProcessId(String id);

	List<Employee> deleteEmployeeByProcessId(String id);

	Employee fetchEmployeeByUserId(UUID id);

	Employee fetchEmployeeByEmpId(String empId);

	Employee saveEmployee(Employee emp);

	void removeEmployee(Employee emp);

	
	/* ~~~~~~~~~~~~~~~~~  EmployeeAddresses  ~~~~~~~~~~~~~~~~~~~ */
	
	EmployeeAddresses saveEmployeeAddress(EmployeeAddresses addresses);

	EmployeeAddresses fetchEmployeeAddressesByProcessId(String id);

	List<EmployeeAddresses> deleteEmployeeAddressesByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~  EmployeeAwardsAndAchievements  ~~~~~~~~~~~~~~~~~~~ */
	
	
	EmployeeAwardsAndAchievements saveEmployeeAwardsAndAchievements(EmployeeAwardsAndAchievements achievements);

	EmployeeAwardsAndAchievements fetchEmployeeAwardsAndAchievementsByProcessId(String id);

	List<EmployeeAwardsAndAchievements> deleteEmployeeAwardsAndAchievementsByProcessId(String id);

	/* ~~~~~~~~~~~~~~~~~  EmployeeCertificationDetails  ~~~~~~~~~~~~~~~~~~~ */
	
	EmployeeCertificationDetails saveEmployeeCertification(EmployeeCertificationDetails certificationDetails);

	EmployeeCertificationDetails fetchEmployeeCertificationDetailsByProcessId(String id);

	List<EmployeeCertificationDetails> deleteEmployeeCertificationDetailsByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~  EmployeeContactNumbers  ~~~~~~~~~~~~~~~~~~~ */
	
	
	EmployeeContactNumbers saveEmployeeContact(EmployeeContactNumbers contactNumbers);

	EmployeeContactNumbers fetchEmployeeContactNumbersByProcessId(String id);

	List<EmployeeContactNumbers> deleteEmployeeContactNumbersByProcessId(String id);

	/* ~~~~~~~~~~~~~~~~~  EmployeeEducationDetails  ~~~~~~~~~~~~~~~~~~~ */
	
	EmployeeEducationDetails saveEmployeeEducationDetails(EmployeeEducationDetails contactNumbers);

	EmployeeEducationDetails fetchEmployeeEducationDetailsByProcessId(String id);

	List<EmployeeEducationDetails> deleteEmployeeEducationDetailsByProcessId(String id);

	/* ~~~~~~~~~~~~~~~~~  EmployeeEmails  ~~~~~~~~~~~~~~~~~~~ */
	
	EmployeeEmails saveEmployeeEmails(EmployeeEmails contactNumbers);

	EmployeeEmails fetchEmployeeEmailsByProcessId(String id);

	List<EmployeeEmails> deleteEmployeeEmailsByProcessId(String id);
	
	/* ~~~~~~~~~~~~~~~~~  EmployeeExperienceDetails  ~~~~~~~~~~~~~~~~~~~ */

	EmployeeExperienceDetails saveEmployeeExperienceDetails(EmployeeExperienceDetails experienceDetails);

	EmployeeExperienceDetails fetchEmployeeExperienceDetailsByProcessId(String id);

	List<EmployeeExperienceDetails> deleteEmployeeExperienceDetailsByProcessId(String id);

	List<AdvisoryGroup> deleteAdvisoryGroupByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~  EmployeeManager  ~~~~~~~~~~~~~~~~~~~ */
	
	EmployeeManager saveEmployeeManager(EmployeeManager contactNumbers);

	EmployeeManager fetchEmployeeManagerByProcessId(String id);

	void deleteEmployeeManagerByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~  EmployeeLanguage  ~~~~~~~~~~~~~~~~~~~ */
	
	EmployeeLanguage saveEmployeeLanguage(EmployeeLanguage contactNumbers);

	EmployeeLanguage fetchEmployeeLanguageByProcessId(String id);

	List<EmployeeLanguage> deleteEmployeeLanguageByProcessId(String id);



	/* ~~~~~~~~~~~~~~~~~  AdvisoryGroup  ~~~~~~~~~~~~~~~~~~~ */
	
	AdvisoryGroup saveEmployeeAdvisoryGroup(AdvisoryGroup advisoryGroup);

	AdvisoryGroup saveAdvisoryGroup(AdvisoryGroup advisoryGroup);

	AdvisoryGroup fetchAdvisoryGroup(UUID id);

	AdvisoryGroup fetchAdvisoryGroupByProcessId(String id);

	List<AdvisoryGroup> fetchAdvisorGroups();
	

	/* ~~~~~~~~~~~~~~~~~  AdvisoryGroupAdvisorMap  ~~~~~~~~~~~~~~~~~~~ */

	AdvisoryGroupAdvisorMap saveAdvisoryGroupAdvisorMap(AdvisoryGroupAdvisorMap advisoryGroup);

	AdvisoryGroupAdvisorMap fetchAdvisoryGroupAdvisorMap(UUID id);

	AdvisoryGroupAdvisorMap fetchAdvisoryGroupAdvisorMapByProcessId(String id);

	List<AdvisoryGroupAdvisorMap> deleteAdvisoryGroupAdvisorMapByProcessId(String id);

	
	
	/* ~~~~~~~~~~~~~~~~~  Advisor  ~~~~~~~~~~~~~~~~~~~ */
	
	Advisor saveAdvisor(Advisor advisor);

	Advisor fetchAdvisor(UUID id);

	Advisor fetchAdvisorByEmployeeID(String id);

	Advisor fetchAdvisorByProcessId(String id);

	List<Advisor> deleteAdvisorByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~  AdvisorAdditionalDetails  ~~~~~~~~~~~~~~~~~~~ */
	
	
	AdvisorAdditionalDetails saveAdvisorAdditionalDetails(AdvisorAdditionalDetails additionalDetails);

	AdvisorAdditionalDetails fetchAdvisorAdditionalDetailsByProcessId(String id);

	void deleteAdvisorAdditionalDetailsByProcessId(String id);

	
	/* ~~~~~~~~~~~~~~~~~  AdvisorVestingRights  ~~~~~~~~~~~~~~~~~~~ */
	
	AdvisorVestingRights saveAdvisorVastingRight(AdvisorVestingRights advisorVestingRights);

	AdvisorVestingRights fetchAdvisorVestingRightsByProcessId(String id);

	List<AdvisorVestingRights> deleteAdvisorVestingRightsByProcessId(String id);


	
	/* ~~~~~~~~~~~~~~~~~  HouseHoldDetail  ~~~~~~~~~~~~~~~~~~~ */
	HouseHoldDetail saveHouseHoldDetail(HouseHoldDetail houseHoldDetail);
	
	HouseHoldDetail fetchHouseHoldDetailByProcessId(String id);

	void deleteHouseHoldDetailByProcessId(String id);
	

	
	/* ~~~~~~~~~~~~~~~~~  HouseholdMember  ~~~~~~~~~~~~~~~~~~~ */
	
	HouseholdMember saveHouseHoldMembers(HouseholdMember householdMember);

	HouseholdMember fetchHouseholdMemberByProcessId(String id);

	List<HouseholdMember> deleteHouseholdMemberByProcessId(String id);

	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~Client Mapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */

	AdvisorIndividualClientMap saveIndividualClientMap(AdvisorIndividualClientMap advisorIndividualClientMap);

	AdvisorIndividualClientMap fetchAdvisorIndividualClientMapByProcessId(String id);

	Set<AdvisorIndividualClientMap> deleteAdvisorIndividualClientMapByProcessId(String id);

	AdvisorBusinessClientMap saveAdvisorBusinessClientMap(AdvisorBusinessClientMap advisorBusinessClientMap);

	AdvisorBusinessClientMap fetchAdvisorBusinessClientMapByProcessId(String id);

	Set<AdvisorBusinessClientMap> deleteAdvisorBusinessClientMapByProcessId(String id);

	Set<AdvisorIndividualClientMap> fetchAdvisorIndividualClientMap(UUID advisorId);

	Set<IndividualClient> fetchIndividualClientsByAdvisorId(UUID advisorId);

	Set<AdvisorBusinessClientMap> fetchAdvisorBusinessClientMap(UUID advisorId);

	Set<BusinessClient> fetchBusinessClientaByAdvisorId(UUID advisorId);

}
