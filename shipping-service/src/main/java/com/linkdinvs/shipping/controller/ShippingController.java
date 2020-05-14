package com.linkdinvs.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkdinvs.shipping.service.ShippingService;

@RestController
public class ShippingController {

	@Autowired
	private ShippingService shippingService;

	@PostMapping
	public ResponseEntity<String> processShippment(@RequestBody OrderRequest req) {
		shippingService.processShippment(req.getOrderId());
		return new ResponseEntity<>("request placed for shippment", HttpStatus.OK);
	}

}
