package com.linkdinvs.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkdinvs.payment.kafka.source.PaymentFailedSource;
import com.linkdinvs.payment.kafka.source.PaymentReceivedSource;

@Service
public class PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentReceivedSource paymentReceivedSource;

	@Autowired
	private PaymentFailedSource paymentFailedSource;

	public void makePayment(Long orderId) {
		if (isPaymentSuccess()) {
			paymentReceivedSource.publishPaymentSuccessEvent(orderId, getPaymentId());
			logger.info("payment is received successfully");
		} else {
			paymentFailedSource.publishPaymentFailedEvent(orderId);
			logger.info("payment is failed");
		}
	}

	/* this can be any payment gateway interface call */
	private boolean isPaymentSuccess() {
		return true;
	}

	private Long getPaymentId() {
		return 6754L;
	}

}
