package com.jakegodsall.reppdbackend.service.impl;

import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.exceptions.ResourceNotFoundException;
import com.jakegodsall.reppdbackend.mappers.CompetencyMapper;
import com.jakegodsall.reppdbackend.payload.CompetencyDto;
import com.jakegodsall.reppdbackend.repository.CompetencyRepository;
import com.jakegodsall.reppdbackend.service.CompetencyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor @AllArgsConstructor
public class CompetencyServiceImpl implements CompetencyService {

    private CompetencyRepository competencyRepository;
    private CompetencyMapper competencyMapper;

    @Override
    public List<CompetencyDto> getAllCompetencies() {
        return competencyRepository.findAll().stream()
                .map(competencyMapper::competencyToCompetencyDto)
                .toList();
    }

    @Override
    public CompetencyDto createCompetencyDto(CompetencyDto competencyDto) {
        return null;
    }

    @Override
    public CompetencyDto getCompetencyById(Long id) {
        Competency competency = competencyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Competency", "id", id)
        );

        return competencyMapper.competencyToCompetencyDto(competency);
    }

    @Override
    public CompetencyDto updateCompetencyDtoById(CompetencyDto competencyDto, Long id) {
        return null;
    }

    @Override
    public void deleteCompetencyDtoById(Long id) {

    }
}
