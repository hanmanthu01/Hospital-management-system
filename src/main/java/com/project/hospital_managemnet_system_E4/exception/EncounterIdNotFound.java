package com.project.hospital_managemnet_system_E4.exception;

public class EncounterIdNotFound extends RuntimeException {
	
	private String message="encounter id not found in DB";
	
	public String getMessage() {
		return message;
	}

}
