package TFG.TFG.service;

import TFG.TFG.models.ActivityModel;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    Optional<ActivityModel> getActivityById(int activityId);

    List<ActivityModel> getAllActivities();
}
