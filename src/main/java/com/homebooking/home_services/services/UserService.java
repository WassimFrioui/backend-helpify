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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(
            userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"))
        );
    }

    public UserDTO getUserByMail(String mail) {
        return userMapper.toDTO(
            userRepository.findByMail(mail)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"))
        );
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setMail(userDTO.getMail());

        return userMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        if (userRepository.existsById(id)) {
            throw new RuntimeException("Erreur lors de la suppression de l'utilisateur");
        }else {
            System.out.println("Utilisateur supprimé avec succès");
        }
    }
}
