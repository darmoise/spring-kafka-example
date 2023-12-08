package com.github.darmoise.springkafkaexample.consumerservice2.dto;

import java.util.UUID;

public record TopicMessageDto(
    UUID requestId
) {
}
