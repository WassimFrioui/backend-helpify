package com.homebooking.home_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.micrometer.common.lang.NonNull;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF using new recommended approach
            .csrf(AbstractHttpConfigurer::disable)
            
            // Configure authorization
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/register", "/auth/login").permitAll() // Permet l'accès public
                .requestMatchers("http://localhost:3000").permitAll()
                .requestMatchers("/api/users/register", "/api/users/login").permitAll()
                .requestMatchers("/enterprises/**").permitAll() // Autorise l'accès public aux entreprises
                .requestMatchers("/employees/**").permitAll() // Autorise l'accès public aux employés
                .requestMatchers("/users/**").permitAll() // Autorise les utilisateurs authentifiés

                .anyRequest().authenticated()
            )
            
            // Disable form login
            .formLogin(AbstractHttpConfigurer::disable)
            
            // Disable HTTP Basic authentication
            .httpBasic(AbstractHttpConfigurer::disable)
            
            // Disable frame options for H2 console (if needed)
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // CORS Configuration
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**") // Permet l'accès à toutes les routes
                .allowedOrigins("http://localhost:3000") // Permet les requêtes depuis localhost:3000
                .allowedOriginPatterns("http://localhost:3000/**") // Permet les requêtes depuis localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permet ces méthodes HTTP
                .allowedHeaders("*") // Permet tous les en-têtes
                .allowCredentials(true); // Autorise les informations d'identification (cookies, en-têtes d'authentification, etc.)
    }
}
    