package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.PlanObj;
import ma.fstm.ilisi.routage.shorthpath.model.dao.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public List<PlanObj> getPlansByObjectId(Integer objectId) {
        return planRepository.findByObjectifAppartientId(objectId);
    }

    // Autres méthodes de service au besoin
}

