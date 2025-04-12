package com.homebooking.home_services.mappers;

import com.homebooking.home_services.dto.UserDTO;
import com.homebooking.home_services.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
