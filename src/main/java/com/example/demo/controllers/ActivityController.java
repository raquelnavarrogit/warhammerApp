package com.example.demo.controllers;

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

    /**
     * Endpoint to get a specific activity based on the id.
     * @param id activity id.
     * @return activityDto that contains id, name, description, time, day, image, duration, place and type.
     */
    @GetMapping("/{id}")
    public ActivityDto getActivityById(@PathVariable Long id) {
        Optional<ActivityDto> activityDto = activityFacade.getActivityById(id);
        return activityDto.orElseThrow(() -> new IllegalArgumentException("Activity not found."));
    }

    /**
     * Endpoints to get the activities' list.
     * @return activities' list.
     */
    @GetMapping
    public Iterable<ActivityDto> getAllActivities() {
        return activityFacade.getAllActivities();
    }
}
