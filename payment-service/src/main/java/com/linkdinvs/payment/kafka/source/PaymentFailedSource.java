package com.linkdinvs.payment.kafka.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.linkdinvs.payment.kafka.channel.PaymentChannel;
import com.linkdinvs.payment.kafka.message.PaymentEvent;

@Component
public class PaymentFailedSource {

	@Autowired
	private PaymentChannel paymentChannel;

	public void publishPaymentFailedEvent(Long orderId) {

		PaymentEvent message = new PaymentEvent();
		message.setOrderId(orderId);
		message.setAction(PaymentEvent.PaymentAction.PAYMENTNOTRECEIVED);
		
		MessageChannel messageChannel = paymentChannel.outboundPayment();
		messageChannel.send(MessageBuilder.withPayload(message)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

}
