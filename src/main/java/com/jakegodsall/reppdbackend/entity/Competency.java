package com.jakegodsall.reppdbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
@Entity
@Table(name = "competency")
public class Competency extends BaseEntity {
    private String name;
}
