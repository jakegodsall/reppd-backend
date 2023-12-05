package com.jakegodsall.reppdbackend.service;

import com.jakegodsall.reppdbackend.payload.CompetencyDto;

import java.util.List;

public interface CompetencyService {
    List<CompetencyDto> getAllCompetencies();
    public List<CompetencyDto> getAllCompetenciesForUser(Long userId);
    CompetencyDto createCompetency(CompetencyDto competencyDto);
    CompetencyDto getCompetencyById(Long id);
    CompetencyDto updateCompetencyById(CompetencyDto competencyDto, Long id);
    void deleteCompetencyById(Long id);
}
