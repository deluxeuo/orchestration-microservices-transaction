package com.linkdinvs.inventory.kafka.message;

public class ItemEvent {
	private Long orderId;
	private Long itemId;
	private Action action;
	
	public static enum Action {
		ITEMFETCHED,
		ITEMOUTOFSTOCK
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
