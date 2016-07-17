package de.netseries.services;

import de.netseries.entities.Medium;
import de.netseries.entities.Series;
import de.netseries.repositories.SeriesRepo;
import de.netseries.utils.Kategorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by talal on 17.07.16.
 */
@Service
public class SeriesService {

    private final static Logger log = LoggerFactory.getLogger(SeriesService.class);
    @Autowired
    SeriesRepo repo;

    @Transactional
    public Medium create(Medium series) { //Unique
        Series duplicate = repo.findByName(series.getName());
        if (duplicate!=null) {
            log.info("Name already exists!");
            throw new IllegalArgumentException("Name already exists!");
        }
        return repo.save(series);
    }

    @Transactional
    public List<Series> findByGenre(Kategorie genre) {
        return repo.findByGenre(genre);
    }
}
