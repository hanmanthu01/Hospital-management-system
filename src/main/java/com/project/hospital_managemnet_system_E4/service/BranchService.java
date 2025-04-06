package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.BranchDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully branch created in DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> UpdateBrachById(int oldBranchId, Branch newBranch)
	{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully branch updated in DB");
		responseStructure.setData(branchDao.UpdateBrachById(oldBranchId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchbyId(int branchId) {
		Branch branch=branchDao.fetchBranchbyId(branchId);
		if(branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully branch fetched from DB");
			responseStructure.setData(branchDao.fetchBranchbyId(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new BranchIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchbyId(int branchId) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully branch deleted in DB");
			responseStructure.setData(branchDao.deleteBranchbyId(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public List<Branch> fetchAllBranch(){
		return branchDao.fetchAllBranch();
	}
	
	public Branch addExistingBranchToExistingAddress(int branchId, int addressId) {
		
		return branchDao.addExistingBranchToExistingAddress(branchId,addressId);
	}
	
	public Branch addNewAddressToExistingBranch(int branchId, Address newAddress) {
		return branchDao.addNewAddressToExistingBranch(branchId, newAddress);
	}
	
	public Branch addExistingBranchToExistingBranchHead(int branchId, int branchHeadId) {
		return branchDao.addExistingBranchToExistingBranchHead(branchId, branchHeadId);
		
	}
	
	public Branch addNewBranchHeadToExistingBranch(int branchId, BranchHead newbranchHead) {
		return branchDao.addNewBranchHeadToExistingBranch(branchId, newbranchHead);
	}
	
	public Branch addExistingPatientToExistingBranch(int branchId,int patientId) {
		return branchDao.addExistingPatientToExistingBranch(branchId,patientId);
	}
	
	public Branch addNewPatientToExistingBranch(int branchId,Patient newPatient) {
		return branchDao.addNewPatientToExistingBranch( branchId, newPatient);
	}

	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		return branchDao.addExistingEmployeeToExistingBranch(branchId,employeeId);
	}
	
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		return branchDao.addNewEmployeeToExistingBranch(branchId,newEmployee);
	}
}
