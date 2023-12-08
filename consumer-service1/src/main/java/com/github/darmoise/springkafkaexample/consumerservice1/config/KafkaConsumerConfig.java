package com.github.darmoise.springkafkaexample.consumerservice1.config;

import com.github.darmoise.springkafkaexample.consumerservice1.dto.TopicMessageDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, TopicMessageDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            bootstrapAddress
        );

        JsonDeserializer<TopicMessageDto> deserializer = new JsonDeserializer<>(TopicMessageDto.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TopicMessageDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TopicMessageDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
