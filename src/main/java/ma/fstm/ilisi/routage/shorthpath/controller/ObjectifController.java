package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.ObjectifObj;
import ma.fstm.ilisi.routage.shorthpath.model.service.ObiectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/objectifs")
public class ObjectifController {

    @Autowired
    private ObiectifService obiectifService;
    @GetMapping("/{id}")
    public ResponseEntity<ObjectifObj> obtenirObjectiifsParId(@PathVariable Long id) {
        ObjectifObj objectifObj = obiectifService.obtenirToutesObjectifById(id);
        return ResponseEntity.ok(objectifObj);
    }
    @GetMapping
    public List<ObjectifObj> obtenirToutesObjectiifs() {
        return obiectifService.getAll();
    }
    @GetMapping("/salle/{id}")
    public ResponseEntity<List<ObjectifObj>> getObjectifsBySalleId(@PathVariable Long id) {
        List<ObjectifObj> objectifs = obiectifService.getObjectifsBySalleId(id);
        if (!objectifs.isEmpty()) {
            return ResponseEntity.ok(objectifs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
