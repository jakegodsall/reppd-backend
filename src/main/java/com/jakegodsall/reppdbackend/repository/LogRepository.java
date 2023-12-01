package com.jakegodsall.reppdbackend.repository;

import com.jakegodsall.reppdbackend.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
