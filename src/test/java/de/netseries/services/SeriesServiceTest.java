package de.netseries.services;

import de.netseries.PersistenceContext;
import de.netseries.entities.Medium;
import de.netseries.entities.Series;
import de.netseries.entities.Watcher;
import de.netseries.utils.Kategorie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
/**
 * Created by talal on 17.07.16.
 */
@SpringBootTest
@ContextConfiguration(classes = {PersistenceContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class SeriesServiceTest {

    @Autowired
    public SeriesService service;

    public Medium gOt;

    @Before
    public void initialize() {
        Watcher creator = Watcher.createWatcher("talal", "talal", "test", 0, "");;
        gOt = Series.createSeries("Game of thrones", creator, Kategorie.FANTASY);
        service.create(gOt);
    }

    @Test
    public void findByGenreTest() {
        List<Series> found = service.findByGenre(Kategorie.FANTASY);
        assertNotNull(found);
        for (Series s : found) {
            assertThat(s.getGenre(), is(Kategorie.FANTASY));
        }
    }
}
