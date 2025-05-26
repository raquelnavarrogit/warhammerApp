package com.example.demo.converters;

import com.example.demo.dtos.RegisterDto;
import com.example.demo.models.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RegisterDtoToUserModel implements Converter<RegisterDto, UserModel> {

    @Override
    public UserModel convert(RegisterDto dto) {
        return new UserModel(dto.getEmail(),dto.getUsername(),dto.getPassword());
    }
}
