package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EvenementObj;
import ma.fstm.ilisi.routage.shorthpath.model.bo.Way;
import ma.fstm.ilisi.routage.shorthpath.model.dao.WayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShortestPathService {
    @Autowired
    private WayRepository wayRepository;

    public List<List<?>> findShortestPath2(Double startLon, Double startLat, Double endLon, Double endLat) {

       List<Object[]> result = wayRepository.findShortestPath(startLon, startLat, endLon, endLat);
        List<Object[]> resultE = wayRepository.findEventsInPath(startLon, startLat, endLon, endLat);
        List<List<?>> resultF = new ArrayList<>();
        // on va paroucourir la liste recupurer
        List<Way> ways = new ArrayList<>();
        for (Object[] row : result) {
            Double lon = (Double) row[0];
            Double lat = (Double) row[1];
            Way way = new Way(lon, lat); // en va cree l'objet way
            ways.add(way);
        }
      List<EvenementObj> evenementObjs = new ArrayList<>();
        for (Object[] row : resultE)
        {
            long id = (long) row[0];
            Double lon = (Double) row[1];
            Double lat = (Double) row[2];
            EvenementObj evenementObj1 = new EvenementObj(id,lon,lat);
            evenementObjs.add(evenementObj1);
        }
       resultF.add(ways);
        resultF.add(evenementObjs);
        return resultF;


    }


}