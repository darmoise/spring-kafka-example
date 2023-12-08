package com.github.darmoise.springkafkaexample.producerservice.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {
    private final KafkaProperties properties;

    @Bean
    public NewTopic topic1() {
        return new NewTopic(properties.getTopics().getConsumerTopic(), 1, (short) 1);
    }
}
