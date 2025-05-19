package TFG.TFG.converters;

import TFG.TFG.dtos.UserDto;
import TFG.TFG.models.UserModel;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUserModel implements Converter<UserDto, UserModel> {

    @Override
    public UserModel convert(UserDto userDto) {
        return new UserModel(userDto.getEmail(),userDto.getUsername(),userDto.getLevel(),
                userDto.getPoints(),userDto.getActivities());
    }
}
