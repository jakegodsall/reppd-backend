package com.jakegodsall.reppdbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")

    private Set<Competency> competencies = new HashSet<>();

    @Builder
    public User(
            Long id,
            LocalDateTime createdDate,
            LocalDateTime lastModifiedDate,
            Long version,
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        super(id, createdDate, lastModifiedDate, version);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
