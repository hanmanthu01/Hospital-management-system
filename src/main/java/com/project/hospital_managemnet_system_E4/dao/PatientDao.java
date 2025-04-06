package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.repo.PatientRepo;


@Repository
public class PatientDao {

	@Autowired
	 PatientRepo patientRepo;
	@Autowired
	ReportDao reportDao;
	@Autowired
	EncounterDao encounterDao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	MedicineDao medicineDao;
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	public Patient updatePatientById(int oldPatientId, Patient newPatient) {
		newPatient.setPatientId(oldPatientId);
	//	return PatientRepo.save(newPatient);
		return savePatient(newPatient);
	}
	
	public Patient fetchPatientById(int patientId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		if(patient.isEmpty()) {
			return null;
		}
		else {
			return patient.get();
		}
	}
	
	public Patient deletePatientById(int patientId) {
	//	Patient Patient=PatientRepo.findById(PatientId).get();
		Patient Patient=fetchPatientById(patientId);
		patientRepo.delete(Patient);
		return Patient;
	}
	
	public List<Patient> fetchAllPatient(){
		return patientRepo.findAll();
	}
	
	public Patient addExistingReportToExistingPatient(int patientId , int reportId) {
		Patient patient=fetchPatientById(patientId);
		Report report = reportDao.fetchReportById(reportId);
		patient.setReport(report);
		return savePatient(patient);
	}
	
	public Patient addNewReportToExistingPatient (int patientId, Report newReport) {
		Patient patient=fetchPatientById(patientId);
		Report report = reportDao.saveReport(newReport);
		patient.setReport(report);
		return savePatient(patient);
	}
	
	public Patient addExistingEncounterToExitsingPatient(int patientId,int encounterId) {
		Patient patient=fetchPatientById(patientId);
		Encounter encounter=encounterDao.fetchEncounterById(encounterId);
		List<Encounter>list=patient.getEncounter();
		list.add(encounter);
		patient.setEncounter(list);
		return savePatient(patient);
	}
	public Patient addNewEncounterToExistingPatient(int patientId,Encounter newEncounter) {
		Patient patient = fetchPatientById(patientId);
		List<Encounter>list = patient.getEncounter();
		list.add(newEncounter);
		patient.setEncounter(list);
		return savePatient(patient);
	}
	public Patient addExistingPaymentToExistingPatient(int patientId,int paymentId) {
		Patient patient=fetchPatientById(patientId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		List<Payment>list=patient.getPayment();
		list.add(payment);
		patient.setPayment(list);
		return savePatient(patient);
	}
	public Patient addNewPaymentToExistingPatient(int patientId,Payment newPayment) {
		Patient patient=fetchPatientById(patientId);
		List<Payment> list = patient.getPayment();
		list.add(newPayment);
		patient.setPayment(list);
		return savePatient(patient);
	}
	public Patient addExistingMedicineToExistingPatient(int patientId,int medicineId) {
		Patient patient = fetchPatientById(patientId);
		Medicine medicine=medicineDao.fetchMedicineById(medicineId);
		List<Medicine>list = patient.getMedicine();
		list.add(medicine);
		patient.setMedicine(list);
		return savePatient(patient);
	}
	public Patient addNewMedicineToExistingPatient(int patientId, Medicine newMedicine) {
		Patient patient = fetchPatientById(patientId);
		List<Medicine> list =patient.getMedicine();
		list.add(newMedicine);
		patient.setMedicine(list);
		return savePatient(patient);
	}
}
