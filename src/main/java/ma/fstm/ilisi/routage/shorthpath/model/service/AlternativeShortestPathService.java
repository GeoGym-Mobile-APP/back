package ma.fstm.ilisi.routage.shorthpath.model.service;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EvenementObj;
import ma.fstm.ilisi.routage.shorthpath.model.bo.Way;
import ma.fstm.ilisi.routage.shorthpath.model.dao.WayAlternatifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlternativeShortestPathService {
    @Autowired
    private WayAlternatifRepository wayRepository;

    public List<Way> findShortestPath2(Double startLon, Double startLat, Double endLon, Double endLat) {
        List<Object[]> result = wayRepository.findShortestPathA(startLon, startLat, endLon, endLat);
        List<Way> ways = new ArrayList<>();

        // On parcourt la liste récupérée pour les chemins
        for (Object[] row : result) {
            Double lon = (Double) row[0];
            Double lat = (Double) row[1];
            Way way = new Way(lon, lat);
            ways.add(way);
        }

        return ways;
    }


}
