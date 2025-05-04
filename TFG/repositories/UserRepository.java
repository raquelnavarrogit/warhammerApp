package TFG.TFG.repositories;

import TFG.TFG.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailAndPassword(String email, String password);

    User findByUsernameAndPassword(String username, String password);


}
