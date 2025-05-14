package TFG.TFG.daos;

import TFG.TFG.models.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDao extends JpaRepository<ActivityModel, Long> {
    ActivityModel getActivityModelById(int id);
}
