package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.HospitalDao;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class HospitalService {

	@Autowired
	HospitalDao hospitalDao;
	@Autowired
	ResponseStructure<Hospital> responseStructure;
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully hospital created in DB");
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalbyId(int oldHospitalId, Hospital newHospital ) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully hospital updated in DB");
		responseStructure.setData(hospitalDao.updateHospitalbyId(oldHospitalId, newHospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);	}
	
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(int hospitalId) {
		Hospital hospital = hospitalDao.fetchHospitalById(hospitalId);
		if(hospital != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully hospital fetched from DB");
			responseStructure.setData(hospitalDao.fetchHospitalById(hospitalId));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new HospitalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int hosptialId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully hospital deleted from DB");
		responseStructure.setData(hospitalDao.deleteHospitalById(hosptialId));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);		
	}
	
	public List<Hospital> fetchAllHospital(){
		return hospitalDao.fetchAllHospital();
	}
	
	public Hospital addExistingBranchToExistingHospital(int hospitalId, int branchId) {
		return hospitalDao.addExistingBranchToExistingHospital(hospitalId, branchId);
	}
	
	public Hospital addNewBranchToExistingHospital(int hospitalId, Branch newBranch) {
		return hospitalDao.addNewBranchToExistingHospital(hospitalId, newBranch);
	}

}
