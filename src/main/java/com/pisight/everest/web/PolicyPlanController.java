package com.pisight.everest.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pisight.everest.dto.PolicyPlanCommisionRequest;
import com.pisight.everest.dto.PolicyPlanDTO;
import com.pisight.everest.dto.PolicyPlanRequest;
import com.pisight.everest.dto.PolicyPlanTermRequest;
import com.pisight.everest.service.PolicyPlanServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class PolicyPlanController{
	
	@Autowired
	private PolicyPlanServiceImpl policyPlanServiceImpl = null;
	
	
/* ------------------------Policy Plan------------------------------------ */
	
	@RequestMapping(value = "/addPolicyPlan", method = RequestMethod.POST)
	public JSONObject addPolicyPlan(@RequestBody PolicyPlanDTO request) {
		return policyPlanServiceImpl.addPolicyPlan(request);
	}
	
	@RequestMapping(value = "/addPolicyPlanCommisionRate", method = RequestMethod.POST)
	public JSONObject addPolicyPlanCommisionRate(@RequestBody PolicyPlanCommisionRequest request) {
		return policyPlanServiceImpl.addPolicyPlanCommisionRate(request);
	}

	@RequestMapping(value = "/getPolicyPlans", method = RequestMethod.POST)
	public JSONObject getPolicyPlans() {
		return policyPlanServiceImpl.getPolicyPlans();
	}
	
	
	@RequestMapping(value = "/getPolicyPlanById", method = RequestMethod.POST)
	public JSONObject getPolicyPlanById(@RequestBody PolicyPlanRequest request) {
		return policyPlanServiceImpl.getPolicyPlanById(request);
	}
	
	
	@RequestMapping(value = "/getPolicyPlansByCarrierId", method = RequestMethod.POST)
	public JSONObject getPolicyPlansByCarrierId(@RequestBody PolicyPlanRequest request) {
		return policyPlanServiceImpl.getPolicyPlansByCarrierId(request);
	}
	
	
	@RequestMapping(value = "/getPolicyPlanTermById", method = RequestMethod.POST)
	public JSONObject getPolicyPlanTermById(@RequestBody PolicyPlanTermRequest request) {
		return policyPlanServiceImpl.getPolicyPlanTermById(request);
	}

}
