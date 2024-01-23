package ma.fstm.ilisi.routage.shorthpath.model.dao;


import ma.fstm.ilisi.routage.shorthpath.model.bo.EvenementObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<EvenementObj, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
