package com.jakegodsall.reppdbackend.bootstrap;

import com.jakegodsall.reppdbackend.entity.Competency;
import com.jakegodsall.reppdbackend.entity.auth.Authority;
import com.jakegodsall.reppdbackend.entity.auth.Role;
import com.jakegodsall.reppdbackend.entity.auth.User;
import com.jakegodsall.reppdbackend.csvrecord.UserCSVRecord;
import com.jakegodsall.reppdbackend.exceptions.AuthorityNotFoundException;
import com.jakegodsall.reppdbackend.exceptions.ResourceNotFoundException;
import com.jakegodsall.reppdbackend.exceptions.RoleNotFoundException;
import com.jakegodsall.reppdbackend.repository.CompetencyRepository;
import com.jakegodsall.reppdbackend.repository.security.AuthorityRepository;
import com.jakegodsall.reppdbackend.repository.security.RoleRepository;
import com.jakegodsall.reppdbackend.repository.security.UserRepository;
import com.jakegodsall.reppdbackend.csvservice.UserCSVService;
import com.sun.source.doctree.AuthorTree;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@AllArgsConstructor
@Order(2)
@Component
public class DataInitializer implements CommandLineRunner {

    private static Random random = new Random();

    private final UserRepository userRepository;
    private final UserCSVService userCSVService;
    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() < 2)
            loadUsersFromCsv();
    }



    private void loadUsersFromCsv() throws FileNotFoundException {
        // Get the USER role
        Role userRole = roleRepository.getRoleByName("USER").orElseThrow(
                () -> new RoleNotFoundException("USER")
        );

        // Load csv into memory and get a list of records
        File file = ResourceUtils.getFile("classpath:dummydata/random_user_accounts.csv");
        List<UserCSVRecord> recs = userCSVService.convertCSV(file);

        // iterate through records in the CSV
        recs.forEach(userCSVRecord -> {
            // Build user object
            User user = User.builder()
                    .username(userCSVRecord.getUsername())
                    .firstName(userCSVRecord.getFirstName())
                    .lastName(userCSVRecord.getLastName())
                    .email(userCSVRecord.getEmail())
                    .password(passwordEncoder.encode(userCSVRecord.getPassword()))
                    .role(userRole)
                    .build();

            // Add three random competencies to the current User model
            for (int i = 0; i < 3; i++) {
                user.addCompetency(getRandomCompetency());
            }

            userRepository.save(user);

            System.out.println("User: " + user.getUsername());
            System.out.println("Roles: " + user.getRoles());
            System.out.println("Competencies: " + user.getCompetencies());
        });

    }

    private List<Competency> createExampleCompetencySet() {

        List<Competency> competencyList = new ArrayList<>();

        competencyList.add(Competency.builder()
                .name("Spanish")
                .description("Proficiency in the Spanish language")
                .build());

        competencyList.add(Competency.builder()
                .name("Python Programming")
                .description("Skills in Python programming language")
                .build());

        competencyList.add(Competency.builder()
                .name("Public Speaking")
                .description("Ability to speak effectively in public settings")
                .build());

        competencyList.add(Competency.builder()
                .name("Photography")
                .description("Expertise in capturing photos")
                .build());

        competencyList.add(Competency.builder()
                .name("Project Management")
                .description("Skills in managing projects efficiently")
                .build());

        competencyList.add(Competency.builder()
                .name("Piano Playing")
                .description("Ability to play the piano")
                .build());

        competencyList.add(Competency.builder()
                .name("Java Programming")
                .description("Proficiency in Java programming language")
                .build());

        competencyList.add(Competency.builder()
                .name("Web Development")
                .description("Skills in creating and maintaining websites")
                .build());

        competencyList.add(Competency.builder()
                .name("Machine Learning")
                .description("Knowledge in machine learning concepts and applications")
                .build());

        competencyList.add(Competency.builder()
                .name("Gardening")
                .description("Experience in gardening and plant care")
                .build());

        competencyList.add(Competency.builder()
                .name("French")
                .description("Proficiency in the French language")
                .build());

        competencyList.add(Competency.builder()
                .name("Chess Playing")
                .description("Skills in playing and strategizing in chess")
                .build());

        competencyList.add(Competency.builder()
                .name("Financial Analysis")
                .description("Expertise in analyzing financial data")
                .build());

        competencyList.add(Competency.builder()
                .name("Graphic Design")
                .description("Creativity and skills in graphic design")
                .build());

        competencyList.add(Competency.builder()
                .name("Baking")
                .description("Experience and skills in baking")
                .build());

        competencyList.add(Competency.builder()
                .name("JavaScript")
                .description("Skills in JavaScript programming language")
                .build());

        competencyList.add(Competency.builder()
                .name("Yoga Instruction")
                .description("Ability to instruct and lead yoga sessions")
                .build());

        competencyList.add(Competency.builder()
                .name("Carpentry")
                .description("Skills in woodworking and carpentry")
                .build());

        competencyList.add(Competency.builder()
                .name("Social Media Marketing")
                .description("Expertise in marketing through social media platforms")
                .build());

        competencyList.add(Competency.builder()
                .name("Data Analysis")
                .description("Proficiency in analyzing and interpreting data")
                .build());

        return competencyList;
    }

    private Competency getRandomCompetency() {
        List<Competency> competencyList = createExampleCompetencySet();
        Competency randomCompetency
                = competencyList.get(random.nextInt(competencyList.size()));
        return Competency.builder()
                .name(randomCompetency.getName())
                .description(randomCompetency.getDescription())
                .build();
    }


}
