package com.example.demo.service.impl;


import com.example.demo.daos.ActivityDao;
import com.example.demo.daos.UserDao;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.models.ActivityModel;
import com.example.demo.models.UserModel;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    @Resource
    private final UserDao userDao;
    @Resource
    private ActivityDao activityDao;
//    @Resource
//    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return userDao.findById(email);
    }

    @Override
    public UserModel saveUser(UserModel user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public boolean saveActivity(UserModel user) {
        try {
            userDao.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
