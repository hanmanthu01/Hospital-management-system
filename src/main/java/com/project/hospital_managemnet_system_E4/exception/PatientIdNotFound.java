package com.project.hospital_managemnet_system_E4.exception;

public class PatientIdNotFound extends RuntimeException {
	
	private String message="patient id not found in DB";
	
	public String getMessgae() {
		return message;
	}

}
