package com.example.demo.controllers;

import com.example.demo.converters.ActivityDtoToActivityModel;
import com.example.demo.converters.RegisterDtoToUserModel;
import com.example.demo.converters.UserDtoToUserModel;
import com.example.demo.converters.UserModelToUserDto;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.dtos.SaveActivityDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.facades.impl.ActivityFacadeImpl;
import com.example.demo.facades.impl.DefaultUserFacade;
import com.example.demo.models.ActivityModel;
import com.example.demo.models.UserModel;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    private ActivityFacadeImpl activityFacade;

    private UserModel user;
    private ActivityModel activity;

    /*
    Endpoint to register a new user.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto) {
        try {
           user = userFacade.saveUser(Objects.requireNonNull(registerDtoToUserModel.convert(dto)));
            return ResponseEntity.ok("User registered successfully." + user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem registering user.");
        }
    }

    /*
    Endpoint to save an activity for a user.
     */
    @PostMapping("/saveActivity")
    public ResponseEntity<?> saveActivity(@RequestBody @Valid SaveActivityDto dto) {

        String userEmail = dto.getUserEmail();
        long activityId = dto.getActivityId();

        try{
           user = userFacade.getUserByEmail(userEmail).get();
           activity = activityDtoToActivityModel.convert(activityFacade.getActivityById(activityId).get());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Problem getting user or activity.");
        }

        user.getActivities().add(activity);
        if (userFacade.saveActivity(user)) {
            return ResponseEntity.ok("Activity registered successfully");
        }
        return ResponseEntity.badRequest().body("Problem registering activity.");
    }

    /*
    Endpoint to get a user by email.
     */
    @GetMapping("/{email}")
    public UserDto listUser(@PathVariable @NotBlank @Email String email) {
        try{
            return userModelToUserDto.convert(userFacade.getUserByEmail(email).get());
        }catch (Exception e){
            return new UserDto();
        }
    }

    /*
    Endpoint to delete an activity for a user.
     */
    @PostMapping("/deleteActivity")
    public ResponseEntity<?> deleteActivity(@RequestBody @Valid SaveActivityDto dto) {

        String userEmail = dto.getUserEmail();
        long activityId = dto.getActivityId();

        try{
            user = userFacade.getUserByEmail(userEmail).get();
            activity = activityDtoToActivityModel.convert(activityFacade.getActivityById(activityId).get());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Problem getting user or activity.");
        }

        if (user.getActivities().removeIf(a -> a.getId().equals(activity.getId()))){
            if (userFacade.saveActivity(user)) {
                return ResponseEntity.ok("Activity deleted successfully");
            }
        }

        return ResponseEntity.badRequest().body("Problem deleting activity.");
    }
}
