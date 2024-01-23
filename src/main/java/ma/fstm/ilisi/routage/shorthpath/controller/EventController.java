package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EventObj;
import ma.fstm.ilisi.routage.shorthpath.model.bo.SalleSportObj;
import ma.fstm.ilisi.routage.shorthpath.model.service.EventService;
import ma.fstm.ilisi.routage.shorthpath.model.service.SalleSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")

public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping
    public ResponseEntity<EventObj> ajouterEvents(@RequestBody EventObj eventObj) {

        eventService.save(eventObj);
        return ResponseEntity.ok(eventObj);
    }
    @GetMapping
    public List<EventObj> obtenirToutesEvents() {
        return eventService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventObj> obtenirSalleSportParId(@PathVariable Long id) {
        EventObj eventObj = eventService.obtenirToutesEventsById(id);
        return ResponseEntity.ok(eventObj);
    }

}
