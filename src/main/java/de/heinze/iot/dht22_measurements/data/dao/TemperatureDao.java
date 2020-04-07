package de.heinze.iot.dht22_measurements.data.dao;

import de.heinze.iot.dht22_measurements.data.converter.LocalDateTimeConverter;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Slf4j
@Entity
@Data
public class TemperatureDao {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sensorId;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;

    @Column(precision = 2)
    private double degreeCelsius;

    @Column(precision = 2)
    private double humidity;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlantDataDao plant;

    /*
     * --- Testing Purpose ---
     */
    @PostConstruct
    public void initIt() throws Exception {
        //log.debug("Init method called");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        //log.debug("Clean Up");
    }
}
