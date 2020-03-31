package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.DHT22Dao;
import de.heinze.iot.dht22_measurements.data.pojo.DHT22DataPojo;
import de.heinze.iot.dht22_measurements.data.repository.DHT22Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Service
public class DHT22Service {

    private DHT22Repository dht22Repo;

    @Autowired
    public DHT22Service(DHT22Repository dht22Repo) {
        this.dht22Repo = dht22Repo;
    }

    public DHT22DataPojo saveDHT22Data(DHT22DataPojo pojoData) {
        DHT22Dao dao;

        // TODO: Mapping
        dao = dht22Repo.save(dao);

        // TODO: Do something?

        return pojoData;
    }

    public Iterable<DHT22DataPojo> saveDHT22Data(Iterable<DHT22DataPojo> dht22Data) {
        List<DHT22Dao> daoList = new ArrayList<>();

        // TODO: Mapping

        Iterable<DHT22Dao> daoData = dht22Repo.saveAll(daoList);

        // TODO: mapping

        return dht22Data;
    }

    /**
     * Get all data for DHT22
     * @return all saved sensor data
     */
    public Iterable<DHT22Dao> getAllData() {
        return dht22Repo.findAll();
    }
}
