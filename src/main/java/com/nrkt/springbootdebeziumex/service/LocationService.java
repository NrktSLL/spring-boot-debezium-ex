package com.nrkt.springbootdebeziumex.service;

import com.nrkt.springbootdebeziumex.model.Location;

public interface LocationService {
    void addLocation(Location location);
    void editLocation(Location location);
    void deleteLocation(Long locationId);
}
