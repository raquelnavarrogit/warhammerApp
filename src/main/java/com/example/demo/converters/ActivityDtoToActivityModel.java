package com.example.demo.converters;

import com.example.demo.dtos.ActivityDto;
import com.example.demo.models.ActivityModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ActivityDtoToActivityModel implements Converter<ActivityDto, ActivityModel> {

    @Override
    public ActivityModel convert(ActivityDto source) {
        return new ActivityModel(source.getId(),source.getName(),source.getDescription(),source.getTime(),source.getDay(),
                source.getImage(),source.getDuration(),source.getPlace(),source.getType());
    }
}
