package com.nrkt.springbootdebeziumex.listener;

import com.nrkt.springbootdebeziumex.event.factory.EventHandlerFactory;
import com.nrkt.springbootdebeziumex.utils.DebeziumMessageConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Receiver {

    private final EventHandlerFactory handlerFactory;

    @KafkaListener(topics = "#{'${kafka.topics}'.split(',')}", containerFactory = "kafkaListenerContainerFactory")
    public void consumeDebezuim(ConsumerRecord<String, String> record) {

        try {
            var debeziumEvent = DebeziumMessageConverter.convertToPayload(record.value());
            if (debeziumEvent.getOperation() != null) {
                handlerFactory.getHandler(record.topic()).process(debeziumEvent);
            } else throw new KafkaException(record.key() + "contains key corresponding message is null");
        } catch (KafkaException exception) {
            log.warn(exception.getMessage());
        }
    }
}