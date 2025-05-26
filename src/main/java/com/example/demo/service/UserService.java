package com.example.demo.service;

import com.example.demo.models.ActivityModel;
import com.example.demo.models.UserModel;

import java.util.Optional;

public interface UserService {

        Optional<UserModel> getUserByEmail(String email);

        UserModel saveUser(UserModel user);

        boolean saveActivity(UserModel user);
    }
