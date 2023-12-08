package com.github.darmoise.springkafkaexample.consumerservice1.integration;

import com.github.darmoise.springkafkaexample.consumerservice1.dto.TopicMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @KafkaListener(topics = "${kafka.topics.consumer-topic}", groupId = "foo1")
    public void onMessageReceived(@Payload TopicMessageDto message) {
        log.info("consumer1: " + message);
    }
}