package com.pisight.everest.web;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.dto.EmployeeDTO;
import com.pisight.everest.dto.EmployeeRequest;
import com.pisight.everest.entities.Employee;
import com.pisight.everest.service.EmployeeServiceImpl;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl = null;
	
	
	/* ------------------------Employee------------------------------------ */

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public JSONObject addEmployee(@RequestBody EmployeeDTO request) {
		return employeeServiceImpl.addEmployee(request);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEmployees", method = RequestMethod.POST)
	public JSONObject getEmployees() {

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		List<Employee> employees = null;
		try {
			employees = employeeServiceImpl.getEmployess();

			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in fetching employeess", e);

			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Failed in fetching employees";

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("employeess", employees);
		return response;
	}

	@RequestMapping(value = "/getEmployeeByEmpId", method = RequestMethod.POST)
	public JSONObject getEmployeeByUserId(@RequestBody EmployeeRequest request) {
		return employeeServiceImpl.getEmployeeByempId(request);
	}

	@RequestMapping(value = "/getEmployeeByUserId", method = RequestMethod.POST)
	public JSONObject getEmployeeByEmpId(@RequestBody EmployeeRequest request) {
		return employeeServiceImpl.getEmployeeByUserId(request);
	}

}
