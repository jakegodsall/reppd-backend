package com.jakegodsall.reppdbackend.repository;

import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.payload.CompetencyDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompetencyRepository extends JpaRepository<Competency, Long> {
    List<Competency> findAllByUserId(Long userId);
    Optional<Competency> findByName(String name);
}
