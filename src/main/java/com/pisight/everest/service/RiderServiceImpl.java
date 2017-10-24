package com.pisight.everest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.dto.RiderCommisionRequest;
import com.pisight.everest.dto.RiderCommissionRateDTO;
import com.pisight.everest.dto.RiderDTO;
import com.pisight.everest.entities.PolicyPlanRider;
import com.pisight.everest.entities.PolicyPlanTerm;
import com.pisight.everest.entities.Rider;
import com.pisight.everest.entities.RiderCommissionRate;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@Service
public class RiderServiceImpl extends BaseService{
	
	/*---------------------------------------Rider-------------------------------------------------*/

	public JSONObject addRiderCommisionRate(RiderCommisionRequest request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		try {
			if (StringUtils.isEmpty(request.getRiderId()) || StringUtils.isEmpty(request.getPlanTermId())) {
				responseMessage = "Invalid Request";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			PolicyPlanTerm planTerm = everestDAO.fetchPolicyPlanTermById(UUID.fromString(request.getPlanTermId()));
			PolicyPlanRider rider = everestDAO.fetchPolicyPlanRider(UUID.fromString(request.getRiderId()));

			System.out.println("planTerm---" + planTerm);
			System.out.println("rider---" + rider);

			if (planTerm == null || rider == null) {

				responseMessage = "Invalid Request";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			RiderCommissionRate commissionRate = new RiderCommissionRate();
			commissionRate.setCommissionRate(request.getCommissionRate());
			commissionRate.setEffectiveDate(request.getEffectiveDate());
			commissionRate.setFromMonth(request.getFromMonth());
			commissionRate.setPolicyPlanRider(rider);
			commissionRate.setPolicyPlanTerm(planTerm);
			commissionRate.setRemark(request.getRemark());
			commissionRate.setToMonth(request.getToMonth());

			everestDAO.saveRiderCommissionRate(commissionRate);

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in addRiderCommisionRate", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		ScriptLogger.writeInfo("successfully added rider commisSion ratee");
		errorCode = 0;
		responseStatus = Constants.SUCCESS;
		responseMessage = "Success";

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addRiderCommisionRate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getRiderCommisionRateByPolicyPlanRiderId(RiderCommisionRequest request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		if (request == null) {
			responseMessage = "Invalid Request";
			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		List<RiderCommissionRate> commissionRates = everestDAO
				.fetchRiderCommisionRates(UUID.fromString(request.getRiderId()));
		List<RiderCommissionRateDTO> commissionRateDTOs = new ArrayList<>();

		if (commissionRates == null) {
			ScriptLogger.writeInfo("RiderCommisionRate not found");
			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "RiderCommisionRate not found";

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		try {

			for (RiderCommissionRate commissionRateDTO : commissionRates) {
				RiderCommissionRateDTO rate = new RiderCommissionRateDTO();

				rate.setId(commissionRateDTO.getId());
				rate.setCommissionRate(commissionRateDTO.getCommissionRate());
				rate.setEffectiveDate(commissionRateDTO.getEffectiveDate());
				rate.setFromMonth(commissionRateDTO.getFromMonth());
				rate.setToMonth(commissionRateDTO.getToMonth());
				rate.setRemark(commissionRateDTO.getRemark());
				rate.setStatus(commissionRateDTO.isStatus());

				commissionRateDTOs.add(rate);
			}

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {

			ScriptLogger.writeInfo("Error in fetching RiderCommisionRate", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Error in fetching RiderCommisionRate";
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("RiderCommissionRate", commissionRateDTOs);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(
				">>>>>>>>>>>>>>>>>>>>>>getRiderCommisionRateByPolicyPlanRiderId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getRiders() {

		ScriptLogger.writeInfo("---------------getRiders called---------------");
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Error in fetching riders";

		List<Rider> riders = null;
		try {
			riders = everestDAO.fetchRiders();

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in fetching Riders", e);
		}
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("riders", riders);
		return response;
	}

	public JSONObject addRider(RiderDTO request) {
		
		ScriptLogger.writeInfo("---------------addRider called---------------");
		
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Error in adding riders";
		
		if(request==null){
			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}
		
		try{
		Rider rider=new Rider();
		rider.setName(request.getName());
		everestDAO.saveRider(rider);
		}
		catch (Exception e) {
			ScriptLogger.writeInfo("Error in adding rider", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Error in adding rider";
		}
		
		errorCode = 0;
		responseStatus = Constants.SUCCESS;
		responseMessage = "Success";
		
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		return response;
	}

	/*--------------------------------------End-Rider-------------------------------------------------*/

}
