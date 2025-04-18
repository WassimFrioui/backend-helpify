package com.homebooking.home_services.services;

import com.homebooking.home_services.dto.AuthDTO;
import com.homebooking.home_services.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.homebooking.home_services.models.User;
import com.homebooking.home_services.repositories.UserRepository;
import com.homebooking.home_services.mappers.UserMapper;
import java.util.Optional;
import com.homebooking.home_services.models.E_Role;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO register(AuthDTO authDTO) {
        if (userRepository.existsByMail(authDTO.getMail())) {
            throw new RuntimeException("Email déjà utilisé");
        }
        if ( authDTO.getPassword().length() < 8) {
            throw new RuntimeException("Le mot de passe doit contenir au moins 8 caractères");
        }

        User user = new User();
        user.setFirstname(authDTO.getFirstname());
        user.setLastname(authDTO.getLastname());
        user.setAddress(authDTO.getAddress());
        
        user.setPhone(authDTO.getPhone());
        user.setMail(authDTO.getMail());
        user.setPassword(passwordEncoder.encode(authDTO.getPassword()));
        user.setRole(E_Role.USER);

        return userMapper.toDTO(userRepository.save(user));
    }

    public String login(AuthDTO authDTO) {
        User user = userRepository.findByMail(authDTO.getMail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(authDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return "Connexion réussie";
    }
}
