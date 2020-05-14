package com.linkdinvs.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkdinvs.payment.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<String> makePayment(@RequestBody OrderRequest req) {
		paymentService.makePayment(req.getOrderId());
		return new ResponseEntity<>("request placed for payment", HttpStatus.OK);
	}

}
