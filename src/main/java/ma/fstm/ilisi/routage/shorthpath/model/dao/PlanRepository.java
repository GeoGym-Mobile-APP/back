package ma.fstm.ilisi.routage.shorthpath.model.dao;

import ma.fstm.ilisi.routage.shorthpath.model.bo.PlanObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<PlanObj, Long> {
    List<PlanObj> findByObjectifAppartientId(Integer objectId);
}

