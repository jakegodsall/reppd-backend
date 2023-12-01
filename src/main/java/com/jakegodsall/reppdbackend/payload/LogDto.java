package com.jakegodsall.reppdbackend.payload;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class LogDto {
    private Long id;
    private LocalDate date;
    private Long value;
}
