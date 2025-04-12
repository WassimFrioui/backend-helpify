package com.homebooking.home_services.repositories;

import com.homebooking.home_services.models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Optional<Enterprise> findByName(String name);
    Optional<Enterprise> findByMail(String mail );
    Optional<Enterprise> findByPhone(String phone);
    Optional<Enterprise> findBySiren(String siren);
    Optional<Enterprise> findByUserId(Long userId);
    boolean existsByName(String name);
    boolean existsBySiren(String siren);
    boolean existsByMail(String mail);
    boolean existsByPhone(String phone);
}
