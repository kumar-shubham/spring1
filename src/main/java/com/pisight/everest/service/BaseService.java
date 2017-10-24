package com.pisight.everest.service;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.dao.EverestDAO;
import com.pisight.everest.dto.DropDownDTO;
import com.pisight.everest.dto.DropDownRequest;
import com.pisight.everest.entities.DropDownList;
import com.pisight.everest.entities.DropDownType;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

public abstract class BaseService {
	
	@Autowired
	protected EverestDAO everestDAO = null;
	
	/*---------------------------------------- DropDowns-------------------------------------------------*/
	public JSONObject addDropDown(DropDownRequest request) {
		long start = System.currentTimeMillis();
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";

		try {
			String type = request.getDropdownType();
			List<DropDownList> dropDownList = request.getDropdownList();

			if (StringUtils.isEmpty(type)) {
				errorCode = 100;
				responseStatus = Constants.FAILED;
				responseMessage = "Invalid type";
			}

			DropDownType ddt = everestDAO.fetchDropDownTypeByName(type);

			if (ddt == null) {
				ddt = new DropDownType();
				ddt.setName(type);
			}

			everestDAO.saveDropDownType(ddt);

			for (DropDownList ddl : dropDownList) {
				DropDownList temp = everestDAO.fetchDropDownList(type, ddl.getValue());
				if (temp == null) {
					ddl.setType(ddt);
					everestDAO.saveDropDownList(ddl);
				} else {
					ScriptLogger.writeWarning(
							"Dropdown list already present for type => " + type + " with value => " + ddl.getValue());
				}
			}
			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Success";

		} catch (Exception e) {
			ScriptLogger.writeError("Error in adding Dropdown", e);
			errorCode = 100;
			responseStatus = Constants.FAILED;
			responseMessage = "Error in adding Dropdown";

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>addDropDown>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getDropDown(DropDownRequest request) {
		long start = System.currentTimeMillis();
		int errorCode = 100;
		String responseStatus = Constants.FAILED;
		String responseMessage = "Invalid type";
		List<DropDownList> responseList = null;

		try {
			String type = request.getDropdownType();
			DropDownType ddt = everestDAO.fetchDropDownTypeByName(type);

			if (ddt != null) {
				responseList = ddt.getDropDownList();
				
				errorCode = 0;
				responseStatus = Constants.SUCCESS;
				responseMessage = "Success";
			}
		} catch (Exception e) {
			ScriptLogger.writeInfo("Error in Get DropdownList", e);
			responseStatus = Constants.FAILED;
			responseMessage = "Error in Get DropdownList";

			JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			return response;
		}

		JSONObject response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
		response.put("list", responseList);

		long diff = System.currentTimeMillis() - start;
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>>>>>>>getDropDown>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ScriptLogger.writeInfo(">>>>>>>>>>>>>>>>Total time Taken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + diff);
		return response;

	}
	
	public JSONObject updateDropdownList(DropDownRequest request) {
		
		String type = request.getDropdownType();
		DropDownType ddt = everestDAO.fetchDropDownTypeByName(type);
		
		everestDAO.updateDropDownlist(ddt);
		return null;
	}

	public DropDownDTO convertDropDownListTodropDownDTO(DropDownList dropDownList) {

		DropDownDTO dropDownDTO = new DropDownDTO();
		if (dropDownList == null) {
			return null;
		} else {
			dropDownDTO.setDisplayText(dropDownList.getDisplayText());
			dropDownDTO.setValue(dropDownList.getValue());

			DropDownType dropDownType = new DropDownType();
			dropDownType.setName(dropDownList.getDisplayText());
			dropDownList.setType(dropDownType);
		}
		return dropDownDTO;
	}

	public DropDownList fetchDropdown(DropDownDTO ddl) {

		if (ddl != null) {
			return fetchDropdown(ddl.getType(), ddl.getValue());
		}
		return null;
	}

	public DropDownList fetchDropdown(String type, String value) {
		DropDownList ddl = null;

		ddl = everestDAO.fetchDropDownList(type, value);

		if (ddl == null) {
			ddl = new DropDownList();
			DropDownType ddt = everestDAO.fetchDropDownTypeByName(type);
			if (ddt == null) {
				ddt = new DropDownType();
				ddt.setName(type);
				everestDAO.saveDropDownType(ddt);
			}
			ddl.setType(ddt);
			ddl.setValue(value);
			ddl.setDisplayText(value);
			everestDAO.saveDropDownList(ddl);
		}
		return ddl;
	}

	/*----------------------------------------End DropDowns-------------------------------------------------*/
	
	
	public String generateRandomPassword() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		return generatedString;
	}

}
