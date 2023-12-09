package com.jakegodsall.reppdbackend.entity;

import com.jakegodsall.reppdbackend.entity.auth.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "competency")
public class Competency extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "competency")
    private Set<Activity> activities = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return name;
    }
}
