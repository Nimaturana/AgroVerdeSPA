package com.example.PruebaFS.AgroVerdeSPA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Swagger requiere autenticacion
                .requestMatchers("/doc/**", "/v3/api-docs/**").authenticated()
                // El resto del sistema no requiere
                .anyRequest().permitAll()
            )
            .httpBasic(httpBasic -> {}) // login en Swagger
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.builder()
            //Creedenciales
            .username("admin") //usuario 
            .password(passwordEncoder().encode("1234")) //contraseña
            .roles("ADMIN") // rol 
            .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
