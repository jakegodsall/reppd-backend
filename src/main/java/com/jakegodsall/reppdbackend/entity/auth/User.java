package com.jakegodsall.reppdbackend.entity.auth;

import com.jakegodsall.reppdbackend.entity.BaseEntity;
import com.jakegodsall.reppdbackend.entity.Competency;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Builder
@Table(name = "user")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(name = "user_authority",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities = new HashSet<>();

    @Builder.Default
    private Boolean enabled = true;

    @Builder.Default
    private Boolean accountNonExpired = true;

    @Builder.Default
    private Boolean credentialsNonExpired = true;

    @Builder.Default
    private Boolean accountNotLocked = true;


    @OneToMany(mappedBy = "user")
    private Set<Competency> competencies = new HashSet<>();

}
