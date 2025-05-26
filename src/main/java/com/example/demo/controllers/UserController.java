package com.example.demo.controllers;

import com.example.demo.converters.ActivityDtoToActivityModel;
import com.example.demo.converters.RegisterDtoToUserModel;
import com.example.demo.converters.UserDtoToUserModel;
import com.example.demo.dtos.ActivityDto;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.facades.impl.DefaultUserFacade;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private DefaultUserFacade userFacade;
    @Resource
    private RegisterDtoToUserModel registerDtoToUserModel;
    @Resource
    private UserDtoToUserModel userDtoToUserModel;
    @Resource
    private ActivityDtoToActivityModel activityDtoToActivityModel;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto) {
        try {
            userFacade.saveUser(Objects.requireNonNull(registerDtoToUserModel.convert(dto)));
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem registering user.");
        }
    }

    @PatchMapping("/saveActivity")
    public ResponseEntity<?> saveActivity(@RequestBody @Valid UserDto userDto, @RequestBody @Valid ActivityDto activityDto) { //esto está mal. Tengo que ver cuál de los dos quiero completo y cuál solo el id.
        if (userFacade.saveActivity(userDtoToUserModel.convert(userDto), activityDtoToActivityModel.convert(activityDto))) {
            return ResponseEntity.ok("Activity registered successfully");
        }
        return ResponseEntity.badRequest().body("Problem registering activity.");
    }
}
