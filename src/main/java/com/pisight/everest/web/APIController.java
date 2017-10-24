package com.pisight.everest.web;

import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.EventException;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.constants.Constants.EntityStatus;
import com.pisight.everest.dao.EverestDAO;
import com.pisight.everest.dto.AdvisoryGroupDTO;
import com.pisight.everest.dto.DropDownRequest;
import com.pisight.everest.entities.AdvisoryGroup;
import com.pisight.everest.entities.UserRole;
import com.pisight.everest.exception.EverestException;
import com.pisight.everest.service.BaseService;
import com.pisight.everest.service.EverestServiceImpl;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/api/v1")
public class APIController extends BaseService {

	@Autowired
	private EverestDAO everestDAO = null;

	@Autowired
	private EverestServiceImpl everestServiceImpl = null;

	@RequestMapping(value = "/hii", method = RequestMethod.POST)
	public String testApi() {
		return "pratik";
	}

	/* ------------------------user------------------------------------ */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUserRoles", method = RequestMethod.POST)
	public JSONObject getUserRoles() {
		long start = System.currentTimeMillis();

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		List<UserRole> userRoles = null;

		try {
			userRoles = everestDAO.fetchUserRoles();
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in fetching userroles", e);

			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Failed in fetching userroles";

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		errorCode = 0;
		responseStatus = Constants.SUCCESS;
		responseMessage = "Success";

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("userRoles", userRoles);

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(start);
		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	/* ------------------------Drop Downs------------------------------------ */
	@RequestMapping(value = "/addDropdown", method = RequestMethod.POST)
	public JSONObject addDropdown(@RequestBody DropDownRequest request) {
		return everestServiceImpl.addDropDown(request);
	}

	@RequestMapping(value = "/getDropdownList", method = RequestMethod.POST)
	public JSONObject getDropDownList(@RequestBody DropDownRequest request) {
		return everestServiceImpl.getDropDown(request);
	}

	
	@RequestMapping(value = "/updateDropdownList", method = RequestMethod.POST)
	public JSONObject updateDropdownList(@RequestBody DropDownRequest request) {
		return everestServiceImpl.updateDropdownList(request);
	}
	
	/*-------------------------Advisor Group----------------------------------*/

	@RequestMapping(value = "/addAdvisoryGroup", method = RequestMethod.POST)
	public JSONObject addAdvisoryGroup(@RequestBody AdvisoryGroupDTO request) {

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		try {
			if (request == null) {
				throw new EverestException("Request is null");
			}
			String processId = generateRandomPassword();

			AdvisoryGroup advisoryGroup = new AdvisoryGroup();
			advisoryGroup.setGroupName(request.getGroupName());
			advisoryGroup.setProcessId(processId);
			advisoryGroup.setEntityStatus(EntityStatus.Processing);

			everestDAO.saveEmployeeAdvisoryGroup(advisoryGroup);
			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";
		} catch (Exception e) {
			if (e instanceof EventException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in adding AdvisoryGroup";
			}
			ScriptLogger.writeError("Error in adding AdvisoryGroup", e);
		}
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>>>>>  addAdvisoryGroup  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		return response;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAdvisoryGroup", method = RequestMethod.POST)
	public JSONObject getAdvisoryGroup() {

		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";
		List<AdvisoryGroup> advisoryGroups =null;
		try {
			advisoryGroups = everestDAO.fetchAdvisorGroups();
			if (advisoryGroups.size() > 0) {
				errorCode = 0;
				responseStatus = Constants.SUCCESS;
				responseMessage = "Success";
			} else {
				throw new EverestException("Error in fetching Advisory Groups");
			}

		} catch (Exception e) {
			if (e instanceof EventException) {
				responseMessage = e.getMessage();
			} else {
				responseMessage = "Error in fetching AdvisoryGroup";
			}
			ScriptLogger.writeError("Error in fetching AdvisoryGroup", e);
		}
		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("AdvisoryGroup", advisoryGroups);
		return response;
	}

}
