package com.project.hospital_managemnet_system_E4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_managemnet_system_E4.dto.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
