package ma.fstm.ilisi.routage.shorthpath.model.dao;

import ma.fstm.ilisi.routage.shorthpath.model.bo.ExerciceObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciceRepository extends JpaRepository<ExerciceObj, Long> {

    List<ExerciceObj> findByPlanAppartientId(Long planId);

}
