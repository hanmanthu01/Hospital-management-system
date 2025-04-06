package com.project.hospital_managemnet_system_E4.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> AddressIdNotFound(AddressIdNotFound addressIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> BranchIdNotFound(BranchIdNotFound branchIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchHeadIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> BranchHeadIdNotFound(BranchHeadIdNotFound branchHeadIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(branchHeadIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> EmployeeIdNotFound(EmployeeIdNotFound employeeIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(employeeIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EncounterIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> EncounterIdNotFound(EncounterIdNotFound encounterIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(encounterIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(HospitalIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> HospitalIdNotFound(HospitalIdNotFound hospitalIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(hospitalIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MedicineIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> MedicineIdNotFound(MedicineIdNotFound medicineIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(medicineIdNotFound.getMessgae());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PatientIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> PatientIdNotFound(PatientIdNotFound patientIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(patientIdNotFound.getMessgae());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> PaymentIdNotFound(PaymentIdNotFound paymentIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ReportIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ReportIdNotFound(ReportIdNotFound reportIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(reportIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RoomIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> RoomIdNotFound(RoomIdNotFound roomIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(roomIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}


	
}
