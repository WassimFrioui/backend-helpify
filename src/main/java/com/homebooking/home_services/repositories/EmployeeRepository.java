package com.homebooking.home_services.repositories;

import com.homebooking.home_services.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEnterpriseId(Long enterpriseId); 
    List<Employee> findByUserId(Long userId); 
}
