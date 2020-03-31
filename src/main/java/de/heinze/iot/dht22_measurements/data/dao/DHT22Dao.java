package de.heinze.iot.dht22_measurements.data.dao;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Data
@Entity
public class DHT22Dao {
    private Date timestamp;
}
