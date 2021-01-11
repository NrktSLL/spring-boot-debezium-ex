package com.nrkt.springbootdebeziumex.event.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.nrkt.springbootdebeziumex.dto.DebeziumPayload;
import com.nrkt.springbootdebeziumex.dto.PayloadType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.GenericTypeResolver;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

@RequiredArgsConstructor
public abstract class MessageHandler<T> {
    protected final Map<PayloadType, BiConsumer<T, T>> actions = Maps.newConcurrentMap();

    public abstract void initActions();

    private final ObjectMapper mapper;

    @SneakyThrows
    @SuppressWarnings(value = "unchecked")
    public void process(DebeziumPayload event) {
        var payloadType = event.getOperation();
        String payloadBefore = event.getBefore();
        String payloadAfter = event.getAfter();

        Class<T> entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), MessageHandler.class);

        T before = null;
        T after = null;

        if (Objects.isNull(entityClass)) {
            throw new IllegalArgumentException("Entity class cannot be resolved");
        }
        if (!payloadBefore.equals("null")) {
            before = mapper.readValue(payloadBefore, entityClass);
        }
        if (!payloadAfter.equals("null")) {
            after = mapper.readValue(payloadAfter, entityClass);
        }
        actions.get(payloadType).accept(before, after);
    }
}
