package de.heinze.iot.dht22_measurements.data.pojo;

import de.heinze.iot.dht22_measurements.data.converter.LocalDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightingDataPojo {

    private double lux;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;
}
