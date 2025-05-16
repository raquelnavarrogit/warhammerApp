package TFG.TFG.facades.impl;

import TFG.TFG.converters.ActivityDtoToActivityModel;
import TFG.TFG.converters.ActivityModelToActivityDto;
import TFG.TFG.facades.ActivityFacade;
import TFG.TFG.models.ActivityModel;
import TFG.TFG.service.impl.ActivityServiceImpl;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.List;
@Getter
@RequiredArgsConstructor
public class ActivityFacadeImpl implements ActivityFacade {

    @Resource
    private final ActivityServiceImpl activityService;
    @Resource
    private final ActivityModelToActivityDto activityModelToActivityDto;
    @Resource
    private final ActivityDtoToActivityModel activityDtoToActivityModel;

    @Override
    public ActivityModel getActivityById(int activityId) {
        return null;
    }

    @Override
    public List<ActivityModel> getAllActivities() {
        return List.of();
    }
}
