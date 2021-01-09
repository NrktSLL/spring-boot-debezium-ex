package com.nrkt.springbootdebeziumex.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebeziumEvent {
    String before;
    String after;
    PayloadType operation;
    Date date;
}
