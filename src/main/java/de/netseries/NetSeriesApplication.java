package de.netseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

/**
 * Created by talal on 16.07.16.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"de.netseries.services"})
@Import(NeoConfiguration.class)
public class NetSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetSeriesApplication.class, args);
	}
}
