package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.pojo.DHT22DataPojo;
import de.heinze.iot.dht22_measurements.service.DHT22Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @PutMapping(path = "/dht22/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DHT22DataPojo saveData(@RequestBody DHT22DataPojo pojoData) {
        return dht22Service.saveDHT22Data(pojoData);
    }

    @PutMapping(path = "/dht22/saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DHT22DataPojo> saveAllData(@RequestBody Iterable<DHT22DataPojo> pojoData) {
        return dht22Service.saveDHT22Data(pojoData);
    }

    @GetMapping(path = "/dht22/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public DHT22DataPojo getSampleData() {
        DHT22DataPojo sample = new DHT22DataPojo();
        sample.setDegreeCelsius(15.42);
        sample.setHumidity(27.0);
        sample.setTimestamp(new Date());
        return sample;
    }
}
