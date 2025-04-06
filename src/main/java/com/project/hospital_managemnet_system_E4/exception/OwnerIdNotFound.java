package com.project.hospital_managemnet_system_E4.exception;

public class OwnerIdNotFound extends RuntimeException{
	
	private String message="OWNERId not found in the DB";
	
	public String getMessage() {
		return message;
	}

}
