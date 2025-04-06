package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.AddressDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class AddressService {
	
	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully address created in DB");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> UpdateAddressById(int addressId,Address newAddress) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully address Updated in DB");
		responseStructure.setData(addressDao.UpdateAddressById(addressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully address fetched in DB");
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			 throw new AddressIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully address deleted from DB");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	}
	public List<Address> fetchAllAddress() {
		return addressDao.fetchAllAddress();
	}

}
