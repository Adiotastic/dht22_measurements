package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.pojo.LightingDataPojo;
import de.heinze.iot.dht22_measurements.service.LightingService;
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
public class LightingController {

    private LightingService lightingService;

    @Autowired
    public LightingController(LightingService lightingService) {
        this.lightingService = lightingService;
    }

    @PostMapping("/plants/{id}/lighting")
    public ResponseEntity<LightingDataPojo> createLightingEntry(@RequestBody LightingDataPojo data, @PathVariable Long id) {
        return ResponseEntity.ok(lightingService.storeLightingData(data, id));
    }

    @GetMapping("/plants/{id}/lighting")
    public ResponseEntity<Iterable<LightingDataPojo>> findAllLightingDataForPlant(@PathVariable Long id) {
        return ResponseEntity.ok(lightingService.findAllForPlant(id));
    }

    @GetMapping(path = "/lighting/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LightingDataPojo> getSampleData() {
        LightingDataPojo sample = new LightingDataPojo();
        sample.setLux(2500);
        sample.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(sample);
    }
}
