package com.nrkt.springbootdebeziumex.service;

import com.nrkt.springbootdebeziumex.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    @Override
    public void addLocation(Location location) {
        if (location != null) {
            log.info("added: " + location);
        }
    }

    @Override
    public void editLocation(Location location) {
        if (location != null) {
            log.info("edited: " + location);
        }
    }

    @Override
    public void deleteLocation(Long locationId) {
        if (locationId != null) {
            log.info(locationId + " id location deleted");
        }
    }
}
