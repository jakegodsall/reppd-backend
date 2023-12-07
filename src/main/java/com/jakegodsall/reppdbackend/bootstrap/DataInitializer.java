package com.jakegodsall.reppdbackend.bootstrap;

import com.jakegodsall.reppdbackend.entity.auth.Authority;
import com.jakegodsall.reppdbackend.entity.auth.User;
import com.jakegodsall.reppdbackend.csvrecord.UserCSVRecord;
import com.jakegodsall.reppdbackend.exceptions.ResourceNotFoundException;
import com.jakegodsall.reppdbackend.repository.security.AuthorityRepository;
import com.jakegodsall.reppdbackend.repository.security.UserRepository;
import com.jakegodsall.reppdbackend.csvservice.UserCSVService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserCSVService userCSVService;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        setAuthorities();
        loadUsersFromCsv();
    }

    private void setAuthorities() {
        if (authorityRepository.count() == 0) {
            authorityRepository.save(new Authority("ROLE_USER"));
            authorityRepository.save(new Authority("ROLE_ADMIN"));
        }
    }

    private void loadUsersFromCsv() throws FileNotFoundException {
        if (userRepository.count() < 10) {
            File file = ResourceUtils.getFile("classpath:dummydata/random_user_accounts.csv");

            List<UserCSVRecord> recs = userCSVService.convertCSV(file);

            recs.forEach(userCSVRecord -> {
                Set<Authority> authorities = new HashSet<>();
                authorities.add(authorityRepository.findByRole("ROLE_ADMIN").orElseThrow(
                        () -> new ResourceNotFoundException("Authority", "role", 1L)
                ));

                userRepository.save(User.builder()
                        .username(userCSVRecord.getUsername())
                        .firstName(userCSVRecord.getFirstName())
                        .lastName(userCSVRecord.getLastName())
                        .email(userCSVRecord.getEmail())
                        .password(passwordEncoder.encode(userCSVRecord.getPassword()))
                        .authorities(authorities)
                        .build());

                System.out.println("User: " + userCSVRecord.getUsername() + " added.");
            });
        }
    }

}
