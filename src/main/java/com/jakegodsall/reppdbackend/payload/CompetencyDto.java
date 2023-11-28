package com.jakegodsall.reppdbackend.payload;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class CompetencyDto {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
