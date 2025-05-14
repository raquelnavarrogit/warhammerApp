package TFG.TFG.facades;

import TFG.TFG.models.UserModel;

import java.util.Optional;

public interface UserFacade {

    boolean login(String email, String password);

    Optional<UserModel> getUserByEmail(String email);

    UserModel saveUser(String username, String email, String password);

    boolean saveActivity(String email, int activityId);

    boolean deleteActivity(String email, int activityId);
}
