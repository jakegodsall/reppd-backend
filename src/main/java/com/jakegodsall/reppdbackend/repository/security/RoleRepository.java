package com.jakegodsall.reppdbackend.repository.security;

import com.jakegodsall.reppdbackend.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String name);
}
