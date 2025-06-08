package com.example.demo.service.impl;


import com.example.demo.daos.ActivityDao;
import com.example.demo.daos.UserDao;
import com.example.demo.models.UserModel;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    @Resource
    private final UserDao userDao;
    @Resource
    private final ActivityDao activityDao;

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return userDao.findById(email);
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return userDao.save(user);
    }

    @Override
    public boolean updateUserActivities(UserModel user) {
        try {
            userDao.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
