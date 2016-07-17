package de.netseries.repositories;

import de.netseries.entities.Watcher;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.repository.query.Param;

/**
 * Created by talal on 16.07.16.
 */
@EnableNeo4jRepositories
public interface WatcherRepo extends GraphRepository<Watcher> {
    Watcher findByUsername(@Param("username") String name);

    @Query("MATCH (watcher:Watcher{username: {username}, password: {password}}) RETURN watcher")
    Watcher findByLogin(@Param("username") String username, @Param("password") String password);

}
