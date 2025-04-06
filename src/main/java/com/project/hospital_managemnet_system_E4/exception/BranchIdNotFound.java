package com.project.hospital_managemnet_system_E4.exception;

public class BranchIdNotFound extends RuntimeException{
	
	private String message="Branch ID not found in DB";

	public String getMessage() {
		return message;
	}
}
