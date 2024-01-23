package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.SalleSportObj;
import ma.fstm.ilisi.routage.shorthpath.model.dao.SalleSportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalleSportService {
    @Autowired
    private  SalleSportRepository salleSportRepository;






    public SalleSportService(SalleSportRepository salleSportRepository) {
        this.salleSportRepository = salleSportRepository;
    }

    public void ajouterSalleDeSport(SalleSportObj salleSportObj) {
        System.out.println("salle"+ salleSportObj);
        salleSportRepository.save(salleSportObj);
    }

    public List<SalleSportObj> obtenirToutesLesSallesDeSport() {
        List<SalleSportObj> salles = salleSportRepository.findAll();

        for (SalleSportObj salle : salles) {
            salle.setEquipementsArray(salle.getEquipements());
        }

        return salles;
    }
    public SalleSportObj obtenirToutesLesSallesDeSportById(Long id) {
        Optional<SalleSportObj> optionalSalle = salleSportRepository.findById(id);

        if (optionalSalle.isPresent()) {
            SalleSportObj salle = optionalSalle.get();
            salle.setEquipementsArray(salle.getEquipements());
            return salle;
        } else {
            // Gérer le cas où la salle n'est pas trouvée (par exemple, jeter une exception ou renvoyer null)
            return null;
        }
    }

    // Ajoutez d'autres méthodes de service en fonction de vos besoins
}
