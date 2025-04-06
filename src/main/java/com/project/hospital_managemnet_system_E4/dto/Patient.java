package com.project.hospital_managemnet_system_E4.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private int patientAge;
	private String patientGender;
	private String patientEmail;
	private long patientPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Report report;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Encounter> encounter;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Payment> payment;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Medicine> medicine;
	
	public List<Medicine> getMedicine() {
		return medicine;
	}
	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public List<Encounter> getEncounter() {
		return encounter;
	}
	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public long getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}	

}
