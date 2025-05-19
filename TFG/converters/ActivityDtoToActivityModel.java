package TFG.TFG.converters;

import TFG.TFG.dtos.ActivityDto;
import TFG.TFG.models.ActivityModel;
import org.springframework.core.convert.converter.Converter;

public class ActivityDtoToActivityModel implements Converter<ActivityDto, ActivityModel> {

    @Override
    public ActivityModel convert(ActivityDto source) {
        return new ActivityModel(source.getId(),source.getName(),source.getDescription(),source.getTime(),source.getDay(),
                source.getImage(),source.getDuration(),source.getPlace(),source.getType());
    }
}
