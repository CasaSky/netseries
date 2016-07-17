package de.netseries.services;

import de.netseries.PersistenceContext;
import de.netseries.entities.Watcher;
import de.netseries.repositories.WatcherRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by talal on 17.07.16.
 */
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class WatcherServiceTest {

    @Autowired
    public WatcherService service;

    public Watcher talal;

    @Before
    public void initialize() {
        talal = Watcher.createWatcher("talal", "talal", "test", 0, "");
        service.create(talal);
    }

    @Test
    public void findByLoginTest() {
        Watcher found = service.findByLogin("talal","test");
        assertNotNull(found);
        assertEquals(found.getPassword(), "test");
    }
}
