package com.linkdinvs.notification.kafka.message;

public class OrderEvent {
	
	private Long orderId;
	private OrderAction action;
	
	public static enum OrderAction {
		ORDERPLACED,
		ORDERNOTPLACED
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public OrderAction getAction() {
		return action;
	}
	public void setAction(OrderAction action) {
		this.action = action;
	}

}
