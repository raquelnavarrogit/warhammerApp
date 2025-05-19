package com.example.demo.facades;

import com.example.demo.dtos.ActivityDto;

import java.util.List;
import java.util.Optional;

public interface ActivityFacade {

    public Optional<ActivityDto> getActivityById(int activityId);

    public List<ActivityDto> getAllActivities();
}
