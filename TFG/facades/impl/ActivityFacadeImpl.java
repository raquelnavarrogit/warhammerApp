package TFG.TFG.facades.impl;

import TFG.TFG.converters.ActivityDtoToActivityModel;
import TFG.TFG.converters.ActivityModelToActivityDto;
import TFG.TFG.dtos.ActivityDto;
import TFG.TFG.facades.ActivityFacade;
import TFG.TFG.service.impl.ActivityServiceImpl;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<ActivityDto> getActivityById(int activityId) {
        return activityService.getActivityById(activityId)
                              .map(activityModelToActivityDto::convert);
    }

    @Override
    public List<ActivityDto> getAllActivities() {
        List<ActivityDto> activities = new ArrayList<>();
        activityService.getAllActivities()
                       .forEach(activityModel -> activities.add(activityModelToActivityDto.convert(activityModel)));
        return activities;
    }
}
