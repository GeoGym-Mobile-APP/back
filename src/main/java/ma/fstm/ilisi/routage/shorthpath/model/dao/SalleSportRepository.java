package ma.fstm.ilisi.routage.shorthpath.model.dao;

import ma.fstm.ilisi.routage.shorthpath.model.bo.SalleSportObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleSportRepository extends JpaRepository<SalleSportObj, Long> {

    // Ajoutez des méthodes personnalisées au besoin
}
