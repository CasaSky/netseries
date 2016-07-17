package de.netseries.repositories;

import de.netseries.PersistenceContext;
import de.netseries.entities.Watcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by talal on 16.07.16.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class WatcherRepoTest {

    @Autowired
    public WatcherRepo repo;

    public Watcher talal;


    @Before
    public void initialize() {
        talal = new Watcher();
        talal.setName("talal");
        talal.setUsername("talal");
        talal.setPassword("test");
        repo.save(talal);
    }

    @Test
    public void saveTest() {
        Watcher found = repo.findByUsername("talal");

        assertNotNull(found);
        assertEquals(talal.getName(), found.getName());
    }

    @Test
    public void findByLoginTest() {
        Watcher found = repo.findByLogin("talal","test");
        assertNotNull(found);

    }
}
