package ma.fstm.ilisi.routage.shorthpath.model.dao;


import ma.fstm.ilisi.routage.shorthpath.model.bo.Way;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WayAlternatifRepository extends JpaRepository<Way, Long> {

    @Query(nativeQuery = true,
            value = "WITH start_node AS (" +
                    "    SELECT id " +
                    "    FROM ways_vertices_pgr " +
                    "    ORDER BY ST_Distance(" +
                    "        ST_SetSRID(ST_MakePoint(:startLon, :startLat), 4326)," +
                    "        the_geom" +
                    "    ) LIMIT 1" +
                    ")," +
                    "end_node AS (" +
                    "    SELECT id " +
                    "    FROM ways_vertices_pgr " +
                    "    ORDER BY ST_Distance(" +
                    "        ST_SetSRID(ST_MakePoint(:endLon, :endLat), 4326)," +
                    "        the_geom" +
                    "    ) LIMIT 1" +
                    ")," +
                    "shortest_path AS (" +
                    "    SELECT ST_X(wvp.the_geom) AS lon, ST_Y(wvp.the_geom) AS lat " +
                    "    FROM pgr_astar(" +
                    "        'SELECT gid AS id, source, target, cost , x1, y1, x2, y2 FROM ways'," +
                    "        (SELECT id FROM start_node)," +
                    "        (SELECT id FROM end_node)" +
                    "    ) sp " +
                    "    JOIN ways_vertices_pgr wvp ON sp.node = wvp.id" +
                    ")" +
                    "SELECT e.id, e.longitude, e.latitude " +
                    "FROM evenement e " +
                    "WHERE (e.longitude, e.latitude) IN (" +
                    "    SELECT lon, lat FROM shortest_path" +
                    ")"
    )
    List<Object[]> findEventsInPathA(
            @Param("startLon") Double startLon,
            @Param("startLat") Double startLat,
            @Param("endLon") Double endLon,
            @Param("endLat") Double endLat
    );

    @Query(value =
            "WITH start_point AS (" +
                    "    SELECT id " +
                    "    FROM ways_vertices_pgr " +
                    "    ORDER BY ST_Distance(" +
                    "        ST_SetSRID(ST_MakePoint(:startLon, :startLat), 4326)," +
                    "        the_geom" +
                    "    ) LIMIT 1" +
                    ")," +
                    "end_point AS (" +
                    "    SELECT id " +
                    "    FROM ways_vertices_pgr " +
                    "    ORDER BY ST_Distance(" +
                    "        ST_SetSRID(ST_MakePoint(:endLon, :endLat), 4326)," +
                    "        the_geom" +
                    "    ) LIMIT 1" +
                    ")," +
                    "shortest_path AS (" +
                    "    SELECT * FROM pgr_astar(" +
                    "          'SELECT gid AS id, source, target, cost , x1, y1, x2, y2 FROM ways'," +
                    "        (SELECT id FROM start_point)," +
                    "        (SELECT id FROM end_point)" +
                    "    )" +
                    ")" +
                    "SELECT ST_X(wvp.the_geom) AS lon, ST_Y(wvp.the_geom) AS lat " +
                    "FROM shortest_path sp " +
                    "JOIN ways_vertices_pgr wvp ON sp.node = wvp.id",
            nativeQuery = true)
    List<Object[]> findShortestPathA(
            @Param("startLon") Double startLon,
            @Param("startLat") Double startLat,
            @Param("endLon") Double endLon,
            @Param("endLat") Double endLat
    );

}