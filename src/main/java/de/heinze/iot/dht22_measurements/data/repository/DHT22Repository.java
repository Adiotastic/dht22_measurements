package de.heinze.iot.dht22_measurements.data.repository;

import de.heinze.iot.dht22_measurements.data.pojo.DHT22DataPojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Repository
public interface DHT22Repository extends CrudRepository<DHT22DataPojo, Long> {

}
