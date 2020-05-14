package com.linkdinvs.inventory.kafka.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.linkdinvs.inventory.kafka.channel.InventoryChannel;
import com.linkdinvs.inventory.kafka.message.ItemEvent;

@Component
public class ItemFetchedEventSource {

	@Autowired
	private InventoryChannel inventoryChannel;

	public void publishItemFetchedEvent(Long orderId,Long itemId) {

		ItemEvent message = new ItemEvent();
		message.setItemId(itemId);
		message.setOrderId(orderId);
		message.setAction(ItemEvent.Action.ITEMFETCHED);
		
		MessageChannel messageChannel = inventoryChannel.outboundInventory();
		messageChannel.send(MessageBuilder.withPayload(message)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

}
