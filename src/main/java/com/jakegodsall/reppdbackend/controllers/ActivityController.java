package com.jakegodsall.reppdbackend.controllers;

import com.jakegodsall.reppdbackend.payload.ActivityDto;
import com.jakegodsall.reppdbackend.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class ActivityController {

    private static final String API_V1_LIST = "/api/v1/activities";
    private static final String API_V1_ID = "/api/v1/activities/{id}";

    private final ActivityService activityService;

    @GetMapping(API_V1_LIST)
    public ResponseEntity<List<ActivityDto>> getAllActivities() {
        List<ActivityDto> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PostMapping(API_V1_LIST)
    public ResponseEntity<ActivityDto> createActivity(@RequestBody ActivityDto activityDto) {
        ActivityDto createdActivity = activityService.createActivity(activityDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdActivity.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdActivity);
    }

    @GetMapping(API_V1_ID)
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        ActivityDto activity = activityService.getActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PutMapping(API_V1_ID)
    public ResponseEntity<ActivityDto> updateActivityById(
            @RequestBody ActivityDto activityDto,
            @PathVariable Long id) {
        ActivityDto updatedActivity = activityService.updateActivityById(activityDto, id);
        return new ResponseEntity<>(updatedActivity, HttpStatus.OK);
    }

    @DeleteMapping(API_V1_ID)
    public ResponseEntity<Void> deleteActivityById(@PathVariable Long id) {
        activityService.deleteActivityDtoById(id);
        return ResponseEntity.noContent().build();
    }
}
