package com.linkdinvs.inventory.kafka.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.linkdinvs.inventory.kafka.channel.InventoryChannel;

@EnableBinding(InventoryChannel.class)
public class StreamsConfig {

}
