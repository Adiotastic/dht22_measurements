package de.heinze.iot.dht22_measurements.data.pojo;

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
public class DHT22DataPojo {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;

    @Column(precision = 2)
    private double degreeCelsius;

    @Column(length = 100, nullable = true)
    private String location;

    @Column(precision = 2)
    private double humidity;

    /*
     * --- Testing Purpose ---
     */
    @PostConstruct
    public void initIt() throws Exception {
        log.debug("Init method called");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        log.debug("Clean Up");
    }
}
