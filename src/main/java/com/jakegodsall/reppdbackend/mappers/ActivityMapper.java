package com.jakegodsall.reppdbackend.mappers;

import com.jakegodsall.reppdbackend.entity.Activity;
import com.jakegodsall.reppdbackend.payload.ActivityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityDto activityToActivityDto(Activity activity);
    Activity activityDtoToActivity(ActivityDto activityDto);
}
