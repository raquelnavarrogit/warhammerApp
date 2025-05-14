package TFG.TFG.service;

import TFG.TFG.models.ActivityModel;

import java.util.List;

public interface ActivityService {

    boolean saveActivity(int activityId, String email);

    boolean deleteActivity(int activityId, String email);

    ActivityModel getActivityById(int activityId);

    List<ActivityModel> getAllActivities();
}
