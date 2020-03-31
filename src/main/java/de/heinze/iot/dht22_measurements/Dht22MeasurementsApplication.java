package de.heinze.iot.dht22_measurements;

import de.heinze.iot.dht22_measurements.config.properties.MeasurementProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties(MeasurementProperties.class)
public class Dht22MeasurementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dht22MeasurementsApplication.class, args);
    }

}
