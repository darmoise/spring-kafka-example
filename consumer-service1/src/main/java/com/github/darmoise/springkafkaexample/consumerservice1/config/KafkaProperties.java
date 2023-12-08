package com.github.darmoise.springkafkaexample.consumerservice1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
    private Topics topics;

    @Data
    public static class Topics {
        private String consumerTopic;
    }
}
