package com.nrkt.springbootdebeziumex.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrkt.springbootdebeziumex.dto.DebeziumEvent;
import com.nrkt.springbootdebeziumex.dto.PayloadType;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class KafkaMessageModelConvert {

    @SneakyThrows
    public DebeziumEvent convertModel(String jsonData) {
        if (jsonData != null) {
            ObjectMapper objectMapper = new ObjectMapper();

            var rootNode = objectMapper.readTree(jsonData);

            JsonNode root = rootNode.path("payload");
            JsonNode after = root.path("after");
            JsonNode before = root.path("before");
            JsonNode epochTime = root.path("ts_ms");
            JsonNode operation = root.path("op");

            long epoch = Long.parseLong(epochTime.asText()) * 1000;
            var date = new Date(epoch);

            return DebeziumEvent.builder()
                    .after(after.toString())
                    .before(before.toString())
                    .date(date)
                    .operation(PayloadType.value(operation.asText()))
                    .build();
        }
        return DebeziumEvent.builder().build();
    }
}
