package com.example.demo.converters;


import com.example.demo.dtos.UserDto;
import com.example.demo.models.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserModel implements Converter<UserDto, UserModel> {

    @Override
    public UserModel convert(UserDto userDto) {
        return new UserModel(userDto.getEmail(),userDto.getUsername(),userDto.getLevel(),
                userDto.getPoints(),userDto.getActivities());
    }
}
