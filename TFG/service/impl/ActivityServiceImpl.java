package TFG.TFG.service.impl;

import TFG.TFG.daos.ActivityDao;
import TFG.TFG.daos.UserDao;
import TFG.TFG.models.ActivityModel;
import TFG.TFG.service.ActivityService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private final ActivityDao activityDao;

    private final UserDao userDao;

    @Override
    public Optional<ActivityModel> getActivityById(int activityId) {
        return activityDao.getActivityModelById(activityId);
    }

    @Override
    public List<ActivityModel> getAllActivities() {
        return activityDao.findAll();
    }
}
