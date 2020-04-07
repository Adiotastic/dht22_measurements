package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.LightingDao;
import de.heinze.iot.dht22_measurements.data.mapper.LightingDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.LightingDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.LightingRepository;
import de.heinze.iot.dht22_measurements.data.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Service
public class LightingService {

    private LightingRepository lightingRepo;

    private PlantRepository plantRepository;

    @Autowired
    public LightingService(LightingRepository lightingRepo, PlantRepository plantRepository) {
        this.lightingRepo = lightingRepo;
        this.plantRepository = plantRepository;
    }

    /**
     * Store lighting data
     *
     * @param data
     * @return
     */
    public LightingDataPojo storeLightingData(LightingDataPojo data, Long plantId) {

        // Set now as timestamp
        data.setTimestamp(LocalDateTime.now());

        LightingDao dao = LightingDataMapper.INSTANCE.pojoToDao(data);

        return plantRepository.findById(plantId).map(plant -> {
            dao.setPlant(plant);
            lightingRepo.save(dao);
            return data;
        }).orElseThrow(() -> new RuntimeException("Plant with Id " + plantId + " not found"));
    }

    /**
     * @param plantId
     * @return
     */
    public Iterable<LightingDataPojo> findAllForPlant(Long plantId) {
        return LightingDataMapper.INSTANCE.daoListToPojoList(lightingRepo.findByPlantId(plantId));
    }
}
