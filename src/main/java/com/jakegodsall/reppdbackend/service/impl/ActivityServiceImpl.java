package com.jakegodsall.reppdbackend.service.impl;

import com.jakegodsall.reppdbackend.entity.Activity;
import com.jakegodsall.reppdbackend.exceptions.ResourceNotFoundException;
import com.jakegodsall.reppdbackend.mappers.ActivityMapper;
import com.jakegodsall.reppdbackend.payload.ActivityDto;
import com.jakegodsall.reppdbackend.repository.ActivityRepository;
import com.jakegodsall.reppdbackend.service.ActivityService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    @Override
    public List<ActivityDto> getAllActivities() {
        // map List of entities to DTO and return
        return activityRepository.findAll().stream()
                .map(activityMapper::activityToActivityDto)
                .toList();
    }

    @Override
    public ActivityDto createActivity(ActivityDto activityDto) {
        // Create Entity from DTO
        Activity activity = activityMapper.activityDtoToActivity(activityDto);

        // Update fields
        LocalDateTime now = LocalDateTime.now();
        activity.setCreatedDate(now);
        activity.setLastModifiedDate(now);

        // Save Entity to db
        Activity savedActivity = activityRepository.save(activity);

        // Convert saved Entity to DTO and return
        return activityMapper.activityToActivityDto(savedActivity);
    }

    @Override
    public ActivityDto getActivityById(Long id) {
        // get Entity from the database
        Activity activity = activityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Activity", "id", id)
        );

        // Map Entity to DTO and return
        return activityMapper.activityToActivityDto(activity);

    }

    @Override
    public ActivityDto updateActivityById(ActivityDto activityDto, Long id) {
        // Get Entity from the db
        Activity activity = activityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Activity", "id", id)
        );

        // Update fields
        activity.setLastModifiedDate(LocalDateTime.now());
        activity.setName(activityDto.getName());

        // Save updated Entity to db
        Activity savedActivity = activityRepository.save(activity);

        // Map entity to DTO and return
        return activityMapper.activityToActivityDto(savedActivity);
    }

    @Override
    public void deleteActivityDtoById(Long id) {
        // Get Entity from db
        Activity activity = activityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Activity", "id", id)
        );

        // Delete the entity from db1
        activityRepository.delete(activity);
    }
}
