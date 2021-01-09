package com.nrkt.springbootdebeziumex.event.base;

import com.nrkt.springbootdebeziumex.dto.DebeziumEvent;

public interface EventHandler {
  void process(DebeziumEvent event);
}
