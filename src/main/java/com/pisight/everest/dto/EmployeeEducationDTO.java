package com.pisight.everest.dto;

import java.sql.Date;
import java.util.UUID;

public class EmployeeEducationDTO {
	
	private UUID id;

	private String instituteName;
	
	private String programOrDegree;
	
	private String specialisation;
	
	private Date fromDate;
	
	private Date toDate;
	
	private boolean persuing;
	
	private boolean status;
	
	

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the instituteName
	 */
	public String getInstituteName() {
		return instituteName;
	}

	/**
	 * @param instituteName the instituteName to set
	 */
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	/**
	 * @return the programOrDegree
	 */
	public String getProgramOrDegree() {
		return programOrDegree;
	}

	/**
	 * @param programOrDegree the programOrDegree to set
	 */
	public void setProgramOrDegree(String programOrDegree) {
		this.programOrDegree = programOrDegree;
	}

	/**
	 * @return the specialisation
	 */
	public String getSpecialisation() {
		return specialisation;
	}

	/**
	 * @param specialisation the specialisation to set
	 */
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the persuing
	 */
	public boolean isPersuing() {
		return persuing;
	}

	/**
	 * @param persuing the persuing to set
	 */
	public void setPersuing(boolean persuing) {
		this.persuing = persuing;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
