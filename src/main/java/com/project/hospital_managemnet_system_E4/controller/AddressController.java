package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.service.AddressService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	
	
	@PostMapping("/saveAddress")
	public  ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@PutMapping("/UpdateAddressById")
	public ResponseEntity<ResponseStructure<Address>> UpdateAddressById(@RequestParam int addressId, @RequestBody Address newAddress) {
		
		return addressService.UpdateAddressById(addressId, newAddress);
	}
	
	@GetMapping("/fetchAddressById")
	public  ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}
	
	@DeleteMapping("/deleteAddressById")
	public  ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}
	
	@GetMapping("/fetchAllAddress")
	public List<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}
}
