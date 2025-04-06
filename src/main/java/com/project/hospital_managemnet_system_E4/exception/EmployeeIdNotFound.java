package com.project.hospital_managemnet_system_E4.exception;

public class EmployeeIdNotFound extends RuntimeException {
	
	private String message="Empoyee idnot found in DB";

	public String getMessage() {
		return message;
	}
}
