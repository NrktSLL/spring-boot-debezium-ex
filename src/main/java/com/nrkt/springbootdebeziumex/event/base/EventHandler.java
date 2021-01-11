package com.nrkt.springbootdebeziumex.event.base;

import com.nrkt.springbootdebeziumex.dto.DebeziumPayload;

public interface EventHandler {
  void process(DebeziumPayload event);
}
