package com.homebooking.home_services.controllers;

import com.homebooking.home_services.dto.AuthDTO;
import com.homebooking.home_services.dto.UserDTO;
import com.homebooking.home_services.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(authService.register(authDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(authService.login(authDTO));
    }
}
