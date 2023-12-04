package com.jakegodsall.reppdbackend.service;

import com.jakegodsall.reppdbackend.payload.UserCSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface UserCSVService  {
    List<UserCSVRecord> convertCSV(File csvFile) throws FileNotFoundException;
}
