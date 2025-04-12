package com.homebooking.home_services.services;

import com.homebooking.home_services.dto.EmployeeDTO;
import com.homebooking.home_services.mappers.EmployeeMapper;
import com.homebooking.home_services.models.Employee;
import com.homebooking.home_services.models.Enterprise;
import com.homebooking.home_services.models.User;
import com.homebooking.home_services.repositories.EmployeeRepository;
import com.homebooking.home_services.repositories.EnterpriseRepository;
import com.homebooking.home_services.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final UserRepository userRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDTO create(EmployeeDTO dto) {
        Enterprise enterprise = enterpriseRepository.findById(dto.getEnterpriseId())
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Employee employee = employeeMapper.toEntity(dto, enterprise, user);
        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    public EmployeeDTO getById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Employé introuvable"));
    }

    public List<EmployeeDTO> getByEnterpriseId(Long enterpriseId) {
        return employeeRepository.findByEnterpriseId(enterpriseId).stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employé introuvable"));

        Enterprise enterprise = enterpriseRepository.findById(dto.getEnterpriseId())
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        existing.setEnterprise(enterprise);
        existing.setUser(user);
        existing.setRole(dto.getRole());

        return employeeMapper.toDTO(employeeRepository.save(existing));
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
