package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.ExerciceObj;
import ma.fstm.ilisi.routage.shorthpath.model.dao.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciceService {
    @Autowired
    private ExerciceRepository exerciceRepository;

    public List<ExerciceObj> getAllExercices() {
        return exerciceRepository.findAll();
    }


    public List<ExerciceObj> getExercicesByPlanId(Long planId) {
        return exerciceRepository.findByPlanAppartientId(planId);
    }



}
