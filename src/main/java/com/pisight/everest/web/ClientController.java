package com.pisight.everest.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pisight.everest.dto.BusinessClientDTO;
import com.pisight.everest.dto.ClientMapRequest;
import com.pisight.everest.dto.ClientRequest;
import com.pisight.everest.dto.InividualClientDTO;
import com.pisight.everest.service.ClientServiceImpl;
import com.pisight.everest.util.ClientResponse;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class ClientController {
	

	@Autowired
	private ClientServiceImpl clientServiceImpl = null;
	
	
	/* ------------------------Client------------------------------------ */
	@RequestMapping(value = "/getClient", method = RequestMethod.POST)
	public ClientResponse getIndividualClients(@RequestBody ClientRequest request) {
		return clientServiceImpl.getClients(request);
	}

	@RequestMapping(value = "/addIndividualClient", method = RequestMethod.POST)
	public JSONObject addIndividualClient(@RequestBody InividualClientDTO request){
		return clientServiceImpl.addIndividualClient(request);
	}

	@RequestMapping(value = "/advisorClientMap", method = RequestMethod.POST)
	public JSONObject setAdvisorClientMap(@RequestBody ClientMapRequest request) {
		return clientServiceImpl.setAdvisorClientMap(request);
	}

	@RequestMapping(value = "/addBusinessClient", method = RequestMethod.POST)
	public JSONObject addBusinessClient(@RequestBody BusinessClientDTO request) {
		return clientServiceImpl.addBusinessClient(request);
	}

}
