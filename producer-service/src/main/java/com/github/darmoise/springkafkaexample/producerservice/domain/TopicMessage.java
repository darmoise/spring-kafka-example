package com.github.darmoise.springkafkaexample.producerservice.domain;

import java.util.UUID;

public record TopicMessage(
    UUID requestId
) {
}
