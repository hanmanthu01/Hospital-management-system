package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.PatientDao;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.exception.PatientIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;



@Service
public class PatientService {

	@Autowired
	PatientDao patientDao;
	@Autowired
	ResponseStructure<Patient>responseStructure ;
	
	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully patient created in DB");
		responseStructure.setData(patientDao.savePatient(patient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(int oldPatientId, Patient newPatient) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully patient updated in DB");
		responseStructure.setData(patientDao.updatePatientById(oldPatientId, newPatient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(int patientId) {
		Patient patient=patientDao.fetchPatientById(patientId);
		if(patient!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully patient fetched from DB");
			responseStructure.setData(patientDao.fetchPatientById(patientId));
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new PatientIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(int patientId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully patient deleted from DB");
		responseStructure.setData(patientDao.deletePatientById(patientId));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}

	public List<Patient> fetchAllPatient() {
		return patientDao.fetchAllPatient();
	}
	
	public Patient addExistingReportToExistingPatient(int patientId , int reportId) {
		return patientDao.addExistingReportToExistingPatient(patientId,reportId);
	}

	public Patient addNewReportToExistingPatient (int patientId, Report newReport) {
		return patientDao.addNewReportToExistingPatient(patientId,newReport);
	}
	public Patient addExistingEncounterToExitsingPatient(int patientId,int encounterId) {
		return patientDao.addExistingEncounterToExitsingPatient(patientId, encounterId);
	}
	public Patient addNewEncounterToExistingPatient(int patientId,Encounter newEncounter) {
		return patientDao.addNewEncounterToExistingPatient(patientId, newEncounter);
	}
	public Patient addExistingPaymentToExistingPatient(int patientId,int paymentId) {
		return patientDao.addExistingPaymentToExistingPatient(patientId, paymentId);
	}
	public Patient addNewPaymentToExistingPatient(int patientId,Payment newPayment) {
		return patientDao.addNewPaymentToExistingPatient(patientId, newPayment);
	}
	public Patient addExistingMedicineToExistingPatient(int patientId,int medicineId) {
		return patientDao.addExistingMedicineToExistingPatient(patientId, medicineId);
	}
	public Patient addNewMedicineToExistingPatient(int patientId, Medicine newMedicine) {
		return patientDao.addNewMedicineToExistingPatient(patientId, newMedicine);
	}


}
