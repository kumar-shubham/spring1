package com.pisight.everest.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pisight.everest.dto.RiderCommisionRequest;
import com.pisight.everest.dto.RiderDTO;
import com.pisight.everest.service.RiderServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class RiderController {
	
	@Autowired
	private RiderServiceImpl riderServiceImpl = null;
	
	
/* ------------------------Rider----------------------------------- */
	
	@RequestMapping(value = "/addRiderCommisionRate", method = RequestMethod.POST)
	public JSONObject addRiderCommisionRate(@RequestBody RiderCommisionRequest request) {
		return riderServiceImpl.addRiderCommisionRate(request);
	}
	
	@RequestMapping(value = "/getRiderCommisionRateByPolicyPlanRiderId", method = RequestMethod.POST)
	public JSONObject getRiderCommisionRateByPolicyPlanRiderId(@RequestBody RiderCommisionRequest request) {
		return riderServiceImpl.getRiderCommisionRateByPolicyPlanRiderId(request);
	}
	
	
	
	@RequestMapping(value = "/addRider", method = RequestMethod.POST)
	public JSONObject Addriders(@RequestBody RiderDTO request) {
		return riderServiceImpl.addRider(request);
	}
	
	
	@RequestMapping(value = "/getRiders", method = RequestMethod.POST)
	public JSONObject getriders() {
		return riderServiceImpl.getRiders();
	}

}
