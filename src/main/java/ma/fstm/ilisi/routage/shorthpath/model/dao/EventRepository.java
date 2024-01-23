package ma.fstm.ilisi.routage.shorthpath.model.dao;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EventObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventObj, Long> {

    // Ajoutez des méthodes personnalisées au besoin
}
