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
import com.pisight.everest.dto.BusinessClientAddressDTO;
import com.pisight.everest.dto.BusinessClientContactDTO;
import com.pisight.everest.dto.BusinessClientDTO;
import com.pisight.everest.dto.BusinessClientEmailDTO;
import com.pisight.everest.dto.BusinessRegistrationDetailsDTO;
import com.pisight.everest.dto.ClientMapRequest;
import com.pisight.everest.dto.ClientRequest;
import com.pisight.everest.dto.IndividualClientAddressesDTO;
import com.pisight.everest.dto.IndividualClientEmailDTO;
import com.pisight.everest.dto.IndividualClientHouseHoldDetailDTO;
import com.pisight.everest.dto.IndividualClientHouseHoldMemberDTO;
import com.pisight.everest.dto.IndividualClientIdentityDetailDTO;
import com.pisight.everest.dto.IndividualClientPhoneNumbersDTO;
import com.pisight.everest.dto.InividualClientDTO;
import com.pisight.everest.entities.AddressEntity;
import com.pisight.everest.entities.Advisor;
import com.pisight.everest.entities.AdvisorBusinessClientMap;
import com.pisight.everest.entities.AdvisorIndividualClientMap;
import com.pisight.everest.entities.BusinessClient;
import com.pisight.everest.entities.BusinessClientAddress;
import com.pisight.everest.entities.BusinessClientContact;
import com.pisight.everest.entities.BusinessClientEmail;
import com.pisight.everest.entities.BusinessRegistrationDetail;
import com.pisight.everest.entities.ContactEntity;
import com.pisight.everest.entities.HouseHoldDetail;
import com.pisight.everest.entities.HouseholdMember;
import com.pisight.everest.entities.IndividualClient;
import com.pisight.everest.entities.IndividualClientAddress;
import com.pisight.everest.entities.IndividualClientContact;
import com.pisight.everest.entities.IndividualClientEmail;
import com.pisight.everest.entities.IndividualClientIdentity;
import com.pisight.everest.exception.EverestException;
import com.pisight.everest.util.ClientResponse;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@Service
public class ClientServiceImpl extends BaseService {

	private static HashMap<String, Integer> processLevelMap = new HashMap<String, Integer>();

	/*---------------------------------------Clients-------------------------------------------------*/
	public ClientResponse getClients(ClientRequest request) {
		long start = System.currentTimeMillis();
		ClientResponse response = new ClientResponse();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;

		IndividualClient individualClient = null;

		BusinessClient businessClient = null;

		List<BusinessClient> businessClients = new ArrayList<>();

		List<IndividualClient> individualClients = new ArrayList<>();

		try {
			switch (request.getType()) {

			case "INDIVIDUAL":
				if (StringUtils.isNotEmpty(request.getAdvisorId())) {
					individualClient = everestDAO.fetchIndividualClient(UUID.fromString(request.getAdvisorId()));
					individualClients.add(individualClient);
					response.setIndividualClients(individualClients);
					response.setMessage(Constants.SUCCESS);
				} else {
					response.setMessage(Constants.ADVISOR_ID_NOT_NULL);
				}
				break;

			case "BUSINESS":
				if (StringUtils.isNotEmpty(request.getAdvisorId())) {
					businessClient = everestDAO.fetchBusinessClient(UUID.fromString(request.getAdvisorId()));
					businessClients.add(businessClient);
					response.setBusinessClients(businessClients);
					response.setMessage(Constants.SUCCESS);
				} else {
					response.setMessage(Constants.ADVISOR_ID_NOT_NULL);
				}
				break;

			case "ALL":
				businessClients = everestDAO.fetchBusinessClients();
				individualClients = everestDAO.fetchIndividualClients();
				response.setIndividualClients(individualClients);
				response.setBusinessClients(businessClients);
				break;

			default:

				ScriptLogger.writeInfo("Inalid request type");
				errorCode = 100;
				responseStatus = Constants.FAILED;

				break;
			}

			errorCode = 0;
			responseStatus = Constants.SUCCESS;

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in fetching individual clients", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;
		}

		response.setStatus(responseStatus);
		response.setErrorCode(errorCode);
		response.setMessage(responseStatus);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getClients>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	public JSONObject setAdvisorClientMap(ClientMapRequest request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";
		String processId = null;

		try {

			processId = generateRandomPassword();
			request.setProcessId(processId);
			advisorClientMapping(request);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in mapping advisor and client", e);
			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in mapping advisor and client";
			}

		}
		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>setAdvisorClientMap>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		return response;
	}

	private void advisorClientMapping(ClientMapRequest request) throws EverestException {

		Advisor advisor = everestDAO.fetchAdvisor(UUID.fromString(request.getAdvisorID()));

		if (advisor == null) {
			ScriptLogger.writeInfo("advisor not found");
			throw new EverestException("advisor not found");
		}

		switch (request.getType()) {
		case "INDIVIDUAL":

			AdvisorIndividualClientMap advisorIndividualClientMap = new AdvisorIndividualClientMap();
			IndividualClient individualClient = everestDAO.fetchIndividualClient(request.getClientId());
			advisorIndividualClientMap.setAdvisor(advisor);
			advisorIndividualClientMap.setIndividualClient(individualClient);
			advisorIndividualClientMap.setProcessId(request.getProcessId());
			advisorIndividualClientMap.setEntityStatus(EntityStatus.Processing);
			everestDAO.saveIndividualClientMap(advisorIndividualClientMap);

			break;

		case "BUSINESS":

			AdvisorBusinessClientMap advisorBusinessClientMap = new AdvisorBusinessClientMap();
			BusinessClient businessClient = everestDAO.fetchBusinessClient(request.getClientId());
			advisorBusinessClientMap.setAdvisor(advisor);
			advisorBusinessClientMap.setBusinessClient(businessClient);
			advisorBusinessClientMap.setProcessId(request.getProcessId());
			advisorBusinessClientMap.setEntityStatus(EntityStatus.Processing);
			everestDAO.saveAdvisorBusinessClientMap(advisorBusinessClientMap);
			break;

		default:
			throw new EverestException("Invalid Type");
		}

	}

	public JSONObject addIndividualClient(InividualClientDTO request) {
		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		String processId = null;

		IndividualClient client = null;

		HouseHoldDetail houseHoldDetail = null;

		IndividualClientHouseHoldDetailDTO houseHoldDetailDTO = null;

		List<IndividualClientIdentityDetailDTO> idDetailList = null;

		List<IndividualClientAddressesDTO> addressList = null;

		List<IndividualClientEmailDTO> emailList = null;

		List<IndividualClientPhoneNumbersDTO> phoneNoList = null;

		List<IndividualClientHouseHoldMemberDTO> houseHoldMemberList = null;

		try {

			if (request == null) {
				ScriptLogger.writeInfo("Error in Adding Individual Client");
				throw new EverestException("Request is null");
			}

			processId = generateRandomPassword();

			idDetailList = request.getIdentityList();
			addressList = request.getAddresses();
			emailList = request.getEmails();
			phoneNoList = request.getPhoneContacts();
			houseHoldDetailDTO = request.getHouseHoldDetail();
			houseHoldMemberList = houseHoldDetailDTO.getMemberList();

			client = new IndividualClient();

			client.setName(request.getClientName());
			client.setDob(request.getDob());
			client.setNationality(fetchDropdown(request.getClientType()));
			client.setEthnicity(fetchDropdown(request.getEthnicity()));
			client.setMartialStatus(fetchDropdown(request.getMartialStatus()));
			client.setCompany(request.getCompany());
			client.setOccupation(fetchDropdown(request.getOccupation()));
			client.setJobTitle(fetchDropdown(request.getJobTitle()));
			client.setAccreditedInvestor(fetchDropdown(request.getAccreditedInvestor()));
			client.setConsent(fetchDropdown(request.getConsent()));
			client.setCall(fetchDropdown(request.getPhCall()));
			client.setSms(fetchDropdown(request.getSms()));
			client.setFax(fetchDropdown(request.getFax()));
			client.setWithdrawConsentDate(request.getWithdrawConsentDate());
			client.setNoConsent(fetchDropdown(request.getNoConsent()));
			client.setDoNotCallClient(fetchDropdown(request.getDoNotCallClient()));
			client.setDoNotFaxClient(fetchDropdown(request.getDoNotFaxClient()));
			client.setDoNotSMSClient(fetchDropdown(request.getDoNotSMSClient()));
			client.setProcessId(processId);
			client.setEntityStatus(EntityStatus.Processing);

			client = everestDAO.saveIndividualClient(client);
			processLevelMap.put(processId, 1);

			if (StringUtils.isNotEmpty(request.getAdvisorId())) {
				ClientMapRequest clientMapRequest = new ClientMapRequest();
				clientMapRequest.setAdvisorID(request.getAdvisorId());
				clientMapRequest.setClientId(client.getId());
				clientMapRequest.setType("INDIVIDUAL");

				advisorClientMapping(clientMapRequest);
			}
			processLevelMap.put(processId, 2);

			IndividualClientContact clientContact = null;
			ContactEntity contactEntity = null;

			for (IndividualClientPhoneNumbersDTO phoneNumbersDTO : phoneNoList) {
				clientContact = new IndividualClientContact();
				contactEntity = new ContactEntity();
				contactEntity.setNumber(phoneNumbersDTO.getNumber());
				contactEntity.setAreaCode(phoneNumbersDTO.getAreaCode());
				contactEntity.setCountryCode(phoneNumbersDTO.getCountryCode());
				contactEntity.setType(fetchDropdown(phoneNumbersDTO.getType()));
				contactEntity.setProcessId(processId);
				contactEntity.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveContactEntity(contactEntity);

				clientContact.setContactEntity(contactEntity);
				clientContact.setClient(client);
				clientContact.setType(fetchDropdown(phoneNumbersDTO.getType()));
				clientContact.setPrimaryContact(phoneNumbersDTO.isPrimaryContact());
				clientContact.setStatus(phoneNumbersDTO.isActive());
				clientContact.setProcessId(processId);
				clientContact.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveIndividualClientContact(clientContact);
			}
			processLevelMap.put(processId, 3);
			IndividualClientAddress clientAdress = null;
			AddressEntity addressEntity = null;

			for (IndividualClientAddressesDTO addressesDTO : addressList) {
				clientAdress = new IndividualClientAddress();
				clientAdress.setClient(client);
				addressEntity = new AddressEntity();
				addressEntity.setAddress1(addressesDTO.getAddress1());
				addressEntity.setAddress2(addressesDTO.getAddress2());
				addressEntity.setCity(addressesDTO.getCity());
				addressEntity.setCountry(addressesDTO.getCountry());
				addressEntity.setPinCode(addressesDTO.getPinCode());
				addressEntity.setState(addressesDTO.getState());
				addressEntity.setUnitNumber(addressesDTO.getUnitNo());
				addressEntity.setProcessId(processId);
				addressEntity.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveAddressEntity(addressEntity);

				clientAdress.setAddressEntity(addressEntity);
				clientAdress.setProcessId(processId);
				clientAdress.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveIndividualClientAddress(clientAdress);
			}
			processLevelMap.put(processId, 4);

			IndividualClientEmail clientEmail = null;

			for (IndividualClientEmailDTO clientEmailDTO : emailList) {
				clientEmail = new IndividualClientEmail();
				clientEmail.setClient(client);
				clientEmail.setEmail(clientEmailDTO.getEmail());
				clientEmail.setPrimary(clientEmailDTO.isPrimaryEmail());
				clientEmail.setProcessId(processId);
				clientEmail.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveIndividualClientEmail(clientEmail);
			}
			processLevelMap.put(processId, 5);
			houseHoldDetail = new HouseHoldDetail();
			houseHoldDetail.setClient(client);
			houseHoldDetail.setName(houseHoldDetailDTO.getHouseholdName());
			houseHoldDetail.setPremium(houseHoldDetailDTO.getPremium());
			houseHoldDetail.setProcessId(processId);
			houseHoldDetail.setEntityStatus(EntityStatus.Processing);

			everestDAO.saveHouseHoldDetail(houseHoldDetail);
			processLevelMap.put(processId, 6);
			HouseholdMember householdMember = null;

			for (IndividualClientHouseHoldMemberDTO memberDTO : houseHoldMemberList) {
				householdMember = new HouseholdMember();
				householdMember.setHousehold(houseHoldDetail);
				householdMember.setName(memberDTO.getMemberName());
				householdMember.setPremium(memberDTO.getPremium());
				householdMember.setProcessId(processId);
				householdMember.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveHouseHoldMembers(householdMember);
			}
			processLevelMap.put(processId, 7);

			IndividualClientIdentity clientIdentity = null;

			for (IndividualClientIdentityDetailDTO detailDTO : idDetailList) {

				clientIdentity = new IndividualClientIdentity();
				clientIdentity.setClient(client);
				clientIdentity.setCountryOfIssuerence(detailDTO.getCountryOfIssuance());
				clientIdentity.setIdentityType(detailDTO.getIdentityType());
				clientIdentity.setProcessId(processId);
				clientIdentity.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveIndividualClientIdentity(clientIdentity);
			}
			processLevelMap.put(processId, 8);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = Constants.SUCCESS;
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in Adding Individual Client", e);
			responseMessage = "Error in Adding Individual Client";

			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in adding Individual Client";
			}
			deleteProcessingDetailsForAddIndividualClient(processId);
		}
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addIndividualClient>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);
		return response;

	}

	public JSONObject addBusinessClient(BusinessClientDTO request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		String processId = null;

		BusinessClient businessClient = null;

		List<BusinessRegistrationDetailsDTO> businessRegistrationList = null;

		List<BusinessClientContactDTO> contactList = null;

		List<BusinessClientAddressDTO> addressList = null;

		List<BusinessClientEmailDTO> emailList = null;

		try {

			if (request == null) {
				ScriptLogger.writeInfo("Error in Adding Business Client");
				throw new EverestException("Request is null");
			}

			processId = generateRandomPassword();

			businessClient = new BusinessClient();
			businessClient.setName(request.getName());
			businessClient.setBusinessIndustry(request.getBusinessIndustry());
			businessClient.setBusinessClass(request.getBusinessClass());
			businessClient.setProcessId(processId);
			businessClient.setEntityStatus(EntityStatus.Processing);
			everestDAO.saveBusinessClient(businessClient);
			processLevelMap.put(processId, 1);
			if (StringUtils.isNotEmpty(request.getAdvisorId())) {
				ClientMapRequest clientMapRequest = new ClientMapRequest();
				clientMapRequest.setAdvisorID(request.getAdvisorId());
				clientMapRequest.setClientId(businessClient.getId());
				clientMapRequest.setType("BUSINESS");

				advisorClientMapping(clientMapRequest);
			}
			processLevelMap.put(processId, 2);
			businessRegistrationList = request.getRegistrationList();
			contactList = request.getContacts();
			addressList = request.getAddresses();
			emailList = request.getEmails();

			BusinessRegistrationDetail businessRegistrationDetail = null;

			for (BusinessRegistrationDetailsDTO businessRegistrationDetailsDTO : businessRegistrationList) {
				businessRegistrationDetail = new BusinessRegistrationDetail();
				businessRegistrationDetail.setClient(businessClient);
				businessRegistrationDetail.setAgency(businessRegistrationDetailsDTO.getAgency());
				businessRegistrationDetail.setSegment(businessRegistrationDetailsDTO.getSegment());
				businessRegistrationDetail
						.setRegistrationNumber(businessRegistrationDetailsDTO.getRegistrationNumber());
				businessRegistrationDetail.setProcessId(processId);
				businessRegistrationDetail.setEntityStatus(EntityStatus.Processing);
				everestDAO.saveBusinessRegistrationDetail(businessRegistrationDetail);
			}
			processLevelMap.put(processId, 3);

			BusinessClientContact businessClientContact = null;
			ContactEntity contactEntity = null;

			for (BusinessClientContactDTO businessClientContactDTO : contactList) {
				businessClientContact = new BusinessClientContact();
				businessClientContact.setClient(businessClient);
				contactEntity = new ContactEntity();
				contactEntity.setNumber(businessClientContactDTO.getNumber());
				contactEntity.setCountryCode(businessClientContactDTO.getCountryCode());
				contactEntity.setAreaCode(businessClientContactDTO.getAreaCode());
				contactEntity.setType(fetchDropdown(businessClientContactDTO.getType()));
				contactEntity.setProcessId(processId);
				contactEntity.setEntityStatus(EntityStatus.Processing);

				businessClientContact.setContactEntity(contactEntity);
				businessClientContact.setProcessId(processId);
				businessClientContact.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveContactEntity(contactEntity);
				everestDAO.saveBusinessClientContact(businessClientContact);
			}
			processLevelMap.put(processId, 4);

			BusinessClientAddress businessClientAddress = null;
			AddressEntity addressEntity = null;

			for (BusinessClientAddressDTO addressDTO : addressList) {
				businessClientAddress = new BusinessClientAddress();
				businessClientAddress.setClient(businessClient);
				businessClientAddress.setAddressType(fetchDropdown(addressDTO.getAddressType()));
				businessClientAddress.setProcessId(processId);
				businessClientAddress.setEntityStatus(EntityStatus.Processing);

				addressEntity = new AddressEntity();
				addressEntity.setAddress1(addressDTO.getAddress1());
				addressEntity.setAddress2(addressDTO.getAddress2());
				addressEntity.setCity(addressDTO.getCity());
				addressEntity.setCountry(addressDTO.getCountry());
				addressEntity.setPinCode(addressDTO.getCountry());
				addressEntity.setState(addressDTO.getState());
				addressEntity.setUnitNumber(addressDTO.getUnitNo());
				addressEntity.setProcessId(processId);
				addressEntity.setEntityStatus(EntityStatus.Processing);

				businessClientAddress.setAddressEntity(addressEntity);
				everestDAO.saveAddressEntity(addressEntity);
				everestDAO.saveBusinessClientAddress(businessClientAddress);
			}
			processLevelMap.put(processId, 5);

			BusinessClientEmail businessClientEmail = null;

			for (BusinessClientEmailDTO businessClientEmailDTO : emailList) {
				businessClientEmail = new BusinessClientEmail();
				businessClientEmail.setClient(businessClient);
				businessClientEmail.setEmail(businessClientEmailDTO.getEmail());
				businessClientEmail.setPrimary(businessClientEmailDTO.isPrimaryEmail());
				businessClientEmail.setStatus(businessClientEmailDTO.isActive());
				businessClientEmail.setProcessId(processId);
				businessClientEmail.setEntityStatus(EntityStatus.Processing);

				everestDAO.saveBusinessClientEmail(businessClientEmail);
			}
			processLevelMap.put(processId, 6);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Client Added Successfully";
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in adding  business client", e);
			responseMessage = "Error in Adding business Client";

			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in adding business Client";
			}
			deleteProcessingDetailsForAddBusinessClient(processId);

		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addBusinessClient>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}
	/*----------------------------------------End Clients-------------------------------------------------*/

	private void deleteProcessingDetailsForAddIndividualClient(String processId) {

		ScriptLogger.writeInfo("inside delete for processId => " + processId);
		int processLevel = 0;
		if (processLevelMap.containsKey(processId)) {
			processLevel = processLevelMap.get(processId);
		}
		ScriptLogger.writeInfo("processLevel => " + processLevel);

		if (processLevel > 7) {
			everestDAO.deleteIndividualClientIdentityByProcessId(processId);
		}
		if (processLevel > 6) {
			everestDAO.deleteHouseholdMemberByProcessId(processId);
		}
		if (processLevel > 5) {
			everestDAO.deleteHouseHoldDetailByProcessId(processId);
		}
		if (processLevel > 4) {
			everestDAO.deleteIndividualClientEmailByProcessId(processId);
		}
		if (processLevel > 3) {
			everestDAO.deleteIndividualClientAddressByProcessId(processId);
			everestDAO.deleteAddressEntityByProcessId(processId);
		}
		if (processLevel > 2) {
			everestDAO.deleteIndividualClientContactByProcessId(processId);
			everestDAO.deleteContactEntityByProcessId(processId);
		}
		if (processLevel > 1) {
			everestDAO.deleteAdvisorIndividualClientMapByProcessId(processId);
		}
		if (processLevel > 0) {
			everestDAO.deleteIndividualClientByProcessId(processId);
		}
	}
	
	
	private void deleteProcessingDetailsForAddBusinessClient(String processId) {

		ScriptLogger.writeInfo("inside delete for processId => " + processId);
		int processLevel = 0;
		if (processLevelMap.containsKey(processId)) {
			processLevel = processLevelMap.get(processId);
		}
		ScriptLogger.writeInfo("processLevel => " + processLevel);

		if (processLevel > 5) {
			everestDAO.deleteBusinessClientEmailByProcessId(processId);
		}
		if (processLevel > 4) {
			everestDAO.deleteBusinessClientAddressByProcessId(processId);
			everestDAO.deleteAddressEntityByProcessId(processId);
		}
		if (processLevel > 3) {
			everestDAO.deleteBusinessClientContactByProcessId(processId);
			everestDAO.deleteContactEntityByProcessId(processId);
		}
		if (processLevel > 2) {
			everestDAO.deleteBusinessRegistrationDetailByProcessId(processId);
		}
		if (processLevel > 1) {
			everestDAO.deleteAdvisorBusinessClientMapByProcessId(processId);
		}
		if (processLevel > 0) {
			everestDAO.deleteBusinessClientByProcessId(processId);
		}
	}
}
