package TFG.TFG.facades;

import TFG.TFG.dtos.ActivityDto;
import TFG.TFG.models.ActivityModel;

import java.util.List;
import java.util.Optional;

public interface ActivityFacade {

    public Optional<ActivityDto> getActivityById(int activityId);

    public List<ActivityDto> getAllActivities();
}
