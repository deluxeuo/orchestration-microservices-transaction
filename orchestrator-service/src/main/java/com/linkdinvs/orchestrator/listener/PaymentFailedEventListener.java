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
public class PaymentFailedEventListener {

	@Autowired
	private RestClient restClient;

	@Value("${inventory.service.endpoint}")
	private String inventoryEndpoint;

	private static final Logger logger = LoggerFactory.getLogger(PaymentFailedEventListener.class);

	@StreamListener(OrchestratorChannel.INPUT_PAYMENT)
	public void listenPaymentFailed(@Payload PaymentEvent paymentFailedMessage) throws ResourceNotFoundException {
		
		if (PaymentEvent.PaymentAction.PAYMENTNOTRECEIVED.equals(paymentFailedMessage.getAction())) {
			logger.info("Received an PaymentFailedEvent for order id: " + paymentFailedMessage.getOrderId());

			if (paymentFailedMessage.getOrderId() != null) {
				logger.info("Going to call item service to compensate item for order id : "
						+ paymentFailedMessage.getOrderId());
				restClient.doPost(inventoryEndpoint + "compensate", paymentFailedMessage.getOrderId());
			}
		}

	}

}
