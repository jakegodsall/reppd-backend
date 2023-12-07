package com.jakegodsall.reppdbackend.repository.security;

import com.jakegodsall.reppdbackend.entity.auth.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByRole(String role);
}
