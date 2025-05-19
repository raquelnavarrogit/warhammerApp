package com.example.demo.converters;


import com.example.demo.dtos.UserDto;
import com.example.demo.models.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserModelToUserDto implements Converter<UserModel, UserDto> {

    @Override
    public UserDto convert(UserModel userModel) {
        return new UserDto(userModel.getEmail(), userModel.getUsername(), userModel.getPoints(),
                userModel.getLevel(), userModel.getActivities());
    }
}
