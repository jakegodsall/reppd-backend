package com.jakegodsall.reppdbackend.repository;

import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.payload.CompetencyDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetencyRepository extends JpaRepository<Competency, Long> {
    List<Competency> findAllByUserId(Long userId);
}
