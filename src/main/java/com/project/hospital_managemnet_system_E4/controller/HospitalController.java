package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.service.HospitalService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class HospitalController{
	
	@Autowired
	HospitalService hospitalService;
	
	@Operation(summary = "Save Hospital", description = "API is used to save the Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital Hospital) {
		return hospitalService.saveHospital(Hospital);
	}

	@PutMapping("/updateHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById (@RequestParam int oldHospitalId,@RequestBody Hospital newHospital) {
		return hospitalService.updateHospitalbyId(oldHospitalId, newHospital);
	}

	@GetMapping("/fetchHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(@RequestParam int hospitalId) {
		return hospitalService.fetchHospitalById(hospitalId);
	}

	@DeleteMapping("/deleteHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@RequestParam int hospitalId) {
		return hospitalService.deleteHospitalById(hospitalId);
	}

	@GetMapping("/fetchAllHospital")
	public List<Hospital> fetchAllHospital() {
		return hospitalService.fetchAllHospital();
		
	}
	@PutMapping("/addExistingBranchToExistingHospital")
	public Hospital addExistingBranchToExistingHospital(@RequestParam int hospitalId,@RequestParam int branchId) {
		return hospitalService.addExistingBranchToExistingHospital(hospitalId, branchId);
	}
	@PutMapping("/addNewBranchToExistingHospital")
	public Hospital addNewBranchToExistingHospital(@RequestParam int hospitalId,@RequestBody Branch newBranch) {
		return hospitalService.addNewBranchToExistingHospital(hospitalId, newBranch);
	}

}
	