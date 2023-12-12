package com.jakegodsall.reppdbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthorityNotFoundException extends RuntimeException {

    private String permission;

    public AuthorityNotFoundException(String permission) {
        super(String.format("Authority %s not found.\n", permission));
        this.permission = permission;
    }
}
