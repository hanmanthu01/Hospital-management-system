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

import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.service.EncounterService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class EncounterController {

	
	@Autowired
	EncounterService encounterService;
	
	@Operation(summary = "Save Encounter", description = "API is used to save the Encounter")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Encounter not found for the given id") })
	
@PostMapping("/saveEncounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter) {
		return encounterService.saveEncounter(encounter);
	}
@PutMapping("/updateEncounterById")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(@RequestParam int oldEncounterId,@RequestBody Encounter newEncounter) {

		return encounterService.updateEncounterById(oldEncounterId, newEncounter);
	}
@GetMapping("/fetchEncounterById")
	public ResponseEntity<ResponseStructure<Encounter>> fetchEncounterById(@RequestParam int encounterId) {
		return encounterService.fetchEncounterById(encounterId);
	}
@DeleteMapping("/deleteEncounterById")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(@RequestParam int encounterId) {

		return encounterService.deleteEncounterById(encounterId);
	}
@GetMapping("/fetchAllEncounter")
	public List<Encounter> fetchAllEncounter() {
	return encounterService.fetchAllEncounter();
	}
}
