package com.linkdinvs.payment.kafka.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentChannel {

	String OUTPUT = "payment-out";

	@Output(OUTPUT)
	MessageChannel outboundPayment();

}
