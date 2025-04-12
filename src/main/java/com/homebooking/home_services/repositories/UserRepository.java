package com.homebooking.home_services.repositories;

import com.homebooking.home_services.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail );
    Optional<User> findByPhone(String phone);
    boolean existsByMail(String mail);
    boolean existsByPhone(String phone);
}
