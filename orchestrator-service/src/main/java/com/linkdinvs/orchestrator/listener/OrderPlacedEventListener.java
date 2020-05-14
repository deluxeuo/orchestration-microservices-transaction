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
import com.linkdinvs.orchestrator.kafka.message.OrderEvent;
import com.linkdinvs.orchestrator.rest.util.RestClient;

@Component
public class OrderPlacedEventListener {

	@Autowired
	private RestClient restClient;

	@Value("${inventory.service.endpoint}")
	private String inventoryEndpoint;

	private static final Logger logger = LoggerFactory.getLogger(OrderPlacedEventListener.class);

	@StreamListener(target = OrchestratorChannel.INPUT_ORDER)
	public void listenOrderPlaced(@Payload OrderEvent orderEvent) {
		
		if (OrderEvent.OrderAction.ORDERPLACED.equals(orderEvent.getAction())) {
			logger.info("Received an OrderPlacedEvent for order id: " + orderEvent.getOrderId());
			logger.info("Going to call inventory service for order id : " + orderEvent.getOrderId());

			try {
				restClient.doPost(inventoryEndpoint, orderEvent.getOrderId());
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
