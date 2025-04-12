package com.homebooking.home_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Long customerId;
    private Long providerId;
    private Long employeeId;
    private Long serviceId;
    private Long quoteId;
    private Date appointmentDate;
    private String status;
}
