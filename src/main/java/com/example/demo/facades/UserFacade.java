package com.example.demo.facades;



import com.example.demo.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserFacade {

    boolean login(String email, String password);

    Optional<UserModel> getUserByEmail(String email);

    UserModel saveUser(String username, String email, String password);

    boolean saveActivity(String email, int activityId);

    boolean deleteActivity(String email, int activityId);
}
