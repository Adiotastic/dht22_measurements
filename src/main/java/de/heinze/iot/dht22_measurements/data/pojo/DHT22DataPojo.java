package de.heinze.iot.dht22_measurements.data.pojo;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Entity
@Data
public class DHT22DataPojo {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date timestamp;

    private double degreeCelsius;

    private double humidity;
}
