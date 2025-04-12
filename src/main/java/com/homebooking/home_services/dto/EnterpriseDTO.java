package com.homebooking.home_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDTO {
    private Long id;
    private String name;
    private String description;
    private String status;
    private String siren;
    private String address;
    private String mail;
    private String phone;
    private Long ownerId; // ID du propriétaire (User)
}
