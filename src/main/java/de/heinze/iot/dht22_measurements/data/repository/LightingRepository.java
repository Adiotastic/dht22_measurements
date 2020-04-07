package de.heinze.iot.dht22_measurements.data.repository;

import de.heinze.iot.dht22_measurements.data.dao.LightingDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightingRepository extends CrudRepository<LightingDao, Long> {

    Iterable<LightingDao> findByPlantId(Long plantId);
}
