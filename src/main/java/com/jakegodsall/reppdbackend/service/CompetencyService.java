package com.jakegodsall.reppdbackend.service;

import com.jakegodsall.reppdbackend.payload.CompetencyDto;

import java.util.List;

public interface CompetencyService {
    List<CompetencyDto> getAllCompetencies();
    CompetencyDto createCompetencyDto(CompetencyDto competencyDto);
    CompetencyDto getCompetencyById(Long id);
    CompetencyDto updateCompetencyDtoById(CompetencyDto competencyDto, Long id);
    void deleteCompetencyDtoById(Long id);
}
