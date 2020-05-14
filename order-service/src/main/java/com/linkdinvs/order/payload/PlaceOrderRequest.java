package com.linkdinvs.order.payload;

public class PlaceOrderRequest {
	
	private Long itemId;
	private Long customerId;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
