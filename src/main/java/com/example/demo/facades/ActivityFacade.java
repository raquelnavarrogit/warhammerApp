package com.example.demo.facades;

import com.example.demo.dtos.ActivityDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActivityFacade {

    public Optional<ActivityDto> getActivityById(Long activityId);

    public List<ActivityDto> getAllActivities();
}
