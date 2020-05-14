package com.linkdinvs.inventory.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InventoryChannel {

	String OUTPUT = "inventory-out";

	@Output(OUTPUT)
	MessageChannel outboundInventory();

}
