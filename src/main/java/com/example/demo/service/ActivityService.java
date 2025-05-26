package com.example.demo.service;


import com.example.demo.models.ActivityModel;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    Optional<ActivityModel> getActivityById(Long activityId);

    List<ActivityModel> getAllActivities();
}
