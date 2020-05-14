package com.linkdinvs.shipping.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ShippingChannel {

	String OUTPUT = "shipping-out";

	@Output(OUTPUT)
	MessageChannel outboundShippingt();

}
