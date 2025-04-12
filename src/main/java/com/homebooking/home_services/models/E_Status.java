package com.homebooking.home_services.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum E_Status {
    ACTIVE,
    INACTIVE;

    
    @JsonCreator
    public static E_Status fromString(String value) {
        return E_Status.valueOf(value.split("\\.")[1]);  // Extrait la partie après le "."
    }
}

