package com.pisight.everest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;
import com.pisight.everest.dto.PolicyPlanCommisionRateDTO;
import com.pisight.everest.dto.PolicyPlanCommisionRequest;
import com.pisight.everest.dto.PolicyPlanDTO;
import com.pisight.everest.dto.PolicyPlanRequest;
import com.pisight.everest.dto.PolicyPlanResponse;
import com.pisight.everest.dto.PolicyPlanRiderDTO;
import com.pisight.everest.dto.PolicyPlanTermDTO;
import com.pisight.everest.dto.PolicyPlanTermRequest;
import com.pisight.everest.dto.RiderCommissionRateDTO;
import com.pisight.everest.entities.Carrier;
import com.pisight.everest.entities.PolicyPlan;
import com.pisight.everest.entities.PolicyPlanCommissionRate;
import com.pisight.everest.entities.PolicyPlanRider;
import com.pisight.everest.entities.PolicyPlanTerm;
import com.pisight.everest.entities.Rider;
import com.pisight.everest.entities.RiderCommissionRate;
import com.pisight.everest.exception.EverestException;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@Service
public class PolicyPlanServiceImpl extends BaseService {

	/*---------------------------------------- Policy-------------------------------------------------*/
	public JSONObject addPolicyPlan(PolicyPlanDTO request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		String processId = null;

		try {
			processId = generateRandomPassword();

			if (request == null) {
				throw new EverestException("Invalid request");
			}

			if (request.getCarrierId() == null) {
				ScriptLogger.writeInfo("Invalid carrier ID");
				throw new EverestException("Invalid carrier ID");
			}
			Carrier carrier = everestDAO.fetchCarrier(request.getCarrierId());
			if (carrier == null) {
				ScriptLogger.writeInfo("Carrier not found");
				throw new EverestException("Carrier not found");
			}

			PolicyPlan tempPlan = everestDAO.fetchpoicyPlanByName(request.getName());
			if (tempPlan != null) {

				ScriptLogger.writeInfo("PolicyPlan already present");
				throw new EverestException("PolicyPlan already exists.");
			}

			PolicyPlan plan = new PolicyPlan();
			plan.setCarrier(carrier);
			plan.setActive(request.isActive());
			plan.setApproved(request.isApproved());
			plan.setEffectiveDate(request.getEffectiveDate());
			plan.setExpirationDate(request.getExpirationDate());
			plan.setName(request.getName());
			plan.setPlanType(fetchDropdown(request.getPlanType()));
			plan.setProcessId(processId);
			plan.setEntityStatus(EntityStatus.Processing);

			List<PolicyPlanTermDTO> planTermDTOs = request.getPlanTerms();
			List<PolicyPlanTerm> policyPlanTerms = new ArrayList<>();

			for (PolicyPlanTermDTO entity : planTermDTOs) {

				PolicyPlanTerm policyPlanTerm = new PolicyPlanTerm();
				policyPlanTerm.setPolicyPlan(plan);
				policyPlanTerm.setActive(entity.isActive());
				policyPlanTerm.setFromMonth(entity.getFromMonth());
				policyPlanTerm.setToMonth(entity.getToMonth());
				policyPlanTerm.setProcessId(processId);
				policyPlanTerm.setEntityStatus(EntityStatus.Processing);

				List<PolicyPlanCommisionRateDTO> planCommisionRateDTOs = entity.getCommissionRates();
				List<PolicyPlanCommissionRate> rates = new ArrayList<>();
				rates.clear();

				for (PolicyPlanCommisionRateDTO entity2 : planCommisionRateDTOs) {

					PolicyPlanCommissionRate commissionRate = new PolicyPlanCommissionRate();
					commissionRate.setPolicyPlanTerm(policyPlanTerm);
					commissionRate.setCommissionRate(entity2.getCommissionRate());
					commissionRate.setEffectiveDate(entity2.getEffectiveDate());
					commissionRate.setFromMonth(entity2.getFromMonth());
					commissionRate.setPolicyPlanTerm(policyPlanTerm);
					commissionRate.setRemark(entity2.getRemark());
					commissionRate.setToMonth(entity2.getToMonth());
					commissionRate.setStatus(entity2.isStatus());
					commissionRate.setProcessId(processId);
					commissionRate.setEntityStatus(EntityStatus.Processing);

					everestDAO.savePolicyPlanCommissionRate(commissionRate);

					rates.add(commissionRate);
				}
				policyPlanTerm.setCommissionRates(rates);
				policyPlanTerms.add(policyPlanTerm);
				everestDAO.savePolicyPlanTerm(policyPlanTerm);
			}
			plan.setPlanTerms(policyPlanTerms);

			Set<PolicyPlanRiderDTO> planRiderDTOs = request.getPolicyPlanRiders();

			Set<PolicyPlanRider> planRiders = new HashSet<PolicyPlanRider>();

			for (PolicyPlanRiderDTO planRiderDTO : planRiderDTOs) {
				PolicyPlanRider planRider = new PolicyPlanRider();
				planRider.setPolicyPlan(plan);
				planRider.setProcessId(processId);
				planRider.setEntityStatus(EntityStatus.Processing);
				
				List<RiderCommissionRateDTO> riderCommissionRateDTOs = planRiderDTO.getRiderCommissionRates();
				List<RiderCommissionRate> rates = new ArrayList<>();
				rates.clear();

				for (RiderCommissionRateDTO entity2 : riderCommissionRateDTOs) {


					RiderCommissionRate commissionRate = new RiderCommissionRate();
					commissionRate.setPolicyPlanRider(planRider);
					commissionRate.setCommissionRate(entity2.getCommissionRate());
					commissionRate.setEffectiveDate(entity2.getEffectiveDate());
					commissionRate.setFromMonth(entity2.getFromMonth());
					commissionRate.setRemark(entity2.getRemark());
					commissionRate.setToMonth(entity2.getToMonth());
					commissionRate.setStatus(entity2.isStatus());
					commissionRate.setProcessId(processId);
					commissionRate.setEntityStatus(EntityStatus.Processing);

					everestDAO.saveRiderCommissionRate(commissionRate);

					rates.add(commissionRate);
				}
				

				ScriptLogger.writeInfo("rider id => " + planRiderDTO.getId());
				Rider rider = everestDAO.fetchRider(planRiderDTO.getId());
	
				if (rider == null) {
					throw new EverestException("Incorrect rider id");
				}
				planRider.setRider(rider);

				rider.setPolicyPlanRiders(planRiders);

				planRiders.add(planRider);

				everestDAO.savePolicyPlanRider(planRider);
			}
			plan.setPolicyPlanRiders(planRiders);

			everestDAO.savePolicyPlan(plan);
			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {

			if (e instanceof EventException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in adding policy plan";
			}
			ScriptLogger.writeError("Error in adding policy plan ", e);
			// sequentially delete all rows if exception occured
		}

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addPolicyPlan>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getPolicyPlans() {
		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		List<PolicyPlan> plansList = null;
		try {

			plansList = everestDAO.fetchPolicyPlans();
			if (plansList == null) {

				ScriptLogger.writeInfo("Error in Fetching  policy Plans");
				throw new EverestException("Error in Fetching  policy Plans");
			}

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";
		} catch (Exception e) {
			if (e instanceof EventException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in Fetching  policy Plans";
			}
			ScriptLogger.writeError("Error in Fetching  policy Plans ", e);

		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("PolicyPlan", plansList);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getPolicyPlan>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getPolicyPlanById(PolicyPlanRequest request) {

		long start = System.currentTimeMillis();
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		PolicyPlanResponse planResponse = null;

		try {
			if (request.getId() == null) {
				responseMessage = "id should not be null";
				throw new EverestException("id should not be null");
			}

			PolicyPlan policyPlan = everestDAO.fetchPolicyPlan(request.getId());

			if (policyPlan == null) {
				responseMessage = "Policy plan not found";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			planResponse = setPolicyPlan(policyPlan);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";
		} catch (Exception e) {

			ScriptLogger.writeInfo("Error in getPolicyPlan", e);
			if (e instanceof EventException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in getPolicyPlan";
			}
			ScriptLogger.writeError("Error in getPolicyPlan", e);

		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("PolicyPlan", planResponse);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getPolicyPlanById>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getPolicyPlansByCarrierId(PolicyPlanRequest request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";
		try {
			if (request.getCarrierId() == null) {
				responseMessage = "carrier id should not be null";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			List<PolicyPlan> policyPlans = everestDAO.fetchPolicyPlansByCarrierID(request.getCarrierId());

			if (policyPlans == null) {
				responseMessage = "Policy plans not found";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			List<PolicyPlanResponse> planResponseList = new ArrayList<>();
			for (PolicyPlan plan : policyPlans) {
				PolicyPlanResponse planResponse = setPolicyPlan(plan);
				planResponseList.add(planResponse);
			}

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			response.put("PolicyPlans", planResponseList);
		} catch (Exception e) {

			ScriptLogger.writeInfo("Error in getPolicyPlansByCarrierId", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getPolicyPlanByCarrierId>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		return response;
	}

	public PolicyPlanResponse setPolicyPlan(PolicyPlan policyPlan) {

		long start = System.currentTimeMillis();

		PolicyPlanResponse planResponse = new PolicyPlanResponse();
		try {
			planResponse.setActive(policyPlan.isActive());
			planResponse.setApproved(policyPlan.isApproved());
			planResponse.setEffectiveDate(policyPlan.getEffectiveDate());
			planResponse.setExpirationDate(policyPlan.getEffectiveDate());
			planResponse.setId(policyPlan.getId());
			planResponse.setName(policyPlan.getName());
			planResponse.setPlanType(convertDropDownListTodropDownDTO(policyPlan.getPlanType()));

			List<PolicyPlanTerm> policyPlanTerms = policyPlan.getPlanTerms();
			List<PolicyPlanTermDTO> planTermDTOs = new ArrayList<>();

			for (PolicyPlanTerm term : policyPlanTerms) {
				PolicyPlanTermDTO planTermDTO = new PolicyPlanTermDTO();
				planTermDTO.setActive(term.isActive());
				planTermDTO.setFromMonth(term.getFromMonth());
				planTermDTO.setToMonth(term.getToMonth());

				List<PolicyPlanCommissionRate> commissionRates = term.getCommissionRates();
				List<PolicyPlanCommisionRateDTO> commisionRateDTOs = new ArrayList<>();

				for (PolicyPlanCommissionRate rate : commissionRates) {
					PolicyPlanCommisionRateDTO rateDTO = new PolicyPlanCommisionRateDTO();
					rateDTO.setCommissionRate(rate.getCommissionRate());
					rateDTO.setEffectiveDate(rate.getEffectiveDate());
					rateDTO.setFromMonth(rate.getFromMonth());
					rateDTO.setRemark(rate.getRemark());
					rateDTO.setStatus(rate.isStatus());
					rateDTO.setToMonth(rate.getToMonth());

					commisionRateDTOs.add(rateDTO);
				}

				planTermDTO.setCommissionRates(commisionRateDTOs);

				planTermDTOs.add(planTermDTO);
			}

			planResponse.setPlanTerms(planTermDTOs);

			Set<PolicyPlanRider> policyPlanRiders = policyPlan.getPolicyPlanRiders();

			Set<PolicyPlanRiderDTO> planRiderDTOs = new HashSet<>();

			for (PolicyPlanRider planRider : policyPlanRiders) {

				PolicyPlanRiderDTO planRiderDTO = new PolicyPlanRiderDTO();

				Rider rider = planRider.getRider();

				// planRiderDTO.setName(rider.getName());

				planRiderDTOs.add(planRiderDTO);

			}
			planResponse.setPolicyPlanRiders(planRiderDTOs);
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in getPolicyPlansByCarrierId", e);
		}

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>setPolicyPlan>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return planResponse;
	}

	public JSONObject addPolicyPlanCommisionRate(PolicyPlanCommisionRequest request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		if (request.getPlanTermId() == null || "".equals(request.getPlanTermId())) {
			responseMessage = "plantermId should not be null";
			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}
		try {
			PolicyPlanTerm policyPlanTerm = everestDAO.fetchPolicyPlanTermById(request.getPlanTermId());

			if (policyPlanTerm == null) {

				ScriptLogger.writeInfo("Policy PlanTerm not found");
				errorCode = 100;
				responseStatus = Constants.FAILED;
				responseMessage = "Policy PlanTerm not found";

				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			PolicyPlanCommissionRate commissionRate = new PolicyPlanCommissionRate();
			commissionRate.setCommissionRate(request.getCommissionRate());
			commissionRate.setEffectiveDate(request.getEffectiveDate());
			commissionRate.setFromMonth(request.getFromMonth());
			commissionRate.setRemark(request.getRemark());
			commissionRate.setStatus(request.isStatus());
			commissionRate.setToMonth(request.getToMonth());

			commissionRate.setPolicyPlanTerm(policyPlanTerm);
			everestDAO.savePolicyPlanCommissionRate(commissionRate);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in Adding plan term commisionRate", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Error in Adding plan term commisionRate";
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addPolicyPlanCommisionRate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getPolicyPlanTermById(PolicyPlanTermRequest request) {

		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";
		PolicyPlanTerm planTerm = null;
		PolicyPlanTermDTO planTermDTO = null;
		try {
			if (StringUtils.isEmpty(request.getId())) {
				responseMessage = "invalid request";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}

			planTerm = everestDAO.fetchPolicyPlanTermById(UUID.fromString(request.getId()));
			if (planTerm == null) {

				responseMessage = "Plan term not found";
				JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
				return response;
			}
			planTermDTO = new PolicyPlanTermDTO();
			planTermDTO.setId(planTerm.getId());
			planTermDTO.setActive(planTerm.isActive());
			planTermDTO.setFromMonth(planTerm.getFromMonth());
			planTermDTO.setToMonth(planTerm.getToMonth());

			List<PolicyPlanCommissionRate> commissionRates = planTerm.getCommissionRates();

			List<PolicyPlanCommisionRateDTO> commisionRateDTOs = new ArrayList<>();

			for (PolicyPlanCommissionRate rate : commissionRates) {
				PolicyPlanCommisionRateDTO commisionRateDTO = new PolicyPlanCommisionRateDTO();
				commisionRateDTO.setId(rate.getId());
				commisionRateDTO.setCommissionRate(rate.getCommissionRate());
				commisionRateDTO.setEffectiveDate(rate.getEffectiveDate());
				commisionRateDTO.setFromMonth(rate.getFromMonth());
				commisionRateDTO.setToMonth(rate.getToMonth());
				commisionRateDTO.setRemark(rate.getRemark());
				commisionRateDTO.setStatus(rate.isStatus());

				commisionRateDTOs.add(commisionRateDTO);
			}
			planTermDTO.setCommissionRates(commisionRateDTOs);

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {

			ScriptLogger.writeInfo("Error in fetching policy plan terms", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Error in fetching policy plan terms";

		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("PolicyPlanTerm", planTermDTO);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getPolicyPlanTermById>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	/*----------------------------------------End Policy plan-------------------------------------------------*/

}
