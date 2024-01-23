package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.ExerciceObj;
import ma.fstm.ilisi.routage.shorthpath.model.service.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exercices")
public class ExerciceController {

    @Autowired
    private ExerciceService exerciceService;

    @GetMapping("/by-plan/{planId}")
    public List<ExerciceObj> getExercicesByPlanId(@PathVariable Long planId) {
        return exerciceService.getExercicesByPlanId(planId);
    }
}
