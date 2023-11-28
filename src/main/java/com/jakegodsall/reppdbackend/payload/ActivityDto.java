package com.jakegodsall.reppdbackend.payload;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class ActivityDto {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String name;
}
