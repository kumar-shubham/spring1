package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;

import com.pisight.everest.entities.DropDownList;

public class DropDownRequest {
	
	private String dropdownType;
	
	private List<DropDownList> dropdownList = new ArrayList<DropDownList>();

	/**
	 * @return the dropdownType
	 */
	public String getDropdownType() {
		return dropdownType;
	}

	/**
	 * @param dropdownType the dropdownType to set
	 */
	public void setDropdownType(String dropdownType) {
		this.dropdownType = dropdownType;
	}

	/**
	 * @return the dropdownList
	 */
	public List<DropDownList> getDropdownList() {
		return dropdownList;
	}

	/**
	 * @param dropdownList the dropdownList to set
	 */
	public void setDropdownList(List<DropDownList> dropdownList) {
		this.dropdownList = dropdownList;
	}

}
