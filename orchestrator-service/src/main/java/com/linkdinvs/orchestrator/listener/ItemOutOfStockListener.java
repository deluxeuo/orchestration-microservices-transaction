package com.linkdinvs.orchestrator.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.linkdinvs.orchestrator.exception.ResourceNotFoundException;
import com.linkdinvs.orchestrator.kafka.channel.OrchestratorChannel;
import com.linkdinvs.orchestrator.kafka.message.ItemEvent;
import com.linkdinvs.orchestrator.rest.util.RestClient;

@Component
public class ItemOutOfStockListener {

	@Autowired
	private RestClient restClient;
	
	@Value("${order.service.endpoint}")
	private String orderEndpoint;

	private static final Logger logger = LoggerFactory.getLogger(ItemOutOfStockListener.class);

	@StreamListener(OrchestratorChannel.INPUT_INVNETORY)
	public void listenOutOfStockItem(@Payload ItemEvent itemEvent) throws ResourceNotFoundException {
		
		if (ItemEvent.Action.ITEMOUTOFSTOCK.equals(itemEvent.getAction())) {
			logger.info("ItemOutOfStock event received for item id: " + itemEvent.getItemId());

			logger.info("Going to call order service to compensate order for id " + itemEvent.getOrderId());
			
			restClient.doPost(orderEndpoint + "compensate", itemEvent.getOrderId());
		}
	}
}
