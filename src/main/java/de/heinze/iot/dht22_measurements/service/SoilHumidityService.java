package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.SoilHumidityDao;
import de.heinze.iot.dht22_measurements.data.mapper.SoilHumidityDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.SoilHumidityDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.PlantRepository;
import de.heinze.iot.dht22_measurements.data.repository.SoilHumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Service
public class SoilHumidityService {

    private SoilHumidityRepository soilRepo;

    private PlantRepository plantRepo;

    @Autowired
    public SoilHumidityService(SoilHumidityRepository soilRepo, PlantRepository plantRepo) {
        this.soilRepo = soilRepo;
        this.plantRepo = plantRepo;
    }

    /**
     * Store Humidity Data
     * @param soilData
     * @return
     */
    public SoilHumidityDataPojo createEntry(SoilHumidityDataPojo soilData, Long plantId) {

        // Set Now as Timestamp
        soilData.setTimestamp(LocalDateTime.now());

        SoilHumidityDao dao = SoilHumidityDataMapper.INSTANCE.pojoToDao(soilData);

        return plantRepo.findById(plantId).map( plant -> {
            dao.setPlant(plant);
            soilRepo.save(dao);
            return soilData;
        }).orElseThrow(() -> new RuntimeException("Plant not found for id " + plantId));
    }

    /**
     * Returns spcific data value
     * @param id
     * @return
     */
    public Iterable<SoilHumidityDataPojo> findAllForPlant(Long id) {
        return SoilHumidityDataMapper.INSTANCE.daoListToPojoList(soilRepo.findByPlantId(id));
    }



}
