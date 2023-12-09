package com.jakegodsall.reppdbackend.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jakegodsall.reppdbackend.entity.auth.User;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompetencyDto {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String name;
    private String description;
    private Long userId;

    @Override
    public String toString() {
        return name;
    }
}
