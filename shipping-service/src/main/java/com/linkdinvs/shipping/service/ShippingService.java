package com.linkdinvs.shipping.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkdinvs.shipping.kafka.source.GoodsShippedEventSource;

@Service
public class ShippingService {
	
	private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);
	
	@Autowired
	private GoodsShippedEventSource goodsShippedEventSource;
	
	public void processShippment(Long orderId) {
		
		logger.info("Received an GoodsShippedEvent for order id: " + orderId);
		
		goodsShippedEventSource.publishGoodsShippedEvent(orderId);

	}

}
