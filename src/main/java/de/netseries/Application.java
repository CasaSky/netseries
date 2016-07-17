package de.netseries;

import de.netseries.NeoConfiguration;
import de.netseries.services.WatcherService;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.config.DriverConfiguration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

/**
 * Created by talal on 16.07.16.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"de.netseries.services"})
@Import(NeoConfiguration.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
