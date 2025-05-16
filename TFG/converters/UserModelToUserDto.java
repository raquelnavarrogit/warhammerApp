package TFG.TFG.converters;

import TFG.TFG.dtos.UserDto;
import TFG.TFG.models.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserModelToUserDto implements Converter<UserModel, UserDto> {

    @Override
    public UserDto convert(UserModel userModel) {
        return new UserDto(userModel.getEmail(), userModel.getUsername(), userModel.getPoints(),
                userModel.getLevel(), userModel.getActivities());
    }
}
