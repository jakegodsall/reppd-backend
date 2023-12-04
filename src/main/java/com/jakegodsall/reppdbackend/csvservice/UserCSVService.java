package com.jakegodsall.reppdbackend.csvservice;

import com.jakegodsall.reppdbackend.csvrecord.UserCSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface UserCSVService  {
    List<UserCSVRecord> convertCSV(File csvFile) throws FileNotFoundException;
}
