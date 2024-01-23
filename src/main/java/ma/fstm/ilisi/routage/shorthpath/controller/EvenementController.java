package ma.fstm.ilisi.routage.shorthpath.controller;


import ma.fstm.ilisi.routage.shorthpath.model.bo.EvenementObj;
import ma.fstm.ilisi.routage.shorthpath.model.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evenements")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @GetMapping
    public ResponseEntity<List<EvenementObj>> listAllEvenements() {
        List<EvenementObj> evenements = evenementService.listAll();
        return ResponseEntity.ok(evenements);
    }

    @PostMapping
    public ResponseEntity<EvenementObj> createEvenement(@RequestBody EvenementObj evenement) {
        evenementService.save(evenement);
        return ResponseEntity.ok(evenement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvenementObj> getEvenement(@PathVariable Long id) {
        Optional<EvenementObj> evenement = evenementService.get(id);
        if (evenement.isPresent()) {
            return ResponseEntity.ok(evenement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvenement(@PathVariable Long id) {
        evenementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
