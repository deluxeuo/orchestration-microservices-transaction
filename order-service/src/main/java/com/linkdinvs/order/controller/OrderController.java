package com.linkdinvs.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkdinvs.order.payload.PlaceOrderRequest;
import com.linkdinvs.order.payload.PlaceOrderResponse;
import com.linkdinvs.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping()
	public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest request) {
		return orderService.createOrder(request);
	}
	
	@PostMapping("/compensate")
	public PlaceOrderResponse compensateOrder(@RequestBody OrderRequest req) {
		 orderService.compensateOrder(req.getOrderId());
		 PlaceOrderResponse response = new PlaceOrderResponse();
		 response.setMessage("Order Compensate request has placed");
		 return response;
	}

}
