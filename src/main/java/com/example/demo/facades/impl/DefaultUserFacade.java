package com.example.demo.facades.impl;

import com.example.demo.converters.UserDtoToUserModel;
import com.example.demo.converters.UserModelToUserDto;
import com.example.demo.dtos.RegisterDto;
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
    public Optional<UserModel> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserModel saveUser(String username, String email, String password) {
        return null;
    }

    @Override
    public boolean saveActivity(String email, int activityId) {
        return false;
    }

    @Override
    public boolean deleteActivity(String email, int activityId) {
        return false;
    }

    @Override
    public void registerUser(RegisterDto registerDto) {
        userService.registerUser(registerDto);
    }
}
