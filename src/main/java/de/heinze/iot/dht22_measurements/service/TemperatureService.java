package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.LightingDao;
import de.heinze.iot.dht22_measurements.data.dao.TemperatureDao;
import de.heinze.iot.dht22_measurements.data.mapper.LightingDataMapper;
import de.heinze.iot.dht22_measurements.data.mapper.TemperatureDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.TemperatureDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.PlantRepository;
import de.heinze.iot.dht22_measurements.data.repository.TemperatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Slf4j
@Service
public class TemperatureService {

    private TemperatureRepository tempRepo;

    private PlantRepository plantRepo;

    @Autowired
    public TemperatureService(TemperatureRepository tempRepo, PlantRepository plantRepo) {
        this.tempRepo = tempRepo;
        this.plantRepo = plantRepo;
    }

    /**
     * @param pojoData
     * @return
     */
    public TemperatureDataPojo createEntry(TemperatureDataPojo pojoData, Long plantId) {

        // Set current timestamp
        pojoData.setTimestamp(LocalDateTime.now());

        TemperatureDao dao = TemperatureDataMapper.INSTANCE.pojoToDao(pojoData);

        return plantRepo.findById(plantId).map(plant -> {
            dao.setPlant(plant);
            tempRepo.save(dao);
            return pojoData;
        }).orElseThrow(() -> new RuntimeException("Plant with Id " + plantId + " not found"));
    }

    /**
     * @param id
     * @return
     */
    public Iterable<TemperatureDataPojo> findAllForPlant(Long id) {
        return TemperatureDataMapper.INSTANCE.daoListToPojoList(tempRepo.findByPlantId(id));
    }
}
