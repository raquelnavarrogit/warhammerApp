package TFG.TFG.service;

import TFG.TFG.models.UserModel;

import java.util.Optional;

public interface UserService {

        boolean login(String email, String password);

        Optional<UserModel> getUserByEmail(String email);

        boolean saveUser(String username, String email, String password);

        boolean saveActivity(String email, int activityId);

        boolean deleteActivity(String email, int activityId);
    }
