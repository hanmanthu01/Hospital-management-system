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

import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.service.BranchHeadService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class BranchHeadController {

		@Autowired
		BranchHeadService branchHeadService;
		
		@Operation(summary = "Save BranchHead", description = "API is used to save the BranchHead")
		@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
				@ApiResponse(responseCode = "404", description = "BranchHead not found for the given id") })
		
		@PostMapping("/saveBranchHead")
		public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead)  {
			return branchHeadService.saveBranchHead(branchHead);
		}
		@PutMapping("/updateBranchHeadById")
		public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(@RequestParam int oldBranchHeadId,@RequestBody BranchHead newBranchHead) {
			return branchHeadService.updateBranchHeadById(oldBranchHeadId, newBranchHead);
		}
		@GetMapping("/fetchBranchHeadById")
		public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(@RequestParam int branchHeadId) {
			return branchHeadService.fetchBranchHeadById(branchHeadId);
		}
		@DeleteMapping("/deleteBranchHeadById")
		public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(@RequestParam int branchHeadId) {
			return branchHeadService.deleteBranchHeadById(branchHeadId);
			
		}
		@GetMapping("/fetchAllBranchHead")
		public List<BranchHead> fetchAllBranchHead(){
			return branchHeadService.fetchAllBranchHead();
		}
}
