package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.SalleSportObj;
import ma.fstm.ilisi.routage.shorthpath.model.service.SalleSportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
public class SalleSportController {
    @Autowired
    private  SalleSportService salleSportService;

    @PostMapping
    public ResponseEntity<SalleSportObj> ajouterSalleDeSport(@RequestBody SalleSportObj salleSportObj) {

        salleSportService.ajouterSalleDeSport(salleSportObj);
        return ResponseEntity.ok(salleSportObj);
    }

    @GetMapping
    public List<SalleSportObj> obtenirToutesLesSallesDeSport() {
        return salleSportService.obtenirToutesLesSallesDeSport();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SalleSportObj> obtenirSalleSportParId(@PathVariable Long id) {
        SalleSportObj salleSport = salleSportService.obtenirToutesLesSallesDeSportById(id);
        return ResponseEntity.ok(salleSport);
    }

    // Ajoutez d'autres méthodes du contrôleur en fonction de vos besoins
}
