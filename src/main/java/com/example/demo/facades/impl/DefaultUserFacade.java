package com.example.demo.facades.impl;

import com.example.demo.converters.UserDtoToUserModel;
import com.example.demo.converters.UserModelToUserDto;
import com.example.demo.facades.UserFacade;
import com.example.demo.models.UserModel;
import com.example.demo.service.impl.DefaultUserService;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {

    @Resource
    private final DefaultUserService userService;
    @Resource
    private final UserDtoToUserModel userDtoToUserModel;
    @Resource
    private final UserModelToUserDto userModelToUserDto;

    @Override
    public UserModel saveUser(UserModel user) {
        Optional<UserModel> userModel = userService.getUserByEmail(user.getEmail());
        userModel.ifPresent(u -> {
            throw new IllegalArgumentException("Email already registered.");
        });
        return userService.saveUser(user);
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public boolean updateUserActivities(UserModel user) {
        return userService.updateUserActivities(user);
    }
}
