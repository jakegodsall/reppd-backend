package com.jakegodsall.reppdbackend.payload;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class UserCSVRecord {
    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String password;
}
