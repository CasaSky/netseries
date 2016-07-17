package de.netseries.services;

import de.netseries.entities.Watcher;
import de.netseries.repositories.WatcherRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by talal on 16.07.16.
 */
@Service
public class WatcherService {

    private final static Logger log = LoggerFactory.getLogger(WatcherService.class);
    @Autowired
    WatcherRepo repo;

    @Transactional
    public Watcher create(Watcher watcher) { //Unique
        Watcher duplicate = repo.findByUsername(watcher.getUsername());
        if (duplicate!=null) {
            log.info("Username already exists!");
            throw new IllegalArgumentException("Username already exists!");
        }
        return repo.save(watcher);
    }


    @Transactional
    public Watcher findByLogin(String username, String password) {
        Watcher found = repo.findByLogin(username, password);

        if(found==null)
            throw new IllegalArgumentException("Username and Password are wrong!");
        return found;
    }
}
