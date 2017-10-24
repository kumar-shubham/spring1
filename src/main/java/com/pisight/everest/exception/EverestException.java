package com.pisight.everest.exception;

public class EverestException extends Exception {
	
	private static final long serialVersionUID = 9090457508984368302L;
	
	private static final int ERROR_CODE = 100;
	
	public EverestException(String message){
		super(message);
	}
	
	public int getErrorCode(){
		return ERROR_CODE;
	}

}
