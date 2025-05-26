package com.example.demo.facades;



import com.example.demo.models.ActivityModel;
import com.example.demo.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserFacade {

    Optional<UserModel> getUserByEmail(String email);

    void saveUser(UserModel user);

    boolean saveActivity(UserModel user, ActivityModel activity);

    boolean deleteActivity(UserModel user, ActivityModel activity);
}
