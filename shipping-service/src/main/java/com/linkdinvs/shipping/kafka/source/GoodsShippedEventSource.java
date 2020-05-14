package com.linkdinvs.shipping.kafka.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.linkdinvs.shipping.kafka.channel.ShippingChannel;
import com.linkdinvs.shipping.kafka.message.ShippingEvent;

@Component
public class GoodsShippedEventSource {

	@Autowired
	private ShippingChannel shippingChannel;

	public void publishGoodsShippedEvent(Long orderId) {

		ShippingEvent message = new ShippingEvent();
		message.setOrderId(orderId);
		message.setAction(ShippingEvent.Action.GOODSSHIPPED);
		
		MessageChannel messageChannel = shippingChannel.outboundShippingt();
		messageChannel.send(MessageBuilder.withPayload(message)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

}
