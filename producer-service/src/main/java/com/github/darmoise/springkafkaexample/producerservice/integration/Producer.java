package com.github.darmoise.springkafkaexample.producerservice.integration;

import com.github.darmoise.springkafkaexample.producerservice.config.KafkaProperties;
import com.github.darmoise.springkafkaexample.producerservice.domain.TopicMessage;
import com.github.darmoise.springkafkaexample.producerservice.dto.TopicMessageDto;
import com.github.darmoise.springkafkaexample.producerservice.util.mapper.TopicMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {
    private final KafkaProperties properties;
    private final KafkaTemplate<String, TopicMessageDto> template;
    private final TopicMessageMapper mapper;

    public void sendTopicMessage(final TopicMessage model) {
        template.send(properties.getTopics().getConsumerTopic(), mapper.modelToDto(model));
    }
}
