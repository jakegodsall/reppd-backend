package com.jakegodsall.reppdbackend.controllers;

import com.jakegodsall.reppdbackend.payload.CompetencyDto;
import com.jakegodsall.reppdbackend.service.CompetencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class CompetencyController {
    private static final String API_V1_LIST = "/api/v1/competencies";
    private static final String API_V1_ID = "/api/v1/competencies/{id}";

    private final CompetencyService competencyService;

    @GetMapping(API_V1_LIST)
    public ResponseEntity<List<CompetencyDto>> getAllCompetencies() {
        List<CompetencyDto> competencyDtos = competencyService.getAllCompetencies();
        return new ResponseEntity<>(competencyDtos, HttpStatus.OK);
    }

    @PostMapping(API_V1_LIST)
    public ResponseEntity<?> createCompetency(
            @RequestBody CompetencyDto competencyDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError());
        }
        CompetencyDto createdCompetency = competencyService.createCompetency(competencyDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCompetency.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdCompetency);
    }

    @GetMapping(API_V1_ID)
    public ResponseEntity<CompetencyDto> getCompetencyById(@PathVariable Long id) {
        CompetencyDto competencyDto = competencyService.getCompetencyById(id);
        return new ResponseEntity<>(competencyDto, HttpStatus.OK);
    }

    @PutMapping(API_V1_ID)
    public ResponseEntity<CompetencyDto> updateCompetencyById(
            @RequestBody CompetencyDto competencyDto,
            @PathVariable Long id
    ) {
        CompetencyDto updatedCompetency = competencyService.updateCompetencyById(competencyDto, id);
        return new ResponseEntity<>(updatedCompetency, HttpStatus.OK);
    }

    @DeleteMapping(API_V1_ID)
    public ResponseEntity<Void> deleteCompetencyById(@PathVariable Long id) {
        competencyService.deleteCompetencyById(id);
        return ResponseEntity.noContent().build();
    }
}
