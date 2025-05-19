package com.example.demo.converters;


import com.example.demo.dtos.ActivityDto;
import com.example.demo.models.ActivityModel;
import org.springframework.core.convert.converter.Converter;

public class ActivityModelToActivityDto implements Converter<ActivityModel, ActivityDto> {

    @Override
    public ActivityDto convert(ActivityModel activityModel) {
        return new ActivityDto(activityModel.getId(),activityModel.getName(),
                activityModel.getDescription(),activityModel.getTime(),activityModel.getDay(),activityModel.getImage(),
                activityModel.getDuration(),activityModel.getPlace(),activityModel.getType());
    }
}
