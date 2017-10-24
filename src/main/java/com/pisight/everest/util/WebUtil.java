package com.pisight.everest.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pisight.everest.constants.Constants;
import com.pisight.everest.service.EverestServiceImpl;


@Service
public class WebUtil {

	private static Logger logger = Logger.getLogger(WebUtil.class);

	@Autowired
	private EverestServiceImpl everestServiceImpl = null;
	
	private static EverestServiceImpl everestServiceImplStatic = null;
	
	@PostConstruct
	public void init() {
		everestServiceImplStatic = everestServiceImpl;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject getResponse(int errorCode, String responseStatus, String responseMessage) {
		// TODO Auto-generated method stub

		JSONObject response = new JSONObject();
		response.put(Constants.ERROR_CODE_STRING, errorCode);
		response.put(Constants.RESPONSE_STATUS_STRING, responseStatus);
		response.put(Constants.RESPONSE_MESSAGE_STRING, responseMessage);
		return response;
	}


	/**
	 * This method converts the given date String to the Pimoney Format.
	 * This method requires format of the date string passed.
	 * 
	 * @param oldDate
	 * @param format
	 * @return formated date string
	 * @throws ParseException
	 */
	public static String convertToPimoneyDate(String oldDate, String format) throws ParseException{

		logger.info("inside convertDateStringToPimoneyFormat with date string :: " + oldDate + " and format :: " + format);

		if(StringUtils.isEmpty(oldDate)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Date date = sdf.parse(oldDate);

		sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(date);
	}


	/**
	 * Watson is always here for you even if you don't have the date format with you.
	 * This method also converts the given date String to the Pimoney Format.
	 * It does not requires date format for the date String. It matches with the predefined set
	 * of format defined in the Constants.java class
	 * 
	 * @param dateString
	 * @return formated date string
	 * @throws EverestException
	 */
	public static String convertToPimoneyDate(String dateString) throws Exception{

		logger.info("inside convertDateStringToPimoneyFormat with only date string :: " + dateString);
		Date newDate = null;
		int failureCount = 0;

		if(StringUtils.isEmpty(dateString)){
			return null;
		}
		SimpleDateFormat sdf = null;
		if (dateString != null) {
			for (String parse : Constants.dateFormatList) {
				sdf = new SimpleDateFormat(parse);
				try {
					newDate = sdf.parse(dateString);
					break;
				} catch (ParseException e) {
					failureCount++;
				}
			}
		}

		if(failureCount == Constants.dateFormatList.size()){
			logger.error("Date Format for the date string " + dateString + " is not in the supported dateList");
			throw new Exception("Date Format for the date string " + dateString + " is not in the supported dateList");
		}

		if(newDate != null){
			sdf = new SimpleDateFormat(Constants.DATEFORMAT_YYYY_DASH_MM_DASH_DD);
			return sdf.format(newDate);
		}
		else{
			logger.error("error in parsing date " + dateString);
			throw new Exception("error in parsing date");
		}

	}


	public static String formatDate1(String dateString, String format) throws ParseException{

		logger.info("converting data string to yyyyMMdd");
		logger.info("inside formatDate1 with date string :: " + dateString + " and format :: " + format);
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Date date = sdf.parse(dateString);

		sdf = new SimpleDateFormat("yyyyMMdd");

		return sdf.format(date);
	}

	public static String formatAmount(String amount){
		if(amount == null){
			return null;
		}

		return amount.replace(",", "");
	}

	
	public static String getConfigValue(String key, String value) {
		return everestServiceImplStatic.getConfigurationValue(key, value);
	}
	
	public static JSONObject convertToJSONObject(String string) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(string, JSONObject.class);
	}

	public static String convertToJSON(Object object) throws JsonProcessingException{
		logger.info("converting to JSON");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
	
	public static Date convertToDate(String date) throws ParseException {
		
		if(StringUtils.isEmpty(date) || date.equalsIgnoreCase("tbd")) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATEFORMAT_YYYY_MM_DD);
		
		return sdf.parse(date);
		
	}
	
	public static void writeFile(String filepath, String output) throws FileNotFoundException, IOException{
		FileWriter ofstream = new FileWriter(filepath);
		try (BufferedWriter out = new BufferedWriter(ofstream)) {
			out.write(output);
		}
	}

}
