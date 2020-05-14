package com.linkdinvs.orchestrator.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrchestratorChannel {

	String INPUT_ORDER = "order-in";
	String INPUT_INVNETORY = "inventory-in";
	String INPUT_PAYMENT = "payment-in";

	@Input(INPUT_ORDER)
	SubscribableChannel inboundOrder();
	
	@Input(INPUT_INVNETORY)
	SubscribableChannel inboundInventory();
	
	@Input(INPUT_PAYMENT)
	SubscribableChannel inboundPayment();

}
