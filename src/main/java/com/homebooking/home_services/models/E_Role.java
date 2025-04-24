package com.homebooking.home_services.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum E_Role {
    USER,
    ENTERPRISE,
    ADMIN;

    
    @JsonCreator
    public static E_Role fromString(String value) {
        return E_Role.valueOf(value.split("\\.")[1]);  
    }
}

