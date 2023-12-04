package com.jakegodsall.reppdbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "activity")
public class Activity extends BaseEntity {
    private String name;
    @ManyToOne

    @JoinColumn(name = "competency_id")
    private Competency competency;
}
