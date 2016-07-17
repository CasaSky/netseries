package de.netseries;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.neo4j.ogm.config.Configuration;

/**
 * Created by talal on 16.07.16.
 */
@EnableNeo4jRepositories("de.netseries.repositories")
@EnableTransactionManagement
@ComponentScan("de.netseries")
public class PersistenceContext extends Neo4jConfiguration {

    @Bean
    public Configuration getConfiguration() {
        Configuration config = new Configuration();
        config
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI("http://neo4j:djdelux@localhost:7474");
        return config;
    }

    @Override
    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(getConfiguration(), "de.netseries.entities");
    }

    @Override
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return getSessionFactory().openSession();
    }

    @Bean
    public CustomScopeConfigurer glueScopeConfigurer(){
        CustomScopeConfigurer toReturn = new CustomScopeConfigurer();

        toReturn.addScope("session", new CustomScope());

        return toReturn;
    }
}