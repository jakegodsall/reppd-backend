package com.jakegodsall.reppdbackend.mappers;

import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.payload.CompetencyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetencyMapper {
    CompetencyDto competencyToCompetencyDto(Competency competency);
    Competency competencyDtoToCompetency(CompetencyDto competencyDto);
}
