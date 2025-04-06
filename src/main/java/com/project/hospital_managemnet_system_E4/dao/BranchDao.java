package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	BranchHeadDao branchHeadDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	EmployeeDao employeeDao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	public Branch UpdateBrachById(int oldBranchId, Branch newBranch)
	{
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}
	public Branch fetchBranchbyId(int branchId) {
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isEmpty()) {
			return null;
		} 
		else {
			return branch.get();
		}
	}
	public Branch deleteBranchbyId(int branchId) {
		Branch branch = fetchBranchbyId(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	public List<Branch> fetchAllBranch(){
		return branchRepo.findAll();
	}
	
	public Branch addExistingBranchToExistingAddress(int branchId, int addressId) {
		Branch branch=fetchBranchbyId(branchId);
		Address address= addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addNewAddressToExistingBranch(int branchId, Address newAddress) {
		Branch branch=fetchBranchbyId(branchId);
		Address address= addressDao.saveAddress(newAddress);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingBranchHead(int branchId, int branchHeadId) {
		Branch branch=fetchBranchbyId(branchId);
		BranchHead branchHead= branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	public Branch addNewBranchHeadToExistingBranch(int branchId, BranchHead newbranchHead) {
		Branch branch=fetchBranchbyId(branchId);
		BranchHead branchHead= branchHeadDao.saveBranchHead(newbranchHead);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	public Branch addExistingPatientToExistingBranch(int branchId,int patientId) {
		Branch branch=fetchBranchbyId(branchId);
		Patient patient = patientDao.fetchPatientById(patientId);
		List<Patient>list= branch.getPatient();
		list.add(patient);
		branch.setPatient(list);
		return saveBranch(branch);
	}
	public Branch addNewPatientToExistingBranch(int branchId,Patient newPatient) {
		Branch branch = fetchBranchbyId(branchId);
		List <Patient> list = branch.getPatient();
		list.add(newPatient);
		branch.setPatient(list);
		return saveBranch(branch);
	}
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		Branch branch = fetchBranchbyId(branchId);
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		List<Employee>list =branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		Branch branch=fetchBranchbyId(branchId);
		List<Employee> list=branch.getEmployee();
		list.add(newEmployee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
}
