package com.github.darmoise.springkafkaexample.consumerservice1.dto;

import java.util.UUID;

public record TopicMessageDto(
    UUID requestId
) {
}
