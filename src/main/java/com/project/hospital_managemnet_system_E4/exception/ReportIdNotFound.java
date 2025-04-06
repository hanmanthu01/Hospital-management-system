package com.project.hospital_managemnet_system_E4.exception;

public class ReportIdNotFound extends RuntimeException{
	
	private String message="report id not found in DB";
	
	public String getMessage() {
		return message;
	}

}
