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
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.service.PatientService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@Operation(summary = "Save Patient", description = "API is used to save the Patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	
	@PostMapping("/savePatient")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@PutMapping("/updatePatientById")
	public ResponseEntity<ResponseStructure<Patient>> updatePatientById (@RequestParam int oldPatientId,@RequestBody Patient newPatient) {

		return patientService.updatePatientById(oldPatientId, newPatient);
	}

	@GetMapping("/fetchPatientById")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@RequestParam int patientId) {
		return patientService.fetchPatientById(patientId);
	}

	@DeleteMapping("/deletePatientById")
	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(@RequestParam int patientId) {
		return patientService.deletePatientById(patientId);
	}

	@GetMapping("/fetchAllPatient")
	public List<Patient> fetchAllPatient() {
		return patientService.fetchAllPatient();
	}
	
	@PutMapping("/addExistingReportToExistingPatient")
	public Patient addExistingReportToExistingPatient(@RequestParam int patientId ,@RequestParam int reportId) {
		return patientService.addExistingReportToExistingPatient(patientId,reportId);
	}

	@PutMapping("/addNewReportToExistingPatient")
	public Patient addNewReportToExistingPatient (@RequestParam int patientId,@RequestBody Report newReport) {
		return patientService.addNewReportToExistingPatient(patientId,newReport);
	}
	
	@PutMapping("/addExistingEncounterToExitsingPatient")
	public Patient addExistingEncounterToExitsingPatient(@RequestParam int patientId,@RequestParam int encounterId) {
		return patientService.addExistingEncounterToExitsingPatient(patientId, encounterId);
	}
	
	@PutMapping("/addNewEncounterToExistingPatient")
	public Patient addNewEncounterToExistingPatient(@RequestParam int patientId,@RequestBody Encounter newEncounter) {
		return patientService.addNewEncounterToExistingPatient(patientId, newEncounter);
	}
	
	@PutMapping("/addExistingPaymentToExistingPatient")
	public Patient addExistingPaymentToExistingPatient(@RequestParam int patientId,@RequestParam int paymentId) {
		return patientService.addExistingPaymentToExistingPatient(patientId, paymentId);
	}
	
	@PutMapping("/addNewPaymentToExistingPatient")
	public Patient addNewPaymentToExistingPatient(@RequestParam int patientId,@RequestBody Payment newPayment) {
		return patientService.addNewPaymentToExistingPatient(patientId, newPayment);
	}
	@PutMapping("/addExistingMedicineToExistingPatient")
	public Patient addExistingMedicineToExistingPatient(@RequestParam int patientId,@RequestParam int medicineId) {
		return patientService.addExistingMedicineToExistingPatient(patientId, medicineId);
	}
	@PutMapping("/addNewMedicineToExistingPatient")
	public Patient addNewMedicineToExistingPatient(@RequestParam int patientId,@RequestBody Medicine newMedicine) {
		return patientService.addNewMedicineToExistingPatient(patientId, newMedicine);
	}
}
