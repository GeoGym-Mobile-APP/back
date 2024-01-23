package ma.fstm.ilisi.routage.shorthpath.model.dao;


import ma.fstm.ilisi.routage.shorthpath.model.bo.MouvementObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MouvementRepository extends JpaRepository<MouvementObj, Long> {

    List<MouvementObj> findByExerciceAppartient_Id(Long exerciceId);
}
