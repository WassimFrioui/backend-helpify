package com.homebooking.home_services.mappers;

import com.homebooking.home_services.dto.EnterpriseDTO;
import com.homebooking.home_services.models.Enterprise;
import com.homebooking.home_services.models.User;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseMapper {
    
    public EnterpriseDTO toDTO(Enterprise enterprise) {
        EnterpriseDTO dto = new EnterpriseDTO();
        dto.setId(enterprise.getId());
        dto.setName(enterprise.getName());
        dto.setDescription(enterprise.getDescription());
        dto.setStatus(enterprise.getStatus());
        dto.setAddress(enterprise.getAddress());
        dto.setPhone(enterprise.getPhone());
        dto.setSiren(enterprise.getSiren());
        dto.setOwnerId(enterprise.getUser().getId());
        return dto;
    }

    public Enterprise toEntity(EnterpriseDTO dto, User user) {
        Enterprise enterprise = new Enterprise();
        enterprise.setId(dto.getId());
        enterprise.setName(dto.getName());
        enterprise.setDescription(dto.getDescription());
        enterprise.setStatus(dto.getStatus());
        enterprise.setAddress(dto.getAddress());
        enterprise.setPhone(dto.getPhone());
        enterprise.setSiren(dto.getSiren());
        enterprise.setUser(user);
        return enterprise;
    }
}
