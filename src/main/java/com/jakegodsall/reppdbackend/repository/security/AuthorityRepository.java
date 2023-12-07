package com.jakegodsall.reppdbackend.repository.security;

import com.jakegodsall.reppdbackend.entity.auth.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
