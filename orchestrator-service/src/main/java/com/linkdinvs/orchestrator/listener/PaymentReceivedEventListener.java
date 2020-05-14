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
import com.linkdinvs.orchestrator.kafka.message.PaymentEvent;
import com.linkdinvs.orchestrator.rest.util.RestClient;

@Component
public class PaymentReceivedEventListener {

	@Autowired
	private RestClient restClient;

	@Value("${shipment.service.endpoint}")
	private String shipmentEndpoint;

	private static final Logger logger = LoggerFactory.getLogger(PaymentReceivedEventListener.class);

	@StreamListener(OrchestratorChannel.INPUT_PAYMENT)
	public void listenItemFetchedEvent(@Payload PaymentEvent paymentReceivedMessage) throws ResourceNotFoundException {

		if (PaymentEvent.PaymentAction.PAYMENTRECEIVED.equals(paymentReceivedMessage.getAction())) {
			logger.info("Received an PaymentReceivedEvent for order id: " + paymentReceivedMessage.getOrderId());

			if (paymentReceivedMessage.getOrderId() != null) {
				logger.info("Going to call shipment service for order id : " + paymentReceivedMessage.getOrderId());
				restClient.doPost(shipmentEndpoint, paymentReceivedMessage.getOrderId());
			}
		}

	}

}
