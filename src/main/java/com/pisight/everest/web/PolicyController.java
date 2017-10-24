package com.pisight.everest.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pisight.everest.dto.PolicyDTO;
import com.pisight.everest.dto.PremiumDTO;
import com.pisight.everest.service.PolicyServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class PolicyController {
	
	@Autowired
	private PolicyServiceImpl policyServiceImpl = null;
	
/* ------------------------Policy------------------------------------ */
	
	@RequestMapping(value = "/addPolicy", method = RequestMethod.POST)
	public JSONObject addPolicy(@RequestBody PolicyDTO request) {
		return policyServiceImpl.addPolicy(request);
	}
	
	@RequestMapping(value = "/addPolicyPremium", method = RequestMethod.POST)
	public JSONObject addPolicyPremium(@RequestBody PremiumDTO request) {
		return policyServiceImpl.addPolicyPremium(request);
	}
	
}
