package com.nrkt.springbootdebeziumex.event.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrkt.springbootdebeziumex.dto.PayloadType;
import com.nrkt.springbootdebeziumex.event.base.EventHandler;
import com.nrkt.springbootdebeziumex.event.base.KafkaMessagesHandler;
import com.nrkt.springbootdebeziumex.model.Location;
import com.nrkt.springbootdebeziumex.service.LocationService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LocationEventHandler extends KafkaMessagesHandler<Location> implements EventHandler {

    LocationService locationService;

    public LocationEventHandler(ObjectMapper mapper, LocationService locationService) {
        super(mapper);
        this.locationService = locationService;
    }

    @PostConstruct
    public void action() {
        initActions();
    }

    @Override
    public void initActions() {
        actions.put(PayloadType.CREATE, (before, after) -> locationService.addLocation(after));
        actions.put(PayloadType.UPDATE, (before, after) -> locationService.editLocation(after));
        actions.put(PayloadType.DELETE, (before, after) -> locationService.deleteLocation(before.getId()));
    }
}
