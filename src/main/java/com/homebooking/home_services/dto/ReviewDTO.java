package com.homebooking.home_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;
    private Long appointmentId;
    private Long customerId;
    private Long providerId;
    private Long employeeId;
    private int rating;
    private String comment;
}
