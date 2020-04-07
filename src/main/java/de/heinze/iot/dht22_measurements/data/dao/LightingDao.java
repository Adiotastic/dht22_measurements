package de.heinze.iot.dht22_measurements.data.dao;

import de.heinze.iot.dht22_measurements.data.converter.LocalDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightingDao {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String sensorId;

    private double lux;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlantDataDao plant;
}
