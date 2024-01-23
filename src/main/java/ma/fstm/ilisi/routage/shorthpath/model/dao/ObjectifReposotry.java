package ma.fstm.ilisi.routage.shorthpath.model.dao;

import ma.fstm.ilisi.routage.shorthpath.model.bo.ObjectifObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectifReposotry extends JpaRepository<ObjectifObj, Long> {
        List<ObjectifObj> findObjectifsBySalleAppartient_Id(Long salleId);

        // Ajoutez des méthodes personnalisées au besoin
        }
