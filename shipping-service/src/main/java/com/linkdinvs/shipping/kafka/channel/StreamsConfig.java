package com.linkdinvs.shipping.kafka.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.linkdinvs.shipping.kafka.channel.ShippingChannel;

@EnableBinding(ShippingChannel.class)
public class StreamsConfig {

}
