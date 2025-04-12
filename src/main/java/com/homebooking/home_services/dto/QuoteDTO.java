package com.homebooking.home_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO {
    private Long id;
    private Long serviceId;
    private Long providerId;
    private Long customerId;
    private double price;
    private String description;
    private String status;
}
