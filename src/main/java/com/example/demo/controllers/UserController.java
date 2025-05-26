package com.example.demo.controllers;

import com.example.demo.converters.ActivityDtoToActivityModel;
import com.example.demo.converters.RegisterDtoToUserModel;
import com.example.demo.converters.UserDtoToUserModel;
import com.example.demo.converters.UserModelToUserDto;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.facades.ActivityFacade;
import com.example.demo.facades.impl.DefaultUserFacade;
import com.example.demo.models.ActivityModel;
import com.example.demo.models.UserModel;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private DefaultUserFacade userFacade;
    @Resource
    private RegisterDtoToUserModel registerDtoToUserModel;
    @Resource
    private UserDtoToUserModel userDtoToUserModel;
    @Resource
    private UserModelToUserDto userModelToUserDto;
    @Resource
    private ActivityDtoToActivityModel activityDtoToActivityModel;
    @Resource
    private ActivityFacade activityFacade;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto) {
        try {
            UserModel userModel = userFacade.saveUser(Objects.requireNonNull(registerDtoToUserModel.convert(dto)));
            return ResponseEntity.ok("User registered successfully." + userModel);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem registering user.");
        }
    }

    @PatchMapping("/saveActivity/{userEmail}/{activityId}")
    public ResponseEntity<?> saveActivity(@PathVariable @NotBlank @Email String userEmail, @PathVariable @NotBlank @Positive Long activityId ) {
        UserModel user = userFacade.getUserByEmail(userEmail).get();
        ActivityModel activity = activityDtoToActivityModel.convert(activityFacade.getActivityById(activityId).get());
        user.getActivities().add(activity);
        if (userFacade.saveActivity(user)) {
            return ResponseEntity.ok("Activity registered successfully");
        }
        return ResponseEntity.badRequest().body("Problem registering activity.");
    }

    @GetMapping("/{email}")
    public UserDto listUser(@PathVariable @NotBlank @Email String email){
        return userModelToUserDto.convert(userFacade.getUserByEmail(email).get());
    }
}
