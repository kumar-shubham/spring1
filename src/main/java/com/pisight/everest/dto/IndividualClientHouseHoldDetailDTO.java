package com.pisight.everest.dto;

import java.util.ArrayList;
import java.util.List;

public class IndividualClientHouseHoldDetailDTO {
	private String householdId;
	private String householdName;
	private String premium;
	
	List<IndividualClientHouseHoldMemberDTO> memberList=new ArrayList<>();

	public List<IndividualClientHouseHoldMemberDTO> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<IndividualClientHouseHoldMemberDTO> memberList) {
		this.memberList = memberList;
	}
	public String getHouseholdId() {
		return householdId;
	}
	public void setHouseholdId(String householdId) {
		this.householdId = householdId;
	}
	public String getHouseholdName() {
		return householdName;
	}
	public void setHouseholdName(String householdName) {
		this.householdName = householdName;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	
}
