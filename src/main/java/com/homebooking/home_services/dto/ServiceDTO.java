package com.homebooking.home_services.dto;

import com.homebooking.home_services.models.E_Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private String localisation;
    private E_Status status;
    private Long enterpriseId;
}
