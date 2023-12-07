package com.jakegodsall.reppdbackend.bootstrap;

import com.jakegodsall.reppdbackend.entity.auth.User;
import com.jakegodsall.reppdbackend.csvrecord.UserCSVRecord;
import com.jakegodsall.reppdbackend.repository.ActivityRepository;
import com.jakegodsall.reppdbackend.repository.CompetencyRepository;
import com.jakegodsall.reppdbackend.repository.LogRepository;
import com.jakegodsall.reppdbackend.repository.security.UserRepository;
import com.jakegodsall.reppdbackend.csvservice.UserCSVService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private ActivityRepository activityRepository;
    private CompetencyRepository competencyRepository;
    private LogRepository logRepository;
    private UserRepository userRepository;
    private UserCSVService userCSVService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadUsersFromCsv();
    }

    private void loadUsersFromCsv() throws FileNotFoundException {
        if (userRepository.count() < 10) {
            File file = ResourceUtils.getFile("classpath:dummydata/random_user_accounts.csv");

            List<UserCSVRecord> recs = userCSVService.convertCSV(file);

            recs.forEach(userCSVRecord -> {
                userRepository.save(User.builder()
                        .username(userCSVRecord.getUsername())
                        .firstName(userCSVRecord.getFirstName())
                        .lastName(userCSVRecord.getLastName())
                        .email(userCSVRecord.getEmail())
                        .password(userCSVRecord.getPassword())
                        .build());
            });
        }
    }

}
