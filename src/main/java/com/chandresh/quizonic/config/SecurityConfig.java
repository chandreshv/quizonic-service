package com.chandresh.quizonic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (enable in production)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login").permitAll() // Allow public access to home and login
                .anyRequest().authenticated() // Secure all other endpoints
            )
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/dashboard", true) // Redirect after successful login
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/") // Redirect to home after logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            );

        return http.build();
    }
}
