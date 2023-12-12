package com.jakegodsall.reppdbackend.bootstrap;

import com.jakegodsall.reppdbackend.entity.auth.Authority;
import com.jakegodsall.reppdbackend.entity.auth.Role;
import com.jakegodsall.reppdbackend.entity.auth.User;
import com.jakegodsall.reppdbackend.exceptions.RoleNotFoundException;
import com.jakegodsall.reppdbackend.repository.security.AuthorityRepository;
import com.jakegodsall.reppdbackend.repository.security.RoleRepository;
import com.jakegodsall.reppdbackend.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Order(1)
@Component
public class SecurityLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        setAuthoritiesAndRoles();
        createAdminUser();
    }

    private void setAuthoritiesAndRoles() {
        // Users
        Authority createUser = new Authority("CREATE_USER");
        Authority readUser = new Authority("READ_USER");
        Authority updateUser = new Authority("UPDATE_USER");
        Authority deleteUser = new Authority("DELETE_USER");

        // Store User authorities in the db
        authorityRepository.saveAll(List.of(
                createUser,
                readUser,
                updateUser,
                deleteUser
        ));

        // Competency resource
        Authority createCompetency = new Authority("CREATE_COMPETENCY");
        Authority readCompetency = new Authority("READ_COMPETENCY");
        Authority updateCompetency = new Authority("UPDATE_COMPETENCY");
        Authority deleteCompetency = new Authority("DELETE_COMPETENCY");

        // Store Competency authorities in the db
        authorityRepository.saveAll(List.of(
                createCompetency,
                readCompetency,
                updateCompetency,
                deleteCompetency
        ));


        // Roles
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");


        // Assign authorities to roles
        adminRole.setAuthorities(new HashSet<>(Set.of(
                createUser, readUser, updateUser, deleteUser,
                createCompetency, readCompetency, updateCompetency, deleteCompetency
        )));

        userRole.setAuthorities(new HashSet<>(Set.of(
                readCompetency
        )));

        // Store Roles in the db
        roleRepository.saveAll(List.of(
                adminRole,
                userRole
        ));
    }

    private void createAdminUser() {
        Role adminRole = roleRepository.getRoleByName("ADMIN").orElseThrow(
                () -> new RoleNotFoundException("ADMIN")
        );


        User adminUser = User.builder()
                .username("admin")
                .firstName("adminFirstName")
                .lastName("adminLastName")
                .email("admin_email@example.com")
                .password(passwordEncoder.encode("admin_password"))
                .role(adminRole)
                .build();

        userRepository.save(adminUser);
    }
}
