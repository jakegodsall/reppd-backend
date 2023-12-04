package com.jakegodsall.reppdbackend.service.impl;

import com.jakegodsall.reppdbackend.payload.UserCSVRecord;
import com.jakegodsall.reppdbackend.service.UserCSVService;
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
