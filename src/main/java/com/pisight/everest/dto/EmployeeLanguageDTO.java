package com.pisight.everest.dto;

import java.util.UUID;

public class EmployeeLanguageDTO {
	
	private UUID id;

	private String language;
	
	private DropDownDTO proficiency;
	

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
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the proficiency
	 */
	public DropDownDTO getProficiency() {
		return proficiency;
	}

	/**
	 * @param proficiency the proficiency to set
	 */
	public void setProficiency(DropDownDTO proficiency) {
		this.proficiency = proficiency;
	}
	
	
	
}
