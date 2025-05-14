package TFG.TFG.service.impl;

import TFG.TFG.daos.ActivityDao;
import TFG.TFG.daos.UserDao;
import TFG.TFG.models.ActivityModel;
import TFG.TFG.models.UserModel;
import TFG.TFG.service.ActivityService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private final ActivityDao activityDao;

    private final UserDao userDao;

    @Override
    public boolean saveActivity(int activityId, String email) {
        activityDao.getActivityModelById(activityId);
        UserModel user = userDao.findById(email).get();
        try{
            user.getActivities().add(activityDao.getActivityModelById(activityId));
            userDao.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteActivity(int activityId, String email) {
        return false;
    }

    @Override
    public ActivityModel getActivityById(int activityId) {
        return null;
    }

    @Override
    public List<ActivityModel> getAllActivities() {
        return List.of();
    }
}
