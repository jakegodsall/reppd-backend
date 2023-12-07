package com.jakegodsall.reppdbackend.repository;

import com.jakegodsall.reppdbackend.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
