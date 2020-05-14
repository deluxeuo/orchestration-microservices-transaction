package com.linkdinvs.payment.kafka.message;

public class PaymentEvent {
	
	private Long orderId;
	private PaymentAction action;
	
	public static enum PaymentAction {
		PAYMENTRECEIVED,
		PAYMENTNOTRECEIVED
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public PaymentAction getAction() {
		return action;
	}

	public void setAction(PaymentAction action) {
		this.action = action;
	}

}
