package com.jakegodsall.reppdbackend.entity.auth;

import com.jakegodsall.reppdbackend.entity.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "authority")
public class Authority extends BaseEntity {

    private String permission;

    @Builder.Default
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public Authority(String role) {
        this.permission = role;
    }

    @Override
    public String toString() {
        return permission;
    }
}
