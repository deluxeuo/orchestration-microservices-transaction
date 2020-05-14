package com.linkdinvs.payment.kafka.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.linkdinvs.payment.kafka.channel.PaymentChannel;

@EnableBinding(PaymentChannel.class)
public class StreamsConfig {

}
