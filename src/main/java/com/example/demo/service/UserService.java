package com.example.demo.service;

import com.example.demo.models.UserModel;

import java.util.Optional;

public interface UserService {

    Optional<UserModel> getUserByEmail(String email);

    UserModel saveUser(UserModel user);

    boolean updateUserActivities(UserModel user);
}
