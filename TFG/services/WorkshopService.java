package TFG.TFG.services;

import TFG.TFG.models.Workshop;
import TFG.TFG.repositories.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopService {

    private final WorkshopRepository workshopRepository;

    public WorkshopService(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    /*
    Get all workshops.
     */
    public List<Workshop> getAll(){
        return workshopRepository.findAll();
    }

    /*
    Get one workshop by id.
     */
    public Workshop findById(int id){
        return workshopRepository.findById(id);
    }

    /*
    Save a workshop in the database if it doesn't exist or update it if it does.
     */
    public void save(Workshop workshop){
        if (workshop == null){
            throw new NullPointerException("The workshop was not found.");
        }
        workshopRepository.save(workshop);
    }

    /*
    Delete a workshop from the database.
     */
    public void delete(Workshop workshop){
        if (workshop == null){
            throw new NullPointerException("The workshop was not found.");
        }
        workshopRepository.delete(workshop);
    }
}
