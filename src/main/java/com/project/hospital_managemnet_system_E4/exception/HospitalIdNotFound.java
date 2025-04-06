package com.project.hospital_managemnet_system_E4.exception;

public class HospitalIdNotFound extends RuntimeException {
	
	private String message="hospital Id not found in DB";

	public String getMessage() {
		return message;
	}
	
	
}
