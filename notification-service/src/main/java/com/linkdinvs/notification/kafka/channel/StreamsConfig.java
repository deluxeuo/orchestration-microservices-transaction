package com.linkdinvs.notification.kafka.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.linkdinvs.notification.kafka.channel.NotificationChannel;

@EnableBinding(NotificationChannel.class)
public class StreamsConfig {

}
