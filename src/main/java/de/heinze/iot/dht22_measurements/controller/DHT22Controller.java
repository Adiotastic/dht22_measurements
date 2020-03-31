package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.dao.DHT22Dao;
import de.heinze.iot.dht22_measurements.data.pojo.DHT22DataPojo;
import de.heinze.iot.dht22_measurements.service.DHT22Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@RestController
public class DHT22Controller {

    private DHT22Service dht22Service;

    @Autowired
    public DHT22Controller(DHT22Service dht22Service) {
        this.dht22Service = dht22Service;
    }

    public Optional<DHT22DataPojo> saveData(DHT22DataPojo pojoData) {
        return dht22Service.saveDHT22Data(pojoData);
    }
}
