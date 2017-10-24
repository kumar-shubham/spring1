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
import com.pisight.everest.dto.CarrierAddressDTO;
import com.pisight.everest.dto.CarrierContactDTO;
import com.pisight.everest.dto.CarrierDTO;
import com.pisight.everest.dto.CarrierRequest;
import com.pisight.everest.dto.CarrierResponse;
import com.pisight.everest.entities.AddressEntity;
import com.pisight.everest.entities.Carrier;
import com.pisight.everest.entities.CarrierAddressDetails;
import com.pisight.everest.entities.CarrierContactDetails;
import com.pisight.everest.entities.ContactEntity;
import com.pisight.everest.exception.EverestException;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@Service
public class CarrierServiceImpl extends BaseService {
	
	private static HashMap<String, Integer> processLevelMap = new HashMap<String, Integer>();
	
	/*---------------------------------------- Carriers-------------------------------------------------*/
	public JSONObject addcarrier(CarrierDTO request) {
		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";
		
		String processId = null;

		try {
			
			processId = generateRandomPassword();
			
			if (request == null) {
				throw new EverestException("Invalid or Empty Request");
			}

			Carrier carrier = new Carrier();
			carrier.setAbbreviation(request.getAbbreviation());
			carrier.setIcon(request.getIcon());
			carrier.setName(request.getName());
			carrier.setStatus(request.isStatus());
			carrier.setEntityStatus(EntityStatus.Processing);

			Carrier tempCarrier = everestDAO.fetchCarrierByName(carrier.getName());
			if (tempCarrier != null) {
				throw new EverestException("Carrier already exists with the same name");
			}

			everestDAO.saveCarrier(carrier);
			processLevelMap.put(processId, 1);
			List<CarrierAddressDTO> carrierAddress = request.getCarrierAddress();
			List<CarrierAddressDetails> addressList = new ArrayList<>();
			CarrierAddressDetails addressDetails = null;

			for (CarrierAddressDTO entity : carrierAddress) {

				addressDetails = new CarrierAddressDetails();
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setActive(entity.isActive());
				addressEntity.setAddress1(entity.getAddress1());
				addressEntity.setAddress2(entity.getAddress2());
				addressEntity.setCity(entity.getCity());
				addressEntity.setCountry(entity.getCountry());
				addressEntity.setPinCode(entity.getPinCode());
				addressEntity.setState(entity.getState());
				addressEntity.setUnitNumber(entity.getUnitNumber());
				addressEntity.setEntityStatus(EntityStatus.Processing);
				addressEntity.setProcessId(processId);
				everestDAO.saveAddressEntity(addressEntity);
				addressDetails.setCarrier(carrier);
				addressDetails.setAddressEntity(addressEntity);
				addressDetails.setEntityStatus(EntityStatus.Processing);
				addressDetails.setProcessId(processId);
				everestDAO.saveCarrierAddressDetails(addressDetails);
				addressList.add(addressDetails);
			}
			processLevelMap.put(processId, 2);
			carrier.setAddresses(addressList);

			List<CarrierContactDTO> carrierContacts = request.getCarrierContacts();
			List<CarrierContactDetails> contactsList = new ArrayList<>();
			CarrierContactDetails contactDetails = null;
			ContactEntity contactEntity = null;

			for (CarrierContactDTO entity : carrierContacts) {

				contactDetails = new CarrierContactDetails();

				contactEntity = new ContactEntity();
				contactEntity.setAreaCode(entity.getAreaCode());
				contactEntity.setCountryCode(entity.getCountryCode());
				contactEntity.setEmail(entity.getEmail());
				contactEntity.setName(entity.getName());
				contactEntity.setNumber(entity.getNumber());
				contactEntity.setType(fetchDropdown(entity.getType()));
				contactEntity.setEntityStatus(EntityStatus.Processing);
				contactEntity.setProcessId(processId);
				everestDAO.saveContactEntity(contactEntity);
				contactDetails.setCarrier(carrier);
				contactDetails.setContactEntity(contactEntity);
				contactDetails.setEntityStatus(EntityStatus.Processing);
				contactDetails.setProcessId(processId);
				everestDAO.saveCarrierContactDetails(contactDetails);
				contactsList.add(contactDetails);
			}
			processLevelMap.put(processId, 3);
			carrier.setContacts(contactsList);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in Adding Carrier", e);
			if(e instanceof EverestException) {
				responseMessage = e.getMessage();
			}
			else {
				responseMessage = "Error in Adding Carrier";
			}
			deleteProcessingDetailsForAddCarriers(processId);
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addCarrier>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}


	@SuppressWarnings("unchecked")
	public JSONObject getCarriers() {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		List<Carrier> carriersList = null;

		try {
			carriersList = everestDAO.fetchCarriers();
			
			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Carriers fetched successfully";

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in fetching carriers List", e);
			if(e instanceof EverestException) {
				responseMessage = e.getMessage();
			}
			else {
				responseMessage = "Error in fetching carriers List";
			}
		}
		
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("carriers", carriersList);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getCarriers>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	public CarrierResponse getCarrierById(CarrierRequest request) {

		long start = System.currentTimeMillis();

		CarrierResponse carrierResponse = new CarrierResponse();
		int errorCode = 100;
		boolean responseStatus = false;
		String responseMessage = null;

		try {
			if (StringUtils.isNotEmpty(request.getCarrierID())) {

				Carrier carrier = everestDAO.fetchCarrier(UUID.fromString(request.getCarrierID()));

				if (carrier != null) {
					carrierResponse = new CarrierResponse();
					List<CarrierContactDetails> carrierContactDetails = carrier.getContacts();
					List<CarrierAddressDetails> carrierAddressDetails = carrier.getAddresses();

					carrierResponse.setName(carrier.getName());
					carrierResponse.setAbbreviation(carrier.getAbbreviation());
					carrierResponse.setIcon(carrier.getIcon());
					carrierResponse.setId(carrier.getId());
					carrierResponse.setStatus(carrier.isStatus());

					List<CarrierAddressDTO> addressList = new ArrayList<>();

					for (CarrierAddressDetails entity : carrierAddressDetails) {

						CarrierAddressDTO addressDTO = new CarrierAddressDTO();
						AddressEntity addressEntity = entity.getAddressEntity();

						addressDTO.setAddress1(addressEntity.getAddress1());
						addressDTO.setAddress2(addressEntity.getAddress2());
						addressDTO.setCity(addressEntity.getCity());
						addressDTO.setCountry(addressEntity.getCountry());
						addressDTO.setPinCode(addressEntity.getPinCode());
						addressDTO.setState(addressEntity.getState());
						addressDTO.setUnitNumber(addressEntity.getUnitNumber());
						addressDTO.setActive(addressEntity.isActive());

						addressList.add(addressDTO);
					}

					carrierResponse.setAddresses(addressList);

					List<CarrierContactDTO> contactsList = new ArrayList<>();

					for (CarrierContactDetails entity : carrierContactDetails) {

						CarrierContactDTO contactDTO = new CarrierContactDTO();
						ContactEntity contactEntity = entity.getContactEntity();

						contactDTO.setAreaCode(contactEntity.getAreaCode());
						contactDTO.setCountryCode(contactEntity.getCountryCode());
						contactDTO.setEmail(contactEntity.getEmail());
						contactDTO.setName(contactEntity.getName());
						contactDTO.setNumber(contactEntity.getNumber());
						contactDTO.setType(convertDropDownListTodropDownDTO(contactEntity.getType()));

						contactsList.add(contactDTO);
					}
					carrierResponse.setContacts(contactsList);

				} else {
					throw new EverestException("Carrier Id should not empty");
				}
			}
			errorCode = 0;
			responseStatus = true;
			responseMessage = "Success";
		} catch (Exception e) {

			ScriptLogger.writeInfo("Error in fetching  carrier", e);
			if(e instanceof EverestException) {
				responseMessage = e.getMessage();
			}
			else {
				responseMessage = "Error in fetching carriers List";
			}
		}

		carrierResponse.setStatus(responseStatus);
		carrierResponse.setMessage(responseMessage);
		carrierResponse.setErrorCode(errorCode);
		
		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getCarrierById>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return carrierResponse;
	}

	/*----------------------------------------End Carriers-------------------------------------------------*/

	/* ~~~~~~~~~~~~~~~~~~~~~~DeleteByProecssId~~~~~~~~~~~~~~~~~~~~~~~~ */
	
	private void deleteProcessingDetailsForAddCarriers(String processId) {
		
		ScriptLogger.writeInfo("inside delete for processId => " + processId);
		int processLevel = 0;
		if (processLevelMap.containsKey(processId)) {
			processLevel = processLevelMap.get(processId);
		}
		ScriptLogger.writeInfo("processLevel => " + processLevel);
		
		if (processLevel > 2) {
			everestDAO.deleteCarrierContactDetailsByProcessId(processId);
			everestDAO.deleteContactEntityByProcessId(processId);
		}
		if (processLevel > 1) {
			everestDAO.deleteCarrierAddressDetailsByProcessId(processId);
			everestDAO.deleteAddressEntityByProcessId(processId);
		}
		if (processLevel > 0) {
			everestDAO.deleteCarrierByProcessId(processId);
		}
	}
}
