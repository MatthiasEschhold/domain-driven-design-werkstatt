package de.novatec.autohaus.werkstatt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CleanWerkstattSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleanWerkstattSpringBootApplication.class, args);
    }
}
