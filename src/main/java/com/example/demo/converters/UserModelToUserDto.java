package com.example.demo.converters;


import com.example.demo.dtos.ActivityDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.models.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserModelToUserDto implements Converter<UserModel, UserDto> {

    @Override
    public UserDto convert(UserModel userModel) {
        return new UserDto(userModel.getEmail(), userModel.getUsername(), userModel.getRole(), userModel.getPoints(),
                userModel.getLevel(), userModel.getActivities());
    }
}
