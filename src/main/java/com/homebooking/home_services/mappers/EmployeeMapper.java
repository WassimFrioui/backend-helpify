package com.homebooking.home_services.mappers;

import com.homebooking.home_services.dto.EmployeeDTO;
import com.homebooking.home_services.models.Employee;
import com.homebooking.home_services.models.Enterprise;
import com.homebooking.home_services.models.User;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setEnterpriseId(employee.getEnterprise().getId());
        dto.setUserId(employee.getUser().getId());
        dto.setRole(employee.getRole());
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto, Enterprise enterprise, User user) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setEnterprise(enterprise);
        employee.setUser(user);
        employee.setRole(dto.getRole());
        return employee;
    }
}
