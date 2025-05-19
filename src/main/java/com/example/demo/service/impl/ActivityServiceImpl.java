package com.example.demo.service.impl;


import com.example.demo.daos.ActivityDao;
import com.example.demo.daos.UserDao;
import com.example.demo.models.ActivityModel;
import com.example.demo.service.ActivityService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private final ActivityDao activityDao;

    private final UserDao userDao;

    @Override
    public Optional<ActivityModel> getActivityById(int activityId) {
        return activityDao.getActivityModelById(activityId);
    }

    @Override
    public List<ActivityModel> getAllActivities() {
        return activityDao.findAll();
    }
}
