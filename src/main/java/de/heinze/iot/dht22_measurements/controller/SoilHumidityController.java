package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.pojo.LightingDataPojo;
import de.heinze.iot.dht22_measurements.data.pojo.SoilHumidityDataPojo;
import de.heinze.iot.dht22_measurements.service.SoilHumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@RestController
public class SoilHumidityController {

    private SoilHumidityService soilHumService;

    @Autowired
    public SoilHumidityController(SoilHumidityService soilHumService) {
        this.soilHumService = soilHumService;
    }

    @PostMapping("/plants/{id}/soilhumidity")
    public ResponseEntity<SoilHumidityDataPojo> createSoilHumidityData(@RequestBody SoilHumidityDataPojo data, @PathVariable Long id) {
        return ResponseEntity.ok(soilHumService.createEntry(data, id));
    }

    @GetMapping("/plants/{id}/soilhumidity")
    public ResponseEntity<Iterable<SoilHumidityDataPojo>> findAllForPlant(@PathVariable Long id) {
        return ResponseEntity.ok(soilHumService.findAllForPlant(id));
    }

    @GetMapping(path = "/soilhumidity/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SoilHumidityDataPojo> getSampleData() {
        SoilHumidityDataPojo sample = new SoilHumidityDataPojo();
        sample.setSoilHumidity(40.45);
        sample.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(sample);
    }
}
