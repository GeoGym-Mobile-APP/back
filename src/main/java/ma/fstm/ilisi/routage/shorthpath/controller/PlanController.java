package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.PlanObj;
import ma.fstm.ilisi.routage.shorthpath.model.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping("/by-objectif/{objectId}")
    public ResponseEntity<List<PlanObj>> getPlansByObjectId(@PathVariable Integer objectId) {
        List<PlanObj> plans = planService.getPlansByObjectId(objectId);
        return ResponseEntity.ok(plans);
    }

}

