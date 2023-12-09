package com.jakegodsall.reppdbackend.payload;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class UserDto {

    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private Long version;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Override
    public String toString() {
        return String.format("%s (%s)", username, password);
    }
}
