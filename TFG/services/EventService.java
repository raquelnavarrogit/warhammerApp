package TFG.TFG.services;

import TFG.TFG.models.Event;
import TFG.TFG.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /*
    Get all events.
     */
    public List<Event> getAll(){
        if (eventRepository == null){
            throw new NullPointerException("The event repository was not found.");
        }
        return eventRepository.findAll();
    }

    /*
    Get one event by id.
     */
    public Event findById(int id){
            return eventRepository.findById(id);
    }

    /*
    Save an event in the database if it doesn't exist or update it if it does.
     */
    public void save(Event event){
        if (event == null){
            throw new NullPointerException("The event was not found.");
        }
        eventRepository.save(event);
    }

    /*
    Delete an event from the database.
     */
    public void delete(Event event){
        if (event == null){
            throw new NullPointerException("The event was not found.");
        }
        eventRepository.delete(event);
    }
}
