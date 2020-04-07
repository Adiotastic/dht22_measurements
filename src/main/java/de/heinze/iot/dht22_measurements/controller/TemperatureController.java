package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.pojo.TemperatureDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.PlantRepository;
import de.heinze.iot.dht22_measurements.service.TemperatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
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

    @PostMapping(path = "/plants/{id}/temperature", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureDataPojo> saveData(@RequestBody TemperatureDataPojo pojoData, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temperatureService.createEntry(pojoData, id));
    }

    @GetMapping(path = "/plants/{id}/temperature")
    public ResponseEntity<Iterable<TemperatureDataPojo>> findAllForPlant(@PathVariable Long id) {
        return ResponseEntity.ok(temperatureService.findAllForPlant(id));
    }

    @GetMapping(path = "/temperature/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureDataPojo> getSampleData() {
        TemperatureDataPojo sample = new TemperatureDataPojo();
        sample.setDegreeCelsius(15.4);
        sample.setHumidity(27.0);
        sample.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(sample);
    }

}
