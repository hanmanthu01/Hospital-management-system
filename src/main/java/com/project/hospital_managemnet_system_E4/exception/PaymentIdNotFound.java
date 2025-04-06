package com.project.hospital_managemnet_system_E4.exception;

public class PaymentIdNotFound extends RuntimeException {
	
	private String message="payment id not found in DB";
	
	public String getMessage() {
		return message;
	}

}
