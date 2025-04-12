package com.homebooking.home_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.homebooking.home_services.models.E_Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Enum<E_Role> role;
    private String mail;
    private String phone;
    private String address;
}
