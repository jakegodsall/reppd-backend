package com.jakegodsall.reppdbackend.mappers;

import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.payload.CompetencyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetencyMapper {
    @Mapping(target = "userId", source = "user.id")
    CompetencyDto competencyToCompetencyDto(Competency competency);
    Competency competencyDtoToCompetency(CompetencyDto competencyDto);
}
