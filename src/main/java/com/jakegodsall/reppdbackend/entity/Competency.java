package com.jakegodsall.reppdbackend.entity;

import com.jakegodsall.reppdbackend.entity.auth.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String name;

    @Size(max = 1000)
    @NotNull
    @Column(length = 1000, nullable = false)
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
