package com.pisight.everest.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pisight.everest.dto.CarrierDTO;
import com.pisight.everest.dto.CarrierRequest;
import com.pisight.everest.dto.CarrierResponse;
import com.pisight.everest.service.CarrierServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class CarrierController {
	

	@Autowired
	private CarrierServiceImpl carrierServiceImpl = null;
	
	
	/* ------------------------Carrier------------------------------------ */
	@RequestMapping(value = "/addCarrier", method = RequestMethod.POST)
	public JSONObject saveCarrier(@RequestBody CarrierDTO request) {
		return carrierServiceImpl.addcarrier(request);
	}

	@RequestMapping(value = "/getCarriers", method = RequestMethod.POST)
	public JSONObject getCarrier() {
		return carrierServiceImpl.getCarriers();
	}

	@RequestMapping(value = "/getCarrierById", method = RequestMethod.POST)
	public CarrierResponse getCarrierById(@RequestBody CarrierRequest request) {
		return carrierServiceImpl.getCarrierById(request);
	}

}
