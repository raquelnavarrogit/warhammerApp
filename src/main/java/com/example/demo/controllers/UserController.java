package com.example.demo.controllers;

import com.example.demo.converters.ActivityDtoToActivityModel;
import com.example.demo.converters.ActivityModelToActivityDto;
import com.example.demo.converters.RegisterDtoToUserModel;
import com.example.demo.converters.UserModelToUserDto;
import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.dtos.SaveActivityDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.facades.impl.ActivityFacadeImpl;
import com.example.demo.facades.impl.DefaultUserFacade;
import com.example.demo.models.ActivityModel;
import com.example.demo.models.Role;
import com.example.demo.models.UserModel;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private DefaultUserFacade userFacade;
    @Resource
    private RegisterDtoToUserModel registerDtoToUserModel;
    @Resource
    private ActivityDtoToActivityModel activityDtoToActivityModel;
    @Resource
    private ActivityModelToActivityDto  activityModelToActivityDto;
    @Resource
    private ActivityFacadeImpl activityFacade;

    private UserModel user;
    private ActivityModel activity;
    @Autowired
    private UserModelToUserDto userModelToUserDto;

    /**
     * EndPoint that logs the user in.
     * @param loginDto it must contain user email and user password.
     * @param session it is provided by default. No need to add it yourself.
     * @return a ResponseEntity String with the outcome.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto, HttpSession session) {

        Optional<UserModel> user = userFacade.getUserByEmail(loginDto.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(loginDto.getPassword())) {
            session.setAttribute("user", user.get().getEmail());
            return ResponseEntity.ok().body("User logged in");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
    }

    /**
     * Endpoint to register a new user.
     * @param dto that must contain username, user email and user password.
     * @return a ResponseEntity with a bad outcome or the user details as a confirmation.
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

    /**
     * Endpoint to save an activity for a user.
     * @param dto that must contain activityId and user email.
     * @return a ResponseEntity with the outcome.
     */
    @PostMapping("/saveActivity")
    public ResponseEntity<?> saveActivity(@RequestBody @Valid SaveActivityDto dto) {

        String userEmail = dto.getUserEmail();
        long activityId = dto.getActivityId();

        try {
            user = userFacade.getUserByEmail(userEmail).get();
            activity = activityDtoToActivityModel.convert(activityFacade.getActivityById(activityId).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem getting user or activity.");
        }

        if (user.getRole()!= Role.LOGGED_USER && user.getRole() != Role.ADMIN) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }

        for (ActivityModel activityModel : user.getActivities()) {
            if (activityModel.getId() == activityId) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Activity already exists in your list.");
            }
        }

        if (activity.getPlace() - 1 < 0){
            return ResponseEntity.badRequest().body("This activity is not available");
        }

        user.getActivities().add(activity);
        if (userFacade.updateUserActivities(user)) {

            activity.setPlace(activity.getPlace()-1);
            activityFacade.updateActivity(activityModelToActivityDto.convert(activity));
            return ResponseEntity.ok("Activity registered successfully");
        }
        return ResponseEntity.badRequest().body("Problem registering activity.");
    }

    /**
     * Endpoint to get a specific user based on his session.
     * @param session it means the cookie that contains de sessionId.
     * @return a ResponseEntity with a not logged outcome, or it will return the user object.
     */
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(HttpSession session) {
        Object ActualUser = session.getAttribute("user");

        if (ActualUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not logged in.");
        }

        UserModel userModel = userFacade.getUserByEmail(ActualUser.toString()).orElse(null);
        UserDto userDto =  userModelToUserDto.convert(userModel);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Endpoint to delete an activity for a user.
     * @param dto that must contain activityId and user email.
     * @return a ResponseEntity with the outcome.
     */
    @PostMapping("/deleteActivity")
    public ResponseEntity<?> deleteActivity(@RequestBody @Valid SaveActivityDto dto) {

        String userEmail = dto.getUserEmail();
        long activityId = dto.getActivityId();

        try {
            user = userFacade.getUserByEmail(userEmail).get();
            activity = activityDtoToActivityModel.convert(activityFacade.getActivityById(activityId).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem getting user or activity.");
        }

        if (user.getActivities().removeIf(a -> a.getId().equals(activity.getId()))) {
            if (userFacade.updateUserActivities(user)) {
                activity.setPlace(activity.getPlace()+1);
                activityFacade.updateActivity(activityModelToActivityDto.convert(activity));
                return ResponseEntity.ok("Activity deleted successfully");
            }
        }

        return ResponseEntity.badRequest().body("Problem deleting activity.");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("User logged out successfully.");
    }

    @PostMapping("/guest")
    public ResponseEntity<String> guest(HttpSession session) {
        try{
            ArrayList<ActivityModel> guestList = new ArrayList<>();
            UserModel guest = new UserModel("guest@gmail.com","guest","123",0,"",Role.GUEST, guestList);
            session.setAttribute("user", guest);
            return ResponseEntity.ok("Guest logged successfully.");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Problem logging as guest.");
        }
    }
}
