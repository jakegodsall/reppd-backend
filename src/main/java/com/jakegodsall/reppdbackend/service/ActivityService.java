package com.jakegodsall.reppdbackend.service;

import com.jakegodsall.reppdbackend.payload.ActivityDto;

import java.util.List;

public interface ActivityService {
    List<ActivityDto> getAllActivities();
    ActivityDto createActivity(ActivityDto activityDto);
    ActivityDto getActivityById(Long id);
    ActivityDto updateActivityById(ActivityDto activityDto, Long id);
    void deleteActivityDtoById(Long id);
}
