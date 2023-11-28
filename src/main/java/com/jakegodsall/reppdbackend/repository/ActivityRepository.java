package com.jakegodsall.reppdbackend.repository;

import com.jakegodsall.reppdbackend.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
