package de.heinze.iot.dht22_measurements.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Configuration
public class MeasurementConfiguration {

    private final Environment environment;

    public MeasurementConfiguration(Environment environment) {
        this.environment = environment;
    }

//    @Bean
//    public DHT22Service getDHT22Service() {
//        return new DHT22Service(10);
//    }

}
