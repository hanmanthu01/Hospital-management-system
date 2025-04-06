package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.EmployeeDao;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.exception.EmployeeIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;


@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully employee created in DB");
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);
	}

	public  ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int oldemployeeId, Employee newemployee) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully employee updated in DB");
		responseStructure.setData(employeeDao.updateEmployeeById(oldemployeeId, newemployee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
		
	}

	public  ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if(employee!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully employee fetched in DB");
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new EmployeeIdNotFound();	
		}	
	}

	public  ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully employee deleted in DB");
		responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
			}

	public List<Employee> fetchAllemployee() {
		return employeeDao.fetchAllEmployee();
	}
}
