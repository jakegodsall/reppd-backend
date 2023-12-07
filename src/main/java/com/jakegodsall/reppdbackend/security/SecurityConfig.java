package com.jakegodsall.reppdbackend.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/api/v1/users").authenticated()
//                                 .requestMatchers("/api/v1/**").permitAll()
                )
                .csrf(csrf -> csrf.disable())
                .formLogin(Customizer.withDefaults())
                .userDetailsService(jpaUserDetailsService)
                .build();

    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
