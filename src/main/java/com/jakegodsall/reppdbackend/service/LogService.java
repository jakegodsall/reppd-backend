package com.jakegodsall.reppdbackend.service;

import com.jakegodsall.reppdbackend.payload.LogDto;

import java.util.List;

public interface LogService {
    List<LogDto> getAllLogs();
    LogDto createLog(LogDto logDto);
    LogDto getLogById(Long id);
    LogDto updateLogById(LogDto logDto, Long id);
    void deleteLogById(Long id);
}
