package com.linkdinvs.order.payload;

public class PlaceOrderResponse {
	
	private Long orderId;
	private String message;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
