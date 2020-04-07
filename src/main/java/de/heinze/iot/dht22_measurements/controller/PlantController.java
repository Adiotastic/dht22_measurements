package de.heinze.iot.dht22_measurements.controller;

import de.heinze.iot.dht22_measurements.data.pojo.PlantDataPojo;
import de.heinze.iot.dht22_measurements.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Slf4j
@RestController
public class PlantController {

    private PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping(path = "/plants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PlantDataPojo>> findAllPlants() {
        return ResponseEntity.ok(plantService.getAllPlants());
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<PlantDataPojo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(plantService.findPlantById(id));
    }

    @GetMapping(value = "/plants/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantDataPojo> getSample() {
        PlantDataPojo pojo = new PlantDataPojo();
        pojo.setLocation("Kitchen");
        pojo.setMinimumTemperature(10);
        pojo.setOptimumLighting(2500);
        pojo.setOptimumSoilHumidity(40);
        pojo.setPlantName("Bogenhanf");
        return ResponseEntity.ok(pojo);
    }

    @PostMapping(path = "/plants", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantDataPojo> storePlant(@RequestBody PlantDataPojo data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(plantService.storePlant(data));
    }

    @PutMapping("/plants/{id}")
    public ResponseEntity<PlantDataPojo> update(@PathVariable Long id, @RequestBody PlantDataPojo pojoData) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(plantService.updatePlant(id, pojoData));
    }


}
