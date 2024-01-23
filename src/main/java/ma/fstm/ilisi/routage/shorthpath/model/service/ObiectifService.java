package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EventObj;
import ma.fstm.ilisi.routage.shorthpath.model.bo.ObjectifObj;
import ma.fstm.ilisi.routage.shorthpath.model.dao.ObjectifReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObiectifService {
    @Autowired
    private ObjectifReposotry objectifReposotry;

    public ObjectifObj obtenirToutesObjectifById(Long id) {
        Optional<ObjectifObj> optionalEvent = objectifReposotry.findById(id);
        if (optionalEvent.isPresent()) {
            ObjectifObj objectif = optionalEvent.get();
            return objectif;
        } else {

            return null;
        }
    }
    public List<ObjectifObj> getAll()
    {
        return objectifReposotry.findAll();
    }
    public List<ObjectifObj> getObjectifsBySalleId(Long salleId) {
        return objectifReposotry.findObjectifsBySalleAppartient_Id(salleId);
    }

}
