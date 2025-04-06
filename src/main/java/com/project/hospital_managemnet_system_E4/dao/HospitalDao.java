package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.repo.HospitalRepo;

@Repository
public class HospitalDao {

	@Autowired 
	HospitalRepo hospitalRepo;
	@Autowired
	BranchDao branchDao;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}
	
	public Hospital updateHospitalbyId(int oldHospitalId, Hospital newHospital ) {
		newHospital.setHospitalId(oldHospitalId);
		return hospitalRepo.save(newHospital);
	}
	
	public Hospital fetchHospitalById(int hospitalId) {
		Optional<Hospital> hospital = hospitalRepo.findById(hospitalId);
		if(hospital.isEmpty()) {
			return null;
		}
		else {
			return hospital.get();
		}
	}
	
	public Hospital deleteHospitalById(int hosptialId) {
		Hospital hospital= fetchHospitalById(hosptialId);
		hospitalRepo.delete(hospital);
		return hospital;
	}
	public List<Hospital> fetchAllHospital(){
		return hospitalRepo.findAll();
	}
	
	public Hospital addExistingBranchToExistingHospital(int hospitalId, int branchId) {
		Hospital hospital = fetchHospitalById(hospitalId);
		Branch branch = branchDao.fetchBranchbyId(branchId);
		List<Branch> list = hospital.getBranches();

		list.add(branch);
		hospital.setBranches(list);
		return saveHospital(hospital);
	}
	
	public Hospital addNewBranchToExistingHospital(int hospitalId, Branch newBranch) {
		Hospital hospital = fetchHospitalById(hospitalId);
		List<Branch> list = hospital.getBranches();
		list.add(newBranch);
		hospital.setBranches(list);
		return saveHospital(hospital);
	}
}
