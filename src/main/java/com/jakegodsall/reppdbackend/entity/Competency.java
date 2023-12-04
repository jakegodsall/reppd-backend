package com.jakegodsall.reppdbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
@Entity
@Table(name = "competency")
public class Competency extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "competency")
    private Set<Activity> activities = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
