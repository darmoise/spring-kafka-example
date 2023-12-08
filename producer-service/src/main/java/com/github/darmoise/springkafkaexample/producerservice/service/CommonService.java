package com.github.darmoise.springkafkaexample.producerservice.service;

import com.github.darmoise.springkafkaexample.producerservice.domain.TopicMessage;
import com.github.darmoise.springkafkaexample.producerservice.integration.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final Producer producer;

    public void sendTopicMessage(final TopicMessage model) {
        producer.sendTopicMessage(model);
    }
}
