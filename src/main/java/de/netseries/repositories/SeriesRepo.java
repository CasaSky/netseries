package de.netseries.repositories;

import de.netseries.entities.Medium;
import de.netseries.entities.Series;
import de.netseries.utils.Kategorie;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by talal on 17.07.16.
 */
@EnableNeo4jRepositories
public interface SeriesRepo extends GraphRepository<Medium> {

    Series findByName(@Param("name") String name);

    List<Series> findByGenre(@Param("genre") Kategorie gerne);
}
