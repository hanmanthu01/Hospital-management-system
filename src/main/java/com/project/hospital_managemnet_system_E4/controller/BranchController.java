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

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.service.BranchService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {

	
	@Autowired
	BranchService branchService;
	@Operation(summary = "Save Branch", description = "API is used to save the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>>  saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	@PutMapping("/UpdateBrachById")
	public ResponseEntity<ResponseStructure<Branch>>  UpdateBrachById(@RequestParam int oldBranchId,@RequestBody Branch newBranch)
	{
		return branchService.UpdateBrachById(oldBranchId, newBranch);
	}
	@GetMapping("/fetchBranchbyId")
	public ResponseEntity<ResponseStructure<Branch>>  fetchBranchbyId(@RequestParam int branchId) {
		return branchService.fetchBranchbyId(branchId); 
	}
	@DeleteMapping("/deleteBranchbyId")
	public ResponseEntity<ResponseStructure<Branch>>  deleteBranchbyId(@RequestParam int branchId) {
		return branchService.deleteBranchbyId(branchId);
	}
	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch(){
		return branchService.fetchAllBranch();
	}
	@PutMapping("/addExistingBranchToExistingAddress")
	public Branch addExistingBranchToExistingAddress(@RequestParam int branchId,@RequestParam int addressId) {
		return branchService.addExistingBranchToExistingAddress(branchId,addressId);
	}
	@PutMapping("/addNewAddressToExistingBranch")
	public Branch addNewAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address newAddress) {
		return branchService.addNewAddressToExistingBranch(branchId, newAddress);
	}
	@PutMapping("/addExistingBranchToExistingBranchHead")
	public Branch addExistingBranchToExistingBranchHead(@RequestParam int branchId,@RequestParam int branchHeadId) {
		return branchService.addExistingBranchToExistingBranchHead(branchId, branchHeadId);
	}
	@PutMapping("/addNewBranchHeadToExistingBranch")
	public Branch addNewBranchHeadToExistingBranch(@RequestParam int branchId,@RequestBody BranchHead newbranchHead) {
		return branchService.addNewBranchHeadToExistingBranch(branchId, newbranchHead);
	}
	@PutMapping("/addExistingPatientToExistingBranch")
	public Branch addExistingPatientToExistingBranch(@RequestParam int branchId,@RequestParam int patientId) {
		return branchService.addExistingPatientToExistingBranch(branchId,patientId);
	}
	@PutMapping("/addNewPatientToExistingBranch")
	public Branch addNewPatientToExistingBranch(@RequestParam int branchId,@RequestBody Patient newPatient) {
		return branchService.addNewPatientToExistingBranch(branchId, newPatient);
	}
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public Branch addExistingEmployeeToExistingBranch(@RequestParam int branchId,@RequestParam int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId,employeeId);
	}
	@PutMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId,newEmployee);
	}

}

