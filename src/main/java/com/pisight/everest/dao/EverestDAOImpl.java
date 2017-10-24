package com.pisight.everest.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import com.pisight.everest.repository.AdditionalContactDetailsRepository;
import com.pisight.everest.repository.AddressRepository;
import com.pisight.everest.repository.AdvisorAdditionalDetailRepo;
import com.pisight.everest.repository.AdvisorBusinessClientMapRepo;
import com.pisight.everest.repository.AdvisorIndividualClientMapRepo;
import com.pisight.everest.repository.AdvisorRepository;
import com.pisight.everest.repository.AdvisorVastingRightRepo;
import com.pisight.everest.repository.AdvisoryGroupAdvisorMapRepo;
import com.pisight.everest.repository.AdvisoryGroupRepo;
import com.pisight.everest.repository.BusinessClientAddressRepository;
import com.pisight.everest.repository.BusinessClientContactRepository;
import com.pisight.everest.repository.BusinessClientEmailRepository;
import com.pisight.everest.repository.BusinessClientRepository;
import com.pisight.everest.repository.BusinessRegistrationDetailRepository;
import com.pisight.everest.repository.CarrierAddressDetailsRepository;
import com.pisight.everest.repository.CarrierContactDetailsRepository;
import com.pisight.everest.repository.CarrierRepository;
import com.pisight.everest.repository.ContactRepository;
import com.pisight.everest.repository.DepartmentRepository;
import com.pisight.everest.repository.DropDownListRepository;
import com.pisight.everest.repository.DropDownTypeRepository;
import com.pisight.everest.repository.EmployeeAddressRepo;
import com.pisight.everest.repository.EmployeeAwardsAndAchivementRepo;
import com.pisight.everest.repository.EmployeeCertificationRepo;
import com.pisight.everest.repository.EmployeeContactRepo;
import com.pisight.everest.repository.EmployeeEducationRepo;
import com.pisight.everest.repository.EmployeeExperienceDetailRepo;
import com.pisight.everest.repository.EmployeeLanguageRepo;
import com.pisight.everest.repository.EmployeeManagerRepo;
import com.pisight.everest.repository.EmployeeRepository;
import com.pisight.everest.repository.EmpolyeeEmailRepo;
import com.pisight.everest.repository.HouseHoldDetailRepository;
import com.pisight.everest.repository.HouseholdMemberRepository;
import com.pisight.everest.repository.IndividualClientAddressRepository;
import com.pisight.everest.repository.IndividualClientContactRepository;
import com.pisight.everest.repository.IndividualClientEmailRepository;
import com.pisight.everest.repository.IndividualClientIdRepo;
import com.pisight.everest.repository.IndividualClientRepository;
import com.pisight.everest.repository.LoginAuditTrailRepository;
import com.pisight.everest.repository.PolicyAdvisorCommissionShareRepo;
import com.pisight.everest.repository.PolicyAdvisorMapRepo;
import com.pisight.everest.repository.PolicyAdvisorRepo;
import com.pisight.everest.repository.PolicyPlanCommisionRateRepository;
import com.pisight.everest.repository.PolicyPlanRepository;
import com.pisight.everest.repository.PolicyPlanRiderRepository;
import com.pisight.everest.repository.PolicyPlanTermRepository;
import com.pisight.everest.repository.PolicyPremiumCommissionRepo;
import com.pisight.everest.repository.PolicyPremiumRepo;
import com.pisight.everest.repository.PolicyRepo;
import com.pisight.everest.repository.PolicyRiderPremiumRepo;
import com.pisight.everest.repository.PolicyRiderRepo;
import com.pisight.everest.repository.RiderCommissionRateRepository;
import com.pisight.everest.repository.RiderRepository;
import com.pisight.everest.repository.UserRepository;
import com.pisight.everest.repository.UserRoleRepository;
import com.pisight.everest.util.ScriptLogger;

@Repository
public class EverestDAOImpl implements EverestDAO {

	@Autowired
	AdvisorBusinessClientMapRepo advisorBusinessClientMapRepo;

	@Autowired
	AdvisorIndividualClientMapRepo advisorIndividualClientMapRepo;

	@Autowired
	AdvisorRepository advisorRepo;

	@Autowired
	AdvisorAdditionalDetailRepo advisorAdditionaldetailRepo;

	@Autowired
	AdvisorVastingRightRepo advisorVastingRightRepo;

	@Autowired
	AdditionalContactDetailsRepository addContactRepo;

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	BusinessClientAddressRepository businessClientAddRepo;

	@Autowired
	BusinessClientContactRepository businessClientContactRepo;

	@Autowired
	BusinessClientEmailRepository businessClientEmailRepo;

	@Autowired
	BusinessClientRepository businessClientRepo;

	@Autowired
	BusinessRegistrationDetailRepository businessRegRepo;

	@Autowired
	CarrierAddressDetailsRepository carrierAddRepo;

	@Autowired
	CarrierContactDetailsRepository carrierContactRepo;

	@Autowired
	CarrierRepository carrierRepo;

	@Autowired
	ContactRepository contactRepo;

	@Autowired
	DepartmentRepository deptRepo;

	@Autowired
	DropDownListRepository ddlRepo;

	@Autowired
	DropDownTypeRepository ddtRepo;

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	EmployeeAwardsAndAchivementRepo employeAwardsRepo;

	@Autowired
	EmployeeCertificationRepo employeeCertificationRepo;

	@Autowired
	EmployeeAddressRepo employeeAddressRepo;

	@Autowired
	EmployeeContactRepo employeeContactRepo;

	@Autowired
	EmpolyeeEmailRepo employeEmailRepo;

	@Autowired
	EmployeeEducationRepo employeeEducationRepo;

	@Autowired
	EmployeeExperienceDetailRepo employeeExperienceRepo;

	@Autowired
	EmployeeLanguageRepo employeeLanguageRepo;

	@Autowired
	EmployeeManagerRepo employeeManagerRepo;

	@Autowired
	AdvisoryGroupRepo advisoryGroupRepo;

	@Autowired
	AdvisoryGroupAdvisorMapRepo advisoryGroupAdvisorMap;

	@Autowired
	HouseHoldDetailRepository houseHoldRepo;

	@Autowired
	HouseholdMemberRepository houseHoldMemberRepo;

	@Autowired
	IndividualClientAddressRepository individualClientAddressRepo;

	@Autowired
	IndividualClientContactRepository individualClientContactRepo;

	@Autowired
	IndividualClientEmailRepository individualClientEmailRepo;

	@Autowired
	IndividualClientRepository individualClientRepo;

	@Autowired
	IndividualClientIdRepo individualClientIdRepo;

	@Autowired
	LoginAuditTrailRepository loginAuditRepo;

	@Autowired
	PolicyRiderRepo policyRiderRepo;

	@Autowired
	PolicyPlanRepository policyPlanRepo;

	@Autowired
	PolicyPlanRiderRepository policyPlanRiderRepo;

	@Autowired
	PolicyPlanCommisionRateRepository policyPlancommisionRateRepo;

	@Autowired
	PolicyPlanTermRepository policyPlanTermRepo;

	@Autowired
	PolicyAdvisorMapRepo policyAdvisorMapRepo;

	@Autowired
	RiderCommissionRateRepository ridercommisionRateRepo;

	@Autowired
	RiderRepository riderRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserRoleRepository userRoleRepo;

	@Autowired
	PolicyRepo policyRepo;

	@Autowired
	PolicyRiderPremiumRepo policyRiderPremiumRepo;

	@Autowired
	PolicyPremiumRepo policyPremiumRepo;

	@Autowired
	PolicyAdvisorRepo policyAdvisorRepo;

	@Autowired
	PolicyPremiumCommissionRepo policyPremiumCommissionRepo;

	@Autowired
	PolicyAdvisorCommissionShareRepo policyAdvisorCommissionShareRepo;

	@Override
	@Transactional
	public User fetchUser(UUID id) {
		return userRepo.findOne(id);
	}

	@Override
	@Transactional
	public User fetchUserByUsername(String username) {
		return userRepo.fetchUserByUserName(username);
	}

	@Override
	@Transactional
	public User fetchUserByEmail(String email) {
		return userRepo.fetchUserByEmail(email);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		userRepo.delete(user);

	}

	@Override
	@Transactional
	public UserRole fetchUserRole(UUID id) {
		return userRoleRepo.findOne(id);
	}

	@Override
	@Transactional
	public UserRole fetchUserRoleByRole(String role) {
		return userRoleRepo.fetchUserRoleByUserRole(role);
	}

	@Override
	@Transactional
	public List<UserRole> fetchUserRoles() {
		return userRoleRepo.findAll();
	}

	@Override
	@Transactional
	public UserRole saveUserRole(UserRole role) {
		return userRoleRepo.save(role);
	}

	@Override
	@Transactional
	public void removeUserRole(UserRole role) {
		userRoleRepo.delete(role);
	}

	@Override
	@Transactional
	public LoginAuditTrail saveLoginAuditTrail(LoginAuditTrail lat) {
		return loginAuditRepo.save(lat);
	}

	@Override
	@Transactional
	public Carrier fetchCarrier(UUID id) {
		return carrierRepo.findOne(id);
	}

	@Override
	@Transactional
	public Carrier fetchCarrierByName(String name) {
		return carrierRepo.fetchCarrierByName(name);
	}

	@Override
	@Transactional
	public Carrier fetchCarrierByAbbr(String abbr) {
		return carrierRepo.fetchCarrierByAbbr(abbr);
	}

	@Override
	@Transactional
	public List<Carrier> fetchCarriers() {
		return carrierRepo.findAll();
	}

	@Override
	@Transactional
	public Carrier saveCarrier(Carrier carrier) {
		return carrierRepo.save(carrier);
	}

	@Override
	@Transactional
	public void removeCarrier(Carrier carrier) {
		carrierRepo.delete(carrier);
	}

	@Override
	@Transactional
	public CarrierAddressDetails saveCarrierAddressDetails(CarrierAddressDetails address) {
		return carrierAddRepo.save(address);
	}

	@Override
	@Transactional
	public void removeCarrierAddressDetails(CarrierAddressDetails address) {
		carrierAddRepo.delete(address);
	}

	@Override
	@Transactional
	public CarrierContactDetails saveCarrierContactDetails(CarrierContactDetails contact) {
		return carrierContactRepo.save(contact);
	}

	@Override
	@Transactional
	public void removeCarrierContactDetails(CarrierContactDetails contact) {
		carrierContactRepo.delete(contact);
	}

	@Override
	@Transactional
	public BusinessClient fetchBusinessClient(UUID id) {
		return businessClientRepo.findOne(id);
	}

	@Override
	@Transactional
	public List<BusinessClient> fetchBusinessClients() {
		return businessClientRepo.findAll();
	}

	@Override
	@Transactional
	public BusinessClient saveBusinessClient(BusinessClient client) {
		return businessClientRepo.save(client);
	}

	@Override
	@Transactional
	public void removeBusinessClient(BusinessClient client) {
		businessClientRepo.delete(client);
	}

	@Override
	@Transactional
	public IndividualClient fetchIndividualClient(UUID id) {
		return individualClientRepo.findOne(id);
	}

	@Override
	@Transactional
	public List<IndividualClient> fetchIndividualClients() {
		return individualClientRepo.findAll();
	}

	@Override
	@Transactional
	public IndividualClient saveIndividualClient(IndividualClient client) {
		return individualClientRepo.save(client);
	}

	@Override
	@Transactional
	public void removeIndividualClient(IndividualClient client) {
		individualClientRepo.delete(client);
	}

	@Override
	@Transactional
	public BusinessClientAddress saveBusinessClientAddress(BusinessClientAddress address) {
		return businessClientAddRepo.save(address);
	}

	@Override
	@Transactional
	public void removeBusinessClientAddress(BusinessClientAddress address) {
		businessClientAddRepo.delete(address);
	}

	@Override
	@Transactional
	public BusinessClientContact saveBusinessClientContact(BusinessClientContact contact) {
		return businessClientContactRepo.save(contact);
	}

	@Override
	@Transactional
	public void removeBusinessClientContact(BusinessClientContact contact) {
		businessClientContactRepo.delete(contact);
	}

	@Override
	@Transactional
	public BusinessClientEmail saveBusinessClientEmail(BusinessClientEmail email) {
		return businessClientEmailRepo.save(email);
	}

	@Override
	@Transactional
	public void removeBusinessClientEmail(BusinessClientEmail email) {
		businessClientEmailRepo.delete(email);
	}

	@Override
	@Transactional
	public BusinessRegistrationDetail saveBusinessRegistrationDetail(BusinessRegistrationDetail reg) {
		return businessRegRepo.save(reg);
	}

	@Override
	@Transactional
	public void removeBusinessRegistrationDetail(BusinessRegistrationDetail reg) {
		businessRegRepo.delete(reg);
	}

	@Override
	@Transactional
	public IndividualClientAddress saveIndividualClientAddress(IndividualClientAddress address) {
		return individualClientAddressRepo.save(address);
	}

	@Override
	@Transactional
	public void removeIndividualClientAddress(IndividualClientAddress address) {
		individualClientAddressRepo.delete(address);
	}

	@Override
	@Transactional
	public IndividualClientContact saveIndividualClientContact(IndividualClientContact contact) {
		return individualClientContactRepo.save(contact);
	}

	@Override
	@Transactional
	public void removeIndividualClientContact(IndividualClientContact contact) {
		individualClientContactRepo.delete(contact);
	}

	@Override
	@Transactional
	public IndividualClientEmail saveIndividualClientEmail(IndividualClientEmail email) {
		return individualClientEmailRepo.save(email);
	}

	@Override
	@Transactional
	public void removeIndividualClientEmail(IndividualClientEmail email) {
		individualClientEmailRepo.delete(email);
	}

	@Override
	@Transactional
	public PolicyPlan fetchPolicyPlan(UUID id) {
		return policyPlanRepo.findOne(id);
	}

	@Override
	public PolicyPlan fetchPolicyPlanByCarrierId(UUID carrierId) {
		return policyPlanRepo.findOne(carrierId);
	}

	@Override
	public PolicyPlan fetchpoicyPlanByName(String name) {
		return policyPlanRepo.fetchPolicyPlansByName(name);
	}

	@Override
	@Transactional
	public List<PolicyPlan> fetchPolicyPlans() {
		return policyPlanRepo.findAll();
	}

	@Override
	public List<PolicyPlan> fetchPolicyPlansByCarrierID(UUID carrierId) {
		return policyPlanRepo.fetchPolicyPlansByCarrierId(carrierId);
	}

	@Override
	@Transactional
	public PolicyPlan savePolicyPlan(PolicyPlan plan) {
		return policyPlanRepo.save(plan);
	}

	@Override
	@Transactional
	public void removePolicyPlan(PolicyPlan plan) {
		policyPlanRepo.delete(plan);
	}

	@Override
	@Transactional
	public PolicyPlanTerm savePolicyPlanTerm(PolicyPlanTerm term) {
		return policyPlanTermRepo.save(term);
	}

	@Override
	@Transactional
	public PolicyPlanTerm fetchPolicyPlanTermById(UUID id) {
		return policyPlanTermRepo.findOne(id);
	}

	@Override
	@Transactional
	public void removePolicyPlanTerm(PolicyPlanTerm term) {
		policyPlanTermRepo.delete(term);
	}

	@Override
	@Transactional
	public PolicyPlanRider savePolicyPlanRider(PolicyPlanRider planRider) {
		return policyPlanRiderRepo.save(planRider);
	}

	@Override
	@Transactional
	public PolicyPlanRider fetchPolicyPlanRider(UUID id) {
		return policyPlanRiderRepo.findOne(id);
	}

	@Override
	@Transactional
	public void removePolicyPlanRider(PolicyPlanRider planRider) {
		policyPlanRiderRepo.delete(planRider);

	}

	@Override
	@Transactional
	public PolicyPlanCommissionRate savePolicyPlanCommissionRate(PolicyPlanCommissionRate rate) {
		return policyPlancommisionRateRepo.save(rate);
	}

	@Override
	@Transactional
	public void removePolicyPlanCommissionRate(PolicyPlanCommissionRate rate) {
		policyPlancommisionRateRepo.delete(rate);
	}

	@Override
	public PolicyAdvisorMap savePolicyAdvisorMap(PolicyAdvisorMap policyAdvisorMap) {
		return policyAdvisorMapRepo.save(policyAdvisorMap);

	}

	@Override
	@Transactional
	public Rider fetchRider(UUID id) {
		return riderRepo.findOne(id);
	}

	@Override
	@Transactional
	public List<Rider> fetchRiders() {
		return riderRepo.findAll();
	}

	@Override
	@Transactional
	public Rider saveRider(Rider rider) {
		return riderRepo.save(rider);
	}

	@Override
	@Transactional
	public void removeRider(Rider rider) {
		riderRepo.delete(rider);
	}

	@Override
	@Transactional
	public RiderCommissionRate saveRiderCommissionRate(RiderCommissionRate riderRate) {
		return ridercommisionRateRepo.save(riderRate);
	}

	@Override
	@Transactional
	public List<RiderCommissionRate> fetchRiderCommisionRates(UUID planRider) {
		return ridercommisionRateRepo.fetchCommisionRates(planRider);
	}

	@Override
	@Transactional
	public void removeRiderCommissionRate(RiderCommissionRate riderRate) {
		ridercommisionRateRepo.delete(riderRate);
	}

	@Override
	@Transactional
	public AddressEntity fetchAddressEntity(UUID id) {
		return addressRepo.findOne(id);
	}

	@Override
	@Transactional
	public List<AddressEntity> fetchAddressEntities() {
		return addressRepo.findAll();
	}

	@Override
	@Transactional
	public AddressEntity saveAddressEntity(AddressEntity address) {
		return addressRepo.save(address);
	}

	@Override
	@Transactional
	public void removeAddressEntity(AddressEntity address) {
		addressRepo.delete(address);
	}

	@Override
	@Transactional
	public ContactEntity fetchContactEntity(UUID id) {
		return contactRepo.findOne(id);
	}

	@Override
	@Transactional
	public List<ContactEntity> fetchContactEntities() {
		return contactRepo.findAll();
	}

	@Override
	@Transactional
	public ContactEntity saveContactEntity(ContactEntity contact) {
		return contactRepo.save(contact);
	}

	@Override
	@Transactional
	public void removeContactEntity(ContactEntity contact) {
		contactRepo.delete(contact);
	}

	@Override
	@Transactional
	public AdditionalContactDetails saveAdditionalContactDetails(AdditionalContactDetails contact) {
		return addContactRepo.save(contact);
	}

	@Override
	@Transactional
	public void removeAdditionalContactDetails(AdditionalContactDetails contact) {
		addContactRepo.delete(contact);
	}

	@Override
	@Transactional
	public Department fetchDepartment(UUID id) {
		return deptRepo.findOne(id);
	}

	@Override
	@Transactional
	public Department fetchDepartmentByName(String name) {
		return deptRepo.fetchDeptByName(name);
	}

	@Override
	@Transactional
	public Department fetchDepartmentByDeptId(String deptId) {
		return deptRepo.fetchDeptByDeptId(deptId);
	}

	@Override
	@Transactional
	public Department saveDepartment(Department dept) {
		return deptRepo.save(dept);
	}

	@Override
	@Transactional
	public void removeDepartment(Department dept) {
		deptRepo.delete(dept);
	}

	@Override
	@Transactional
	public DropDownList fetchDropDownList(UUID id) {
		return ddlRepo.findOne(id);
	}

	@Override
	@Transactional
	public DropDownList fetchDropDownList(String type, String value) {
		return ddlRepo.fetchDropDownList(type, value);
	}

	@Override
	@Transactional
	public DropDownList saveDropDownList(DropDownList ddl) {
		ScriptLogger.writeInfo("saving ddl");
		return ddlRepo.save(ddl);
	}

	@Override
	@Transactional
	public void removeDropDownList(DropDownList ddl) {
		ddlRepo.delete(ddl);
	}

	@Override
	@Transactional
	public DropDownType fetchDropDownType(UUID id) {
		return ddtRepo.findOne(id);
	}

	@Override
	@Transactional
	public DropDownType fetchDropDownTypeByName(String type) {
		return ddtRepo.fetchDropDownTypeByName(type);
	}

	@Override
	@Transactional
	public DropDownType saveDropDownType(DropDownType ddt) {
		return ddtRepo.save(ddt);
	}

	@Override
	@Transactional
	public void removeDropDownType(DropDownType ddt) {
		ddtRepo.delete(ddt);
	}

	@Override
	@Transactional
	public Employee fetchEmployee(UUID id) {
		return empRepo.findOne(id);
	}

	@Override
	@Transactional
	public Employee fetchEmployeeByUserId(UUID id) {
		return empRepo.fetchEmployeeByUserId(id);
	}

	@Override
	@Transactional
	public Employee fetchEmployeeByEmpId(String empId) {
		return empRepo.fetchEmployeeByEmpId(empId);
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	@Transactional
	public void removeEmployee(Employee emp) {
		empRepo.delete(emp);
	}

	@Override
	@Transactional
	public IndividualClientIdentity saveIndividualClientIdentity(IndividualClientIdentity clientIdentity) {
		return individualClientIdRepo.save(clientIdentity);
	}

	@Override
	@Transactional
	public HouseHoldDetail saveHouseHoldDetail(HouseHoldDetail houseHoldDetail) {
		return houseHoldRepo.save(houseHoldDetail);
	}

	@Override
	@Transactional
	public Advisor saveAdvisor(Advisor advisor) {
		return advisorRepo.save(advisor);
	}

	@Override
	@Transactional
	public Advisor fetchAdvisor(UUID id) {
		return advisorRepo.findOne(id);
	}

	@Override
	@Transactional
	public HouseholdMember saveHouseHoldMembers(HouseholdMember householdMember) {
		return houseHoldMemberRepo.save(householdMember);
	}

	@Override
	@Transactional
	public AdvisorAdditionalDetails saveAdvisorAdditionalDetails(AdvisorAdditionalDetails additionalDetails) {
		return advisorAdditionaldetailRepo.save(additionalDetails);
	}

	@Override
	@Transactional
	public AdvisorVestingRights saveAdvisorVastingRight(AdvisorVestingRights advisorVestingRights) {
		return advisorVastingRightRepo.save(advisorVestingRights);
	}

	@Override
	@Transactional
	public List<Employee> fetchEmployees() {
		return empRepo.findAll();
	}

	@Override
	@Transactional
	public EmployeeAddresses saveEmployeeAddress(EmployeeAddresses addresses) {
		return employeeAddressRepo.save(addresses);
	}

	@Override
	@Transactional
	public EmployeeAwardsAndAchievements saveEmployeeAwardsAndAchievements(EmployeeAwardsAndAchievements achievements) {
		return employeAwardsRepo.save(achievements);
	}

	@Override
	@Transactional
	public EmployeeCertificationDetails saveEmployeeCertification(EmployeeCertificationDetails certificationDetails) {
		return employeeCertificationRepo.save(certificationDetails);
	}

	@Override
	@Transactional
	public EmployeeContactNumbers saveEmployeeContact(EmployeeContactNumbers contactNumbers) {
		return employeeContactRepo.save(contactNumbers);
	}

	@Override
	@Transactional
	public EmployeeEducationDetails saveEmployeeEducationDetails(EmployeeEducationDetails education) {
		return employeeEducationRepo.save(education);
	}

	@Override
	@Transactional
	public EmployeeEmails saveEmployeeEmails(EmployeeEmails emails) {
		return employeEmailRepo.save(emails);
	}

	@Override
	@Transactional
	public EmployeeManager saveEmployeeManager(EmployeeManager managers) {
		return employeeManagerRepo.save(managers);
	}

	@Override
	@Transactional
	public EmployeeLanguage saveEmployeeLanguage(EmployeeLanguage language) {
		return employeeLanguageRepo.save(language);
	}

	@Override
	@Transactional
	public EmployeeExperienceDetails saveEmployeeExperienceDetails(EmployeeExperienceDetails experienceDetails) {
		return employeeExperienceRepo.save(experienceDetails);
	}

	@Override
	@Transactional
	public AdvisoryGroup saveEmployeeAdvisoryGroup(AdvisoryGroup advisoryGroup) {
		return advisoryGroupRepo.save(advisoryGroup);
	}

	@Override
	@Transactional
	public AdvisoryGroup saveAdvisoryGroup(AdvisoryGroup advisoryGroup) {
		return null;
	}

	@Override
	@Transactional
	public AdvisoryGroup fetchAdvisoryGroup(UUID id) {
		return advisoryGroupRepo.findOne(id);
	}

	@Override
	@Transactional
	public AdvisorIndividualClientMap saveIndividualClientMap(AdvisorIndividualClientMap advisorIndividualClientMap) {
		return advisorIndividualClientMapRepo.save(advisorIndividualClientMap);
	}

	@Override
	@Transactional
	public Advisor fetchAdvisorByEmployeeID(String id) {
		return advisorRepo.fetchAdvisorByEmployeeID(id);
	}

	@Override
	@Transactional
	public Set<AdvisorIndividualClientMap> fetchAdvisorIndividualClientMap(UUID advisorId) {
		return advisorIndividualClientMapRepo.fetchAdvisorIndividualClientMap(advisorId);
	}

	@Override
	@Transactional
	public Set<IndividualClient> fetchIndividualClientsByAdvisorId(UUID advisorId) {
		Set<IndividualClient> clients = new HashSet<>();
		Set<AdvisorIndividualClientMap> aicm = fetchAdvisorIndividualClientMap(advisorId);
		for (AdvisorIndividualClientMap map : aicm) {
			clients.add(map.getIndividualClient());
		}
		return clients;
	}

	@Override
	@Transactional
	public Set<BusinessClient> fetchBusinessClientaByAdvisorId(UUID advisorId) {

		Set<BusinessClient> clients = new HashSet<>();
		Set<AdvisorBusinessClientMap> aicm = fetchAdvisorBusinessClientMap(advisorId);
		for (AdvisorBusinessClientMap map : aicm) {
			clients.add(map.getBusinessClient());
		}
		return clients;
	}

	@Override
	@Transactional
	public Set<AdvisorBusinessClientMap> fetchAdvisorBusinessClientMap(UUID advisorId) {
		return advisorBusinessClientMapRepo.fetchAdvisorBusinessClientMap(advisorId);
	}

	@Override
	@Transactional
	public AdvisorBusinessClientMap saveAdvisorBusinessClientMap(AdvisorBusinessClientMap advisorBusinessClientMap) {
		return advisorBusinessClientMapRepo.save(advisorBusinessClientMap);
	}

	@Override
	@Transactional
	public Policy fetchPolicy(UUID id) {
		return policyRepo.findOne(id);
	}

	@Override
	@Transactional
	public void removePolicy(Policy policy) {
		policyRepo.delete(policy);
	}

	@Override
	@Transactional
	public Policy savePolicy(Policy policy) {
		return policyRepo.save(policy);
	}

	@Override
	@Transactional
	public List<Policy> fetchPolicies() {
		return policyRepo.findAll();
	}

	@Override
	@Transactional
	public Policy fetchPolicyByPolicyPlan(PolicyPlan plan) {
		return policyRepo.findByPolicyPlan(plan);
	}

	@Override
	@Transactional
	public PolicyRiderPremium savePolicyRiderPremium(PolicyRiderPremium policyRiderPremium) {
		return policyRiderPremiumRepo.save(policyRiderPremium);
	}

	@Override
	public PolicyRider savePolicyRider(PolicyRider policyRider) {
		return policyRiderRepo.save(policyRider);
	}

	@Override
	@Transactional
	public void removePolicyRiderPremium(PolicyRiderPremium policyRiderPremium) {
		policyRiderPremiumRepo.delete(policyRiderPremium);
	}

	@Override
	@Transactional
	public PolicyPremium savePolicyPremium(PolicyPremium policyPremium) {
		return policyPremiumRepo.save(policyPremium);
	}

	@Override
	@Transactional
	public PolicyPremium fetchPolicyPremiumByPolicy(Policy policy) {
		return policyPremiumRepo.findByPolicyId(policy);
	}

	@Override
	@Transactional
	public void removePolicyPremium(PolicyPremium policyPremium) {
		policyPremiumRepo.delete(policyPremium);
	}

	@Override
	@Transactional
	public PolicyAdvisorMap savePolicyAdvisor(PolicyAdvisorMap policyAdvisorMap) {
		return policyAdvisorRepo.save(policyAdvisorMap);
	}

	@Override
	@Transactional
	public void removePolicyAdvisor(PolicyAdvisorMap policyAdvisorMap) {
		policyAdvisorRepo.delete(policyAdvisorMap);
	}

	@Override
	@Transactional
	public List<PolicyAdvisorMap> fetchPolicyAdvisors() {
		return policyAdvisorRepo.findAll();
	}

	@Override
	@Transactional
	public PolicyPremiumCommission savePolicyPremiumCommission(PolicyPremiumCommission policyPremiumCommission) {
		return policyPremiumCommissionRepo.save(policyPremiumCommission);
	}

	@Override
	@Transactional
	public void removePolicyPremiumCommission(PolicyPremiumCommission policyPremiumCommission) {
		policyPremiumCommissionRepo.delete(policyPremiumCommission);
	}

	@Override
	@Transactional
	public PolicyAdvisorCommissionShare savePolicyAdvisorCommissionShare(
			PolicyAdvisorCommissionShare policyAdvisorCommissionShare) {
		return policyAdvisorCommissionShareRepo.save(policyAdvisorCommissionShare);
	}

	@Override
	@Transactional
	public PolicyAdvisorCommissionShare findPolicyAdvisorCommissionShareByAdvisor(Advisor advisor) {
		return policyAdvisorCommissionShareRepo.findPolicyAdvisorCommissionShareByAdvisorId(advisor);
	}

	@Override
	@Transactional
	public void removePolicyAdvisorCommissionShare(PolicyAdvisorCommissionShare policyAdvisorCommissionShare) {
		policyAdvisorCommissionShareRepo.delete(policyAdvisorCommissionShare);
	}

	@Override
	@Transactional
	public User fetchUserByProcessId(String id) {
		return userRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteUserByProcessId(String id) {
		userRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public Carrier fetchCarrierByProcessId(String id) {
		return carrierRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<Carrier> deleteCarrierByProcessId(String id) {
		return carrierRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public BusinessClient fetchBusinessClientByProcessId(String id) {
		return businessClientRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<BusinessClient> deleteBusinessClientByProcessId(String id) {
		return businessClientRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public IndividualClient fetchIndividualClientByProcessId(String id) {
		return individualClientRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<IndividualClient> deleteIndividualClientByProcessId(String id) {
		return individualClientRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public Policy fetchPolicyByProcessId(String id) {
		return policyRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<Policy> deletePolicyByProcessId(String id) {
		return policyRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyRider fetchPolicyRiderByProcessId(String id) {
		return policyRiderRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<PolicyRider> deletePolicyRiderByProcessId(String id) {
		return policyRiderRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyPremium fetchPolicyPremiumByProcessId(String id) {
		return policyPremiumRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<PolicyPremium> deletePolicyPremiumByProcessId(String id) {
		return policyPremiumRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyAdvisorMap fetchPolicyAdvisorMapByProcessId(String id) {
		return policyAdvisorMapRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<PolicyAdvisorMap> deletePolicyAdvisorMapPremiumByProcessId(String id) {
		return policyAdvisorMapRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyPremiumCommission fetchPolicyPremiumCommissionByProcessId(String id) {
		return policyPremiumCommissionRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deletePolicyPremiumCommissionByProcessId(String id) {
		policyPremiumCommissionRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyAdvisorCommissionShare fetchPolicyAdvisorCommissionShareByProcessId(String id) {
		return policyAdvisorCommissionShareRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deletePolicyAdvisorCommissionShareByProcessId(String id) {
		policyAdvisorCommissionShareRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyPlan fetchPolicyPlanByProcessId(String id) {
		return policyPlanRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<PolicyPlan> deletePolicyPlanByProcessId(String id) {
		return policyPlanRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyPlanCommissionRate fetchPolicyPlanCommissionRateByProcessId(String id) {
		return policyPlancommisionRateRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deletePolicyPlanCommissionRateByProcessId(String id) {
		policyPlancommisionRateRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public Rider fetchRiderByProcessId(String id) {
		return riderRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteRiderByProcessId(String id) {
		riderRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AddressEntity fetchAddressEntityByProcessId(String id) {
		return addressRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteAddressEntityByProcessId(String id) {
		addressRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public ContactEntity fetchContactEntityByProcessId(String id) {
		return contactRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteContactEntityByProcessId(String id) {
		contactRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AdditionalContactDetails fetchAdditionalContactDetailsByProcessId(String id) {
		return null;
	}

	@Override
	@Transactional
	public void deleteAdditionalContactDetailsByProcessId(String id) {
	}

	@Override
	@Transactional
	public Department fetchDepartmentByProcessId(String id) {
		return deptRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteDepartmentByProcessId(String id) {
		deptRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public DropDownList fetchDropDownListByProcessId(String id) {
		return ddlRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteDropDownListByProcessId(String id) {
		ddlRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public DropDownType fetchDropDownTypeByProcessId(String id) {
		return ddtRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteDropDownTypeByProcessId(String id) {
		ddtRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public Employee fetchEmployeeByProcessId(String id) {
		return empRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<Employee> deleteEmployeeByProcessId(String id) {
		return empRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeAddresses fetchEmployeeAddressesByProcessId(String id) {
		return employeeAddressRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeAddresses> deleteEmployeeAddressesByProcessId(String id) {
		return employeeAddressRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeAwardsAndAchievements fetchEmployeeAwardsAndAchievementsByProcessId(String id) {
		return employeAwardsRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeAwardsAndAchievements> deleteEmployeeAwardsAndAchievementsByProcessId(String id) {
		return employeAwardsRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeCertificationDetails fetchEmployeeCertificationDetailsByProcessId(String id) {
		return employeeCertificationRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeCertificationDetails> deleteEmployeeCertificationDetailsByProcessId(String id) {
		return employeeCertificationRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeContactNumbers fetchEmployeeContactNumbersByProcessId(String id) {
		return employeeContactRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeContactNumbers> deleteEmployeeContactNumbersByProcessId(String id) {
		return employeeContactRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeEducationDetails fetchEmployeeEducationDetailsByProcessId(String id) {
		return employeeEducationRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeEducationDetails> deleteEmployeeEducationDetailsByProcessId(String id) {
		return employeeEducationRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeEmails fetchEmployeeEmailsByProcessId(String id) {
		return employeEmailRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeEmails> deleteEmployeeEmailsByProcessId(String id) {
		return employeEmailRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeExperienceDetails fetchEmployeeExperienceDetailsByProcessId(String id) {
		return employeeExperienceRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeExperienceDetails> deleteEmployeeExperienceDetailsByProcessId(String id) {
		return employeeExperienceRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AdvisoryGroup fetchAdvisoryGroupByProcessId(String id) {
		return advisoryGroupRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<AdvisoryGroup> deleteAdvisoryGroupByProcessId(String id) {
		return advisoryGroupRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeManager fetchEmployeeManagerByProcessId(String id) {
		return employeeManagerRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteEmployeeManagerByProcessId(String id) {
		employeeManagerRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public EmployeeLanguage fetchEmployeeLanguageByProcessId(String id) {
		return employeeLanguageRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<EmployeeLanguage> deleteEmployeeLanguageByProcessId(String id) {
		return employeeLanguageRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public Advisor fetchAdvisorByProcessId(String id) {
		return advisorRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<Advisor> deleteAdvisorByProcessId(String id) {
		return advisorRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AdvisorAdditionalDetails fetchAdvisorAdditionalDetailsByProcessId(String id) {
		return advisorAdditionaldetailRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteAdvisorAdditionalDetailsByProcessId(String id) {
		advisorAdditionaldetailRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AdvisorVestingRights fetchAdvisorVestingRightsByProcessId(String id) {
		return advisorVastingRightRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<AdvisorVestingRights> deleteAdvisorVestingRightsByProcessId(String id) {
		return advisorVastingRightRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public HouseholdMember fetchHouseholdMemberByProcessId(String id) {
		return houseHoldMemberRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<HouseholdMember> deleteHouseholdMemberByProcessId(String id) {
		return houseHoldMemberRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AdvisorIndividualClientMap fetchAdvisorIndividualClientMapByProcessId(String id) {
		return advisorIndividualClientMapRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public Set<AdvisorIndividualClientMap> deleteAdvisorIndividualClientMapByProcessId(String id) {
		return advisorIndividualClientMapRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public AdvisorBusinessClientMap fetchAdvisorBusinessClientMapByProcessId(String id) {
		return advisorBusinessClientMapRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public Set<AdvisorBusinessClientMap> deleteAdvisorBusinessClientMapByProcessId(String id) {
		return advisorBusinessClientMapRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyRider fetchPolicyRider(UUID id) {
		return policyRiderRepo.findOne(id);
	}

	@Override
	@Transactional
	public PolicyPremium fetchPolicyPremium(UUID id) {
		return policyPremiumRepo.findOne(id);
	}

	@Override
	@Transactional
	public PolicyAdvisorMap fetchPolicyAdvisorMap(UUID id) {
		return policyAdvisorMapRepo.findOne(id);
	}

	@Override
	@Transactional
	public PolicyPremiumCommission fetchPolicyPremiumCommission(UUID id) {
		return policyPremiumCommissionRepo.findOne(id);
	}

	@Override
	@Transactional
	public PolicyAdvisorCommissionShare fetchPolicyAdvisorCommissionShare(UUID id) {
		return policyAdvisorCommissionShareRepo.findOne(id);
	}

	@Override
	@Transactional
	public AdvisoryGroupAdvisorMap saveAdvisoryGroupAdvisorMap(AdvisoryGroupAdvisorMap advisoryGroup) {
		return advisoryGroupAdvisorMap.save(advisoryGroup);
	}

	@Override
	@Transactional
	public AdvisoryGroupAdvisorMap fetchAdvisoryGroupAdvisorMap(UUID id) {
		return advisoryGroupAdvisorMap.findOne(id);
	}

	@Override
	@Transactional
	public AdvisoryGroupAdvisorMap fetchAdvisoryGroupAdvisorMapByProcessId(String id) {
		return advisoryGroupAdvisorMap.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<AdvisoryGroup> fetchAdvisorGroups() {
		return advisoryGroupRepo.findAll();
	}

	@Override
	@Transactional
	public List<AdvisoryGroupAdvisorMap> deleteAdvisoryGroupAdvisorMapByProcessId(String id) {
		return advisoryGroupAdvisorMap.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public CarrierAddressDetails fetchCarrierAddressDetailsByProcessId(String id) {
		return carrierAddRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<CarrierAddressDetails> deleteCarrierAddressDetailsByProcessId(String id) {
		return carrierAddRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public CarrierContactDetails fetchCarrierContactDetailsByProcessId(String id) {
		return carrierContactRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<CarrierContactDetails> deleteCarrierContactDetailsByProcessId(String id) {
		return carrierContactRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public BusinessClientAddress fetchBusinessClientAddressDetailsByProcessId(String id) {
		return businessClientAddRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<BusinessClientAddress> deleteBusinessClientAddressByProcessId(String id) {
		return businessClientAddRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public BusinessClientContact fetchBusinessClientContactDetailsByProcessId(String id) {
		return businessClientContactRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<BusinessClientContact> deleteBusinessClientContactByProcessId(String id) {
		return businessClientContactRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public BusinessClientEmail fetchBusinessClientEmailByProcessId(String id) {
		return businessClientEmailRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public List<BusinessClientEmail> deleteBusinessClientEmailByProcessId(String id) {
		return businessClientEmailRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public BusinessRegistrationDetail fetchBusinessRegistrationDetailByProcessId(String id) {
		return businessRegRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteBusinessRegistrationDetailByProcessId(String id) {
		businessRegRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public IndividualClientAddress fetchIndividualClientAddressByProcessId(String id) {
		return individualClientAddressRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteIndividualClientAddressByProcessId(String id) {
		individualClientAddressRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public IndividualClientIdentity fetchIndividualClientIdentityByProcessId(String id) {
		return individualClientIdRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteIndividualClientIdentityByProcessId(String id) {
		individualClientIdRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public IndividualClientContact fetchIndividualClientContactByProcessId(String id) {
		return individualClientContactRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteIndividualClientContactByProcessId(String id) {
		individualClientContactRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public IndividualClientEmail fetchIndividualClientEmailByProcessId(String id) {
		return individualClientEmailRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteIndividualClientEmailByProcessId(String id) {
		individualClientEmailRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyPlanTerm fetchPolicyPlanTermByProcessId(String id) {
		return policyPlanTermRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deletePolicyPlanTermByProcessId(String id) {
		policyPlanTermRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public PolicyPlanRider fetchPolicyPlanRiderByProcessId(String id) {
		return policyPlanRiderRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deletePolicyPlanRiderByProcessId(String id) {
		policyPlanRiderRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public RiderCommissionRate fetchRiderCommissionRateByProcessId(String id) {
		return ridercommisionRateRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteRiderCommissionRateByProcessId(String id) {
		ridercommisionRateRepo.deleteByProcessId(id);
	}

	@Override
	@Transactional
	public HouseHoldDetail fetchHouseHoldDetailByProcessId(String id) {
		return houseHoldRepo.findByProcessId(id);
	}

	@Override
	@Transactional
	public void deleteHouseHoldDetailByProcessId(String id) {
		houseHoldRepo.deleteByProcessId(id);
	}

	@Override
	public void updateDropDownlist(DropDownList ddl) {
	}

}
