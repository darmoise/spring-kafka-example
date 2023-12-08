package com.github.darmoise.springkafkaexample.producerservice.util.mapper;

import com.github.darmoise.springkafkaexample.producerservice.domain.TopicMessage;
import com.github.darmoise.springkafkaexample.producerservice.dto.TopicMessageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMessageMapper {
    TopicMessage dtoToModel(TopicMessageDto dto);
    TopicMessageDto modelToDto(TopicMessage model);
}
