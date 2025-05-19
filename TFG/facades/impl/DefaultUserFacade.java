package TFG.TFG.facades.impl;

import TFG.TFG.converters.UserDtoToUserModel;
import TFG.TFG.converters.UserModelToUserDto;
import TFG.TFG.facades.UserFacade;
import TFG.TFG.models.UserModel;
import TFG.TFG.service.impl.DefaultUserService;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {

    @Resource
    private final DefaultUserService userService;
    @Resource
    private final UserDtoToUserModel userDtoToUserModel;
    @Resource
    private final UserModelToUserDto userModelToUserDto;

    @Override
    public boolean login(String email, String password) {return false;}

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserModel saveUser(String username, String email, String password) {
        return null;
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
