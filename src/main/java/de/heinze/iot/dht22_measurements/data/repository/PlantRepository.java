package de.heinze.iot.dht22_measurements.data.repository;

import de.heinze.iot.dht22_measurements.data.dao.PlantDataDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Repository
public interface PlantRepository extends CrudRepository<PlantDataDao, Long> {
}
