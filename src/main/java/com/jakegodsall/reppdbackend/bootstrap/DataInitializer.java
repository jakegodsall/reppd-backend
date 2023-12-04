package com.jakegodsall.reppdbackend.bootstrap;

import com.jakegodsall.reppdbackend.entity.User;
import com.jakegodsall.reppdbackend.payload.UserCSVRecord;
import com.jakegodsall.reppdbackend.repository.ActivityRepository;
import com.jakegodsall.reppdbackend.repository.CompetencyRepository;
import com.jakegodsall.reppdbackend.repository.LogRepository;
import com.jakegodsall.reppdbackend.repository.UserRepository;
import com.jakegodsall.reppdbackend.service.UserCSVService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
                        .firstName(userCSVRecord.getFirstName())
                        .lastName(userCSVRecord.getLastName())
                        .email(userCSVRecord.getEmail())
                        .password(userCSVRecord.getPassword())
                        .build());
            });
        }
    }

}
