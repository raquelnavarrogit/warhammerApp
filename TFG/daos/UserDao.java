package TFG.TFG.daos;

import TFG.TFG.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, String> {
}
