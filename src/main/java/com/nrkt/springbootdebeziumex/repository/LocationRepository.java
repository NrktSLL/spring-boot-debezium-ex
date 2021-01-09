package com.nrkt.springbootdebeziumex.repository;

import com.nrkt.springbootdebeziumex.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
