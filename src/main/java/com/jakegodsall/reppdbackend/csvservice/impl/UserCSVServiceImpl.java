package com.jakegodsall.reppdbackend.csvservice.impl;

import com.jakegodsall.reppdbackend.csvrecord.UserCSVRecord;
import com.jakegodsall.reppdbackend.csvservice.UserCSVService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class UserCSVServiceImpl implements UserCSVService {
    @Override
    public List<UserCSVRecord> convertCSV(File csvFile) throws FileNotFoundException {
        return new CsvToBeanBuilder<UserCSVRecord>(new FileReader(csvFile))
                .withType(UserCSVRecord.class)
                .build().parse();
    }
}
