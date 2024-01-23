package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.MouvementObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mouvements")
public class MouvementController {

    @Autowired
    private ma.fstm.ilisi.routage.shorthpath.service.MouvementService mouvementService;

    @GetMapping("/byExercice/{exerciceId}")
    public List<MouvementObj> getMouvementsByExerciceId(@PathVariable Long exerciceId) {
        return mouvementService.getMouvementsByExerciceId(exerciceId);
    }
}
