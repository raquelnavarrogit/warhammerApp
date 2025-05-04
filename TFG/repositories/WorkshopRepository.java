package TFG.TFG.repositories;

import TFG.TFG.models.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Integer> {

    Workshop findById(int id);
}

