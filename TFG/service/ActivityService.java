package TFG.TFG.service;

import TFG.TFG.models.ActivityModel;

import java.util.List;

public interface ActivityService {

    ActivityModel getActivityById(int activityId);

    List<ActivityModel> getAllActivities();
}
