package TFG.TFG.daos;

import TFG.TFG.models.ActivityModel;
import TFG.TFG.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<UserModel, String> {
    List<UserModel> findByActivities(List<ActivityModel> activities);
}
