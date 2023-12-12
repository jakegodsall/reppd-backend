package com.jakegodsall.reppdbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoleNotFoundException extends RuntimeException {
    private String roleName;

    public RoleNotFoundException(String roleName) {
        super(String.format("Role %s not found.\n", roleName));
        this.roleName = roleName;
    }
}
