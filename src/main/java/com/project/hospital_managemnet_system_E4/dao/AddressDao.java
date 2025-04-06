package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address UpdateAddressById(int addressId,Address newAddress) {
		newAddress.setAddressId(addressId);
		return addressRepo.save(newAddress);
	}
	
	public Address fetchAddressById(int addressId) {
		Optional<Address> address = addressRepo.findById(addressId);
		if (address.isEmpty()) {
			return null;
		} 
		else {
			return address.get();
		}
	}

	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
