package com.homebooking.home_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.homebooking.home_services.models.E_Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
    private String address;
    private String password; // Added password field for authentication
    private String token; // Added token field for authentication
}
