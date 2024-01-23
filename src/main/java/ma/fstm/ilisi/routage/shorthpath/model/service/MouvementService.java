package ma.fstm.ilisi.routage.shorthpath.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.MouvementObj;

import ma.fstm.ilisi.routage.shorthpath.model.dao.MouvementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouvementService {
    @Autowired
    private MouvementRepository mouvementRepository;

    public List<MouvementObj> getMouvementsByExerciceId(Long exerciceId) {
        return mouvementRepository.findByExerciceAppartient_Id(exerciceId);
    }
}
