package com.jakegodsall.reppdbackend.entity.auth;

import com.jakegodsall.reppdbackend.entity.BaseEntity;
import jakarta.persistence.*;
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
@Builder
@Entity
@Table(name = "authority", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"permission"})
})
public class Authority extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(length = 50, nullable = false, unique = true)
    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

    public Authority(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return permission;
    }

}
