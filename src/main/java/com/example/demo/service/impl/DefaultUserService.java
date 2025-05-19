package com.example.demo.service.impl;


import com.example.demo.daos.UserDao;
import com.example.demo.models.ActivityModel;
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

    @Override
    public boolean login(String email, String password) {
        //password stuff logic.
        return false;
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return userDao.findById(email);
    }

    @Override
    public UserModel saveUser(String username, String email, String password) {
        UserModel user = new UserModel();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return userDao.save(user);
    }

    @Override
    public boolean saveActivity(String email, int activityId) {
        UserModel user = userDao.findById(email).get();
        ActivityModel activity = user.getActivities()
                .stream()
                .filter(a -> a.getId() == activityId)
                .findFirst()
                .orElse(null);
        try {
            user.getActivities().add(activity);
            userDao.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteActivity(String email, int activityId) {
        UserModel user = userDao.findById(email).get();
        ActivityModel activity = user.getActivities()
                .stream()
                .filter(a -> a.getId() == activityId)
                .findFirst()
                .orElse(null);
        try{
            user.getActivities().remove(activity);
            userDao.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
