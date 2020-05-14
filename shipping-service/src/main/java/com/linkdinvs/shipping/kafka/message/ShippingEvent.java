package com.linkdinvs.shipping.kafka.message;

public class ShippingEvent {
	
	private Long orderId;
	private Action action;
	
	public static enum Action {
		GOODSSHIPPED
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
