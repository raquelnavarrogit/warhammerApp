package TFG.TFG.service.impl;

import TFG.TFG.daos.UserDao;
import TFG.TFG.models.UserModel;
import TFG.TFG.service.UserService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    @Resource
    private final UserDao userDao;

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean saveUser(String username, String email, String password) {
        return false;
    }

    @Override
    public boolean saveActivity(String email, int activityId) {
        return false;
    }

    @Override
    public boolean deleteActivity(String email, int activityId) {
        return false;
    }
}
