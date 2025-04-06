package com.project.hospital_managemnet_system_E4.exception;

public class MedicineIdNotFound  extends RuntimeException{
	
	private String message="medicine Id not found in DB";
	
	public String getMessgae() {
		return message;
	}

}
