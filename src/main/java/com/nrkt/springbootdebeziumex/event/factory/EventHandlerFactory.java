package com.nrkt.springbootdebeziumex.event.factory;

import com.google.common.collect.Maps;
import com.nrkt.springbootdebeziumex.event.base.EventHandler;
import com.nrkt.springbootdebeziumex.event.handlers.LocationEventHandler;
import com.nrkt.springbootdebeziumex.event.handlers.UserEventHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EventHandlerFactory {

    UserEventHandler userEventHandler;
    LocationEventHandler locationEventHandler;

    Map<String, EventHandler> handlers = Maps.newConcurrentMap();

    @PostConstruct
    public void init() {
        handlers.put("user", userEventHandler);
        handlers.put("location", locationEventHandler);
    }

    public EventHandler getHandler(String topicName) {
        Assert.hasText(topicName, "Topic name cannot be empty");

        String tableName = topicName.substring(topicName.lastIndexOf(".") + 1).toLowerCase(Locale.ROOT);

        return Optional.ofNullable(handlers.get(tableName))
                .orElseThrow(() -> new IllegalArgumentException("No suitable handler was found for the topic " + topicName));
    }
}
