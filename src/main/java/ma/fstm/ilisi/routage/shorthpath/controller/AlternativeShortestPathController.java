package ma.fstm.ilisi.routage.shorthpath.controller;

import ma.fstm.ilisi.routage.shorthpath.model.bo.Way;
import ma.fstm.ilisi.routage.shorthpath.model.service.AlternativeShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/alternative-paths")
public class AlternativeShortestPathController {

    @Autowired
    private AlternativeShortestPathService alternativeShortestPathService;


    @GetMapping("/{startLon},{startLat}/{endLon},{endLat}")
    public ResponseEntity<List<Way>> findAlternativeShortestPaths(
            @PathVariable("startLon") Double startLon,
            @PathVariable("startLat") Double startLat,
            @PathVariable("endLon") Double endLon,
            @PathVariable("endLat") Double endLat) {

        List<Way> alternativePathCoordinates = alternativeShortestPathService.findShortestPath2(startLon, startLat, endLon, endLat);
        return ResponseEntity.ok(alternativePathCoordinates);
    }


}
