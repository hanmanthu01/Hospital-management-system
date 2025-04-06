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

import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.service.PaymentService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class PaymentController {

	
	@Autowired
	PaymentService paymentService;

	@Operation(summary = "Save Payment", description = "API is used to save the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	
	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}

	@PutMapping("/updatePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById (@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {

		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}

	@GetMapping("/fetchPaymentById")
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}

	@DeleteMapping("/deletePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(@RequestParam int paymentId) {

		return paymentService.deletePaymentById(paymentId);
	}

	@GetMapping("/fetchAllPayment")
	public List<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}
}
