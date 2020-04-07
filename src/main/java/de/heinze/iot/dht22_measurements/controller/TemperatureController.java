package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.pojo.TemperatureDataPojo;
import de.heinze.iot.dht22_measurements.service.TemperatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Slf4j
@RestController
public class TemperatureController {

    private TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping(path = "/dht22/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureDataPojo> saveData(@RequestBody TemperatureDataPojo pojoData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temperatureService.saveDHT22Data(pojoData));
    }

    @GetMapping(path = "/dht22/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureDataPojo> getSampleData() {
        TemperatureDataPojo sample = new TemperatureDataPojo();
        sample.setDegreeCelsius(15.4);
        sample.setHumidity(27.0);
        sample.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(sample);
    }

    @GetMapping(path = "/dht22/getEntry/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureDataPojo> getEntry(@PathVariable Long id) {
        return ResponseEntity.ok(temperatureService.findById(id));
    }
}
