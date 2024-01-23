package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EventObj;
import ma.fstm.ilisi.routage.shorthpath.model.bo.SalleSportObj;
import ma.fstm.ilisi.routage.shorthpath.model.dao.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public void save(EventObj product) {
        eventRepository.save(product);
    }
    public List<EventObj> getAll()
    {
        return eventRepository.findAll();
    }
    public EventObj obtenirToutesEventsById(Long id) {
        Optional<EventObj> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            EventObj salle = optionalEvent.get();
            return salle;
        } else {

            return null;
        }
    }

    }
