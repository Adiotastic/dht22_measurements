package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.pojo.DHT22DataPojo;
import de.heinze.iot.dht22_measurements.data.repository.DHT22Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Slf4j
@Service
public class DHT22Service {

    private DHT22Repository dht22Repo;

    /**
     * Tickrate in seconds. Default is 10
     */
    private int tickRate = 10;

    public DHT22Service(int i) {
        this.tickRate = tickRate;
    }

    @Autowired
    public DHT22Service(DHT22Repository dht22Repo) {
        this.dht22Repo = dht22Repo;
    }

    public DHT22DataPojo saveDHT22Data(DHT22DataPojo pojoData) {
        log.info("PojoData: " + pojoData.toString());
        return dht22Repo.save(pojoData);
    }

    public Iterable<DHT22DataPojo> saveDHT22Data(Iterable<DHT22DataPojo> dht22Data) {
        return dht22Repo.saveAll(dht22Data);
    }

    public Optional<DHT22DataPojo> getEntry(Long id) {
        return dht22Repo.findById(id);
    }

    /**
     * Get all data for DHT22
     * @return all saved sensor data
     */
    public Iterable<DHT22DataPojo> getAllData() {
        return dht22Repo.findAll();
    }
}
