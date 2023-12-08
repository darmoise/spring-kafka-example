package com.github.darmoise.springkafkaexample.producerservice.controller;

import com.github.darmoise.springkafkaexample.producerservice.dto.TopicMessageDto;
import com.github.darmoise.springkafkaexample.producerservice.service.CommonService;
import com.github.darmoise.springkafkaexample.producerservice.util.mapper.TopicMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${service.rest-api}/kafka")
public class Controller {
    private final TopicMessageMapper mapper;
    private final CommonService service;

    @PostMapping("topic")
    void sentTopicMessage(final TopicMessageDto dto) {
        service.sendTopicMessage(
            mapper.dtoToModel(dto)
        );
    }
}
