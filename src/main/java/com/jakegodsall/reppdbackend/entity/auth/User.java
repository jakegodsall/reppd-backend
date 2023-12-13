package com.jakegodsall.reppdbackend.entity.auth;

import com.jakegodsall.reppdbackend.entity.BaseEntity;
import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.repository.security.AuthorityRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "email"})
})
public class User extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String firstName;

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String lastName;

    @Size(max = 100)
    @Email(message = "Invalid email format")
    @NotNull
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Size(max=255)
    @NotNull
    @Column(length = 255, nullable = false)
    private String password;

    @Singular
    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Transient
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


    public void addCompetency(Competency competency) {
        if (competencies == null)
                competencies = new HashSet<>();
        competencies.add(competency);
        competency.setUser(this);
    }

}
