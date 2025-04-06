package com.project.hospital_managemnet_system_E4.exception;

public class RoomIdNotFound extends RuntimeException {
	
	private String message="room id not found in Db";
	
	public String getMessage() {
		return message;
	}

}
