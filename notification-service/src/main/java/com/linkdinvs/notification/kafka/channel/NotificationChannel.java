package com.linkdinvs.notification.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface NotificationChannel {

	String INPUT_ORDER = "notification-in-order";
	String INPUT_SHIPPING = "notification-in-shipping";

	@Input(INPUT_ORDER)
	SubscribableChannel inboundOrder();
	
	@Input(INPUT_SHIPPING)
	SubscribableChannel inboundShipping();

}
