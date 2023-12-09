package com.jakegodsall.reppdbackend.entity.auth;

import com.jakegodsall.reppdbackend.entity.BaseEntity;
import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.repository.security.AuthorityRepository;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "user")
public class User extends BaseEntity {

    private String username;

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


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Competency> competencies = new HashSet<>();

    public void addAuthority(Authority authority) {
        if (authorities == null)
            authorities = new HashSet<>();
        authorities.add(authority);
        authority.getUsers().add(this);
    }

    public void addCompetency(Competency competency) {
        if (competencies == null)
                competencies = new HashSet<>();
        competencies.add(competency);
        competency.setUser(this);
    }

}
