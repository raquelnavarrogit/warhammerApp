package com.example.demo.controllers;

import com.example.demo.converters.ActivityDtoToActivityModel;
import com.example.demo.converters.ActivityModelToActivityDto;
import com.example.demo.dtos.ActivityDto;
import com.example.demo.facades.impl.ActivityFacadeImpl;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/activity")
@Validated
public class ActivityController {

    @Resource
    private ActivityFacadeImpl activityFacade;
    @Resource
    private ActivityDtoToActivityModel activityDtoToActivityModel;
    @Resource
    private ActivityModelToActivityDto activityModelToActivityDto;

    @GetMapping("/{id}")
    public ActivityDto getActivityById(@PathVariable Long id) {
        Optional<ActivityDto> activityDto = activityFacade.getActivityById(id);
        return activityDto.orElseThrow(() -> new IllegalArgumentException("Activity not found."));
    }

    @GetMapping
    public Iterable<ActivityDto> getAllActivities() {
        return activityFacade.getAllActivities();
    }
}
