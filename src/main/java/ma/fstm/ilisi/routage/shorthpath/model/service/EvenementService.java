package ma.fstm.ilisi.routage.shorthpath.model.service;

import jakarta.transaction.Transactional;
import ma.fstm.ilisi.routage.shorthpath.model.bo.EvenementObj;
import ma.fstm.ilisi.routage.shorthpath.model.dao.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public List<EvenementObj> listAll(){
        return evenementRepository.findAll();

    }
    public void save(EvenementObj product) {
        evenementRepository.save(product);
    }

    public void delete(long id) {
        evenementRepository.deleteById(id);
    }
    public Optional<EvenementObj> get(long id) {
        return evenementRepository.findById(id);
    }


}
