package com.example.demo.service;

import com.example.demo.dtos.RegisterDto;
import com.example.demo.models.UserModel;

import java.util.Optional;

public interface UserService {

        Optional<UserModel> getUserByEmail(String email);

        UserModel saveUser(String username, String email, String password);

        boolean saveActivity(String email, int activityId);

        boolean deleteActivity(String email, int activityId);

        void registerUser(RegisterDto registerDto);
    }
