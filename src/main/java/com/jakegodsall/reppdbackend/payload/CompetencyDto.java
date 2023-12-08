package com.jakegodsall.reppdbackend.payload;

import com.jakegodsall.reppdbackend.entity.auth.User;
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
    private String name;
    private User user;
}
