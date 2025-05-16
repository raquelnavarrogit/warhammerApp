package TFG.TFG.facades;

import TFG.TFG.models.ActivityModel;

import java.util.List;

public interface ActivityFacade {

    public ActivityModel getActivityById(int activityId);

    public List<ActivityModel> getAllActivities();
}
