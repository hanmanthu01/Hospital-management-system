package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.PaymentDao;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.exception.PaymentIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	ResponseStructure<Payment>responseStructure ;
	
	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully patient created in DB");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(int oldPaymentId, Payment newPayment) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully patient updated in DB");
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if(payment!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully patient fetched in DB");
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully patient deleted in DB");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure,HttpStatus.OK);
	}

	public List<Payment> fetchAllPayment() {
		return paymentDao.fetchAllPayment();
	}
}
