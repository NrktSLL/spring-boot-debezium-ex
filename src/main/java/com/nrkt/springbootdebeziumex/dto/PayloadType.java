package com.nrkt.springbootdebeziumex.dto;

public enum PayloadType {
    CREATE, UPDATE, DELETE;

    public static PayloadType value(String name) {
        switch (name) {
            case "c":
                return CREATE;
            case "u":
                return UPDATE;
            case "d":
                return DELETE;
            default:
                throw new IllegalArgumentException("There is no match for the specified value");
        }
    }
}
