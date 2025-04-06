package com.project.hospital_managemnet_system_E4.exception;

public class BranchHeadIdNotFound extends RuntimeException{

	private String message=" Branchhead id not found in DB";

	public String getMessage() {
		return message;
	}
}
