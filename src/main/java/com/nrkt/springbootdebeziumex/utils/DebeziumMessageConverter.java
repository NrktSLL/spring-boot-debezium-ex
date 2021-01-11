package com.nrkt.springbootdebeziumex.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrkt.springbootdebeziumex.dto.DebeziumPayload;
import com.nrkt.springbootdebeziumex.dto.PayloadType;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class DebeziumMessageConverter {

    @SneakyThrows
    public DebeziumPayload convertToPayload(String jsonData) {
        if (jsonData != null) {
            ObjectMapper objectMapper = new ObjectMapper();

            var rootNode = objectMapper.readTree(jsonData);

            JsonNode root = rootNode.path("payload");
            JsonNode after = root.path("after");
            JsonNode before = root.path("before");
            JsonNode epochTime = root.path("ts_ms");
            JsonNode operation = root.path("op");

            long epoch = Long.parseLong(epochTime.asText()) * 1000;
            Date date = new Date(epoch);

            return DebeziumPayload.builder()
                    .after(after.toString())
                    .before(before.toString())
                    .date(date)
                    .operation(PayloadType.value(operation.asText()))
                    .build();
        }
        return DebeziumPayload.builder().build();
    }
}
