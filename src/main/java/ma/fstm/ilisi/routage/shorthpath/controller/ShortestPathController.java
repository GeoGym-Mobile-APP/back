package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.EvenementObj;
import ma.fstm.ilisi.routage.shorthpath.model.bo.Way;
import ma.fstm.ilisi.routage.shorthpath.model.service.AlternativeShortestPathService;
import ma.fstm.ilisi.routage.shorthpath.model.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/*
Ce controller pour gerer tuoutes  les requests des routage tq:
generer plus court chemin
 */
@RestController
@RequestMapping("/api")
public class ShortestPathController {

    // liaisen du controller avec le service
    @Autowired
    private ShortestPathService shortestPathService;
    @Autowired
    private AlternativeShortestPathService alternativeShortestPathService;

/*
    ArrayList<Integer> tab = new ArrayList<>(Arrays.asList(1, 2, 3, 4,5));
    ArrayList<Integer> tab2 = new ArrayList<>(Arrays.asList(  7, 6));
   @GetMapping("/{startLon},{startLat}/{endLon},{endLat}")
    public ResponseEntity<List<Map<String, List<?>>>> findShortestPath(
            @PathVariable("startLon") Double startLon,
            @PathVariable("startLat") Double startLat,
            @PathVariable("endLon") Double endLon,
            @PathVariable("endLat") Double endLat) {
        List<Map<String,List<?>>> ResultatFinal= new ArrayList<>();
        Map<String, List<?>> result = new HashMap<>();
        Map<String, List<?>> result2 = new HashMap<>();

        List<List<?>> shortestPathData = shortestPathService.findShortestPath2(startLon, startLat, endLon, endLat);
        List<List<?>> shortestPathData2 = alternativeShortestPathService.findShortestPath2(startLon, startLat, endLon, endLat);
        List<?>envets1=(List<?>)show2((List<Way>) shortestPathData.get(0),4,tab);
       List<?>envets2=(List<?>)show2((List<Way>) shortestPathData2.get(0),2,tab2);
        if (envets1.size() < envets2.size()){
            result.put("path0", shortestPathData.get(0));
            System.out.println("1");
            result.put("evenement0", envets1);
            System.out.println(result.get("evenement0"));
            result2.put("path1", shortestPathData2.get(0));
            result2.put("evenement1", envets2);

        }
        else{
            System.out.println("2");
            result.put("path0", shortestPathData2.get(0));
            result.put("evenement0", envets2);
            System.out.println(result.get("evenement0"));
            result2.put("path1", shortestPathData.get(0));
            result2.put("evenement1", envets1);

        }
        ResultatFinal.add(result);
        ResultatFinal.add(result2);

        return ResponseEntity.ok(ResultatFinal);
    }


    private List show2(List<Way> test,int nbr,List<Integer> tab) {
        List tabNewEvents = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < nbr && !test.isEmpty(); i++) {

            int randomIndex = random.nextInt(test.size());

            Way originalObject = test.get(randomIndex);
            EvenementObj evenementObj = new EvenementObj((long) tab.get(i), originalObject.getLon(), originalObject.getLat());

            test.remove(randomIndex);
            tabNewEvents.add(evenementObj);
        }
        return tabNewEvents;
    }



  /* @GetMapping("/{startLon},{startLat}/{endLon},{endLat}")
   public ResponseEntity<Map<String, List<?>>> findShortestPath(
           @PathVariable("startLon") Double startLon,
           @PathVariable("startLat") Double startLat,
           @PathVariable("endLon") Double endLon,
           @PathVariable("endLat") Double endLat) {

       Map<String, List<?>> result = new HashMap<>();
       List<List<?>> shortestPathData = alternativeShortestPathService.findShortestPath2(startLon, startLat, endLon, endLat);

       result.put("path", shortestPathData.get(0)); // Première liste est le chemin
       result.put("evenement", shortestPathData.get(1)); // Deuxième liste est les événements

       return ResponseEntity.ok(result);
   }*/

}