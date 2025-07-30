package com.lms.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔴 Disable CSRF only for APIs (or configure properly for production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/signup", "/api/login").permitAll()  // ✅ Allow access
                        .anyRequest().authenticated()               // ❌ Others require auth
                );

        return http.build();
    }
}
