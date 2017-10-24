package com.pisight.everest.service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;
import com.pisight.everest.dto.PolicyAdvisorDTO;
import com.pisight.everest.dto.PolicyDTO;
import com.pisight.everest.dto.PremiumDTO;
import com.pisight.everest.dto.RiderPremiumDTO;
import com.pisight.everest.entities.Advisor;
import com.pisight.everest.entities.AdvisoryGroup;
import com.pisight.everest.entities.BusinessClient;
import com.pisight.everest.entities.IndividualClient;
import com.pisight.everest.entities.Policy;
import com.pisight.everest.entities.PolicyAdvisorMap;
import com.pisight.everest.entities.PolicyPlan;
import com.pisight.everest.entities.PolicyPlanRider;
import com.pisight.everest.entities.PolicyPlanTerm;
import com.pisight.everest.entities.PolicyPremium;
import com.pisight.everest.entities.PolicyRider;
import com.pisight.everest.entities.PolicyRiderPremium;
import com.pisight.everest.exception.EverestException;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@Service
public class PolicyServiceImpl extends BaseService {

	/*----------------------------------------Policy-------------------------------------------------*/
	public JSONObject addPolicy(PolicyDTO request) {
		long start = System.currentTimeMillis();
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		String processId = null;

		try {
			if (request == null) {
				ScriptLogger.writeInfo("Request is null");
				throw new EverestException("Request is null");
			}

			String temp = null;
			String buyerType = request.getBuyerType();
			String insuredType = request.getInsuredType();

			processId = generateRandomPassword();

			if (request.getPolicyPlanId() == null) {
				temp = "PolicyPlanId";
			}else if (request.getPolicyPlanTermId() == null) {
				temp = "PlanTermId";
			}else if (StringUtils.isEmpty(buyerType)) {
				temp = "BuyerType";
			} else if (StringUtils.isEmpty(insuredType)) {
				temp = "InsuredType";
			} else if (request.getPrimaryAdvisorId() == null) {
				temp = "PrimaryAdvisorId";
			} else if (request.getAdvisoryGroupId() == null) {
				temp = "AdvisoryGroupId";
			}
			
			ScriptLogger.writeWarning("temp => " + temp);

			if (temp != null) {
				ScriptLogger.writeInfo(temp + " cannot be empty");
				throw new EverestException(temp + " cannot be empty");
			}

			PolicyPlan policyPlan = everestDAO.fetchPolicyPlan(request.getPolicyPlanId());
			PolicyPlanTerm policyPlanTerm = everestDAO.fetchPolicyPlanTermById(request.getPolicyPlanTermId());
			Advisor advisor = everestDAO.fetchAdvisor(request.getPrimaryAdvisorId());
			AdvisoryGroup advisoryGroup = everestDAO.fetchAdvisoryGroup(request.getAdvisoryGroupId());

			Policy policy = new Policy();

			policy.setBasicFaceValue(request.getBasicFaceValue());
			policy.setEffectiveDate(request.getEffectiveDate());
			policy.setNumberOfPremiumPaid(request.getNumberOfPremiumPaid());
			policy.setPremiumFrequency(request.getPremiumFrequency());
			policy.setNumberOfPremiums(request.getNumberOfPremiums());
			policy.setStatus(fetchDropdown(request.getStatus()));
			policy.setPolicyPlan(policyPlan);
			policy.setPolicyPlanTerm(policyPlanTerm);
			policy.setPrimaryAdvisor(advisor);
			policy.setAdvisoryGroup(advisoryGroup);
			policy.setBSCapplied(request.isBSCapplied());
			policy.setProcessId(processId);
			policy.setEntityStatus(EntityStatus.Processing);

			if (Constants.CLIENT_TYPE_BUSINESS.equals(buyerType)) {
				BusinessClient businessClient = everestDAO.fetchBusinessClient(request.getBuyerId());

				if (businessClient == null) {
					ScriptLogger.writeInfo("Error in businessClient");
					throw new EverestException("Error in businessClient");
				}
				policy.setBusinessBuyer(businessClient);
			} else if (Constants.CLIENT_TYPE_INDIVIDUAL.equals(buyerType)) {
				IndividualClient individualClient = everestDAO.fetchIndividualClient(request.getBuyerId());

				if (individualClient == null) {
					ScriptLogger.writeInfo("Error in individualClient");
					throw new EverestException("Error in individualClient");
				}
				policy.setIndividualBuyer(individualClient);

			}

			if (Constants.CLIENT_TYPE_BUSINESS.equals(insuredType)) {
				BusinessClient businessClient = everestDAO.fetchBusinessClient(request.getInsuredId());
				if (businessClient == null) {
					ScriptLogger.writeInfo("Error in BusinessInsured");
					throw new EverestException("Error in BusinessInsured");
				}
				policy.setBusinessInsured(businessClient);
			} else if (Constants.CLIENT_TYPE_INDIVIDUAL.equals(insuredType)) {
				IndividualClient individualClient = everestDAO.fetchIndividualClient(request.getInsuredId());

				if (individualClient == null) {
					ScriptLogger.writeInfo("Error in individualInsured");
					throw new EverestException("Error in individualInsured");
				}
				policy.setIndividualInsured(individualClient);
			}

			policy = everestDAO.savePolicy(policy);

			List<UUID> riders = request.getRiders();
			int riderSize = riders.size();

			if (riderSize > 0) {
				for (UUID uuid : riders) {

					PolicyRider policyRider = new PolicyRider();
					PolicyPlanRider planRider = everestDAO.fetchPolicyPlanRider(uuid);

					if (planRider != null) {
						policyRider.setPolicyPlanRider(planRider);
						policyRider.setPolicy(policy);
						policyRider.setProcessId(processId);
						policyRider.setEntityStatus(EntityStatus.Processing);
						everestDAO.savePolicyRider(policyRider);
					}
				}
			}

			List<PolicyAdvisorDTO> advisors = request.getAllAdvisors();
			int advisorSize = advisors.size();

			if (advisorSize > 0) {
				for (PolicyAdvisorDTO policyAdvisorDTO : advisors) {

					PolicyAdvisorMap policyAdvisorMap = new PolicyAdvisorMap();
					Advisor advisor2 = everestDAO.fetchAdvisor(policyAdvisorDTO.getId());

					if (advisor2 != null) {
						policyAdvisorMap.setAdvisor(advisor2);
						policyAdvisorMap.setAdvisorRole(policyAdvisorDTO.getAdvisorRole());
						policyAdvisorMap.setCommissionPercent(policyAdvisorDTO.getCommissionPercent());
						policyAdvisorMap.setPolicy(policy);
						policyAdvisorMap.setProcessId(processId);
						policyAdvisorMap.setEntityStatus(EntityStatus.Processing);
						everestDAO.savePolicyAdvisorMap(policyAdvisorMap);
					}
				}
			}

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in adding policy ", e);
			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in adding policy ";
			}

		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>> add Policy >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>> Total time Taken >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject addPolicyPremium(PremiumDTO request) {
		long start = System.currentTimeMillis();
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		String processId = request.getProcessId();
		
		try {
			Policy policy = everestDAO.fetchPolicyByProcessId(processId);

			if (policy == null) {
				throw new EverestException("Incorrect Process Id");
			}

			String premium = request.getPremium();
			String loadingPremium = request.getLoadingPremium();
			String frequncy = policy.getPremiumFrequency();
			int noOfPremium = policy.getNumberOfPremiums();

			Calendar cal = Calendar.getInstance();
			boolean dateAvailable = false;
			int monthOffset = 0;
			if (policy.getEffectiveDate() != null) {
				dateAvailable = true;
				cal.setTime(policy.getEffectiveDate());
			}

			if (Constants.FREQUENCY_MONTHLY.equals(frequncy)) {
				monthOffset = 1;
			} else if (Constants.FREQUENCY_QUATERLY.equals(frequncy)) {
				monthOffset = 3;
			} else if (Constants.FREQUENCY_HALF_YEARLY.equals(frequncy)) {
				monthOffset = 6;
			} else {
				monthOffset = 12;
			}

			for (int i = 0; i < noOfPremium; i++) {
				PolicyPremium pp = new PolicyPremium();
				pp.setPremium(premium);
				pp.setLoadingPremium(loadingPremium);
				pp.setPolicy(policy);
				pp.setProcessId(processId);
				if (dateAvailable) {
					cal.add(Calendar.MONTH, monthOffset);
				}
				pp.setEffectiveDate(cal.getTime());
				everestDAO.savePolicyPremium(pp);
				addPolicyRiderPremium(pp, request);
			}

		} catch (Exception e) {

			if (e instanceof EverestException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in saving premium";
			}
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("processId", processId);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>> add Policy >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>> Total time Taken >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;

	}

	public void addPolicyRiderPremium(PolicyPremium policyPremium, PremiumDTO request) {

		List<RiderPremiumDTO> rpDTOs = request.getRiderPremium();

		for (RiderPremiumDTO rpDTO : rpDTOs) {

			PolicyRiderPremium prp = new PolicyRiderPremium();
			PolicyRider pr = everestDAO.fetchPolicyRider(UUID.fromString(rpDTO.getId()));

			prp.setPolicyPremium(policyPremium);
			prp.setPolicyRider(pr);
			prp.setPremium(rpDTO.getPremium());
			prp.setLoadingPremium(rpDTO.getLoadingPremium());
			everestDAO.savePolicyRiderPremium(prp);
		}

	}

}
