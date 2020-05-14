package com.linkdinvs.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkdinvs.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping
	public ResponseEntity<String> fetchItem(@RequestBody OrderRequest request) {
		inventoryService.fetchItem(request.getOrderId());
		return new ResponseEntity<>("request placed for item", HttpStatus.OK);
	}

	@PostMapping("/compensate")
	public ResponseEntity<String> compensateOrder(@RequestBody  OrderRequest request) {
		inventoryService.compensateItem(request.getOrderId());
		return new ResponseEntity<>("request placed for item compensate", HttpStatus.OK);
	}

}
