package de.heinze.iot.dht22_measurements.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@ConfigurationProperties(value = "de.heinze.measurements")
@Data
public class MeasurementProperties {

    /**
     * Measurements for DHT22 Sensor
     */
    private DHT22 dht22 = new DHT22();

    /**
     * Limit of humidity to be warned at
     */
    private double humidityLimit;

    /**
     * Limit of temperature to be warned at
     */
    private double temperatureLimit;

    /**
     * DHT22 sensor specific configuration
     */
    class DHT22 {
        /**
         * Configuration for the polling interval in seconds
         */
        private int pollingInterval = 60;

    }
}
