package com.github.darmoise.springkafkaexample.producerservice.dto;

import java.util.UUID;

public record TopicMessageDto(
        UUID requestId
) {
}
