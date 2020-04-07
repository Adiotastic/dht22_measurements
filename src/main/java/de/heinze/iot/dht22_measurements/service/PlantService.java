package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.PlantDataDao;
import de.heinze.iot.dht22_measurements.data.mapper.PlantDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.PlantDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.PlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Slf4j
@Service
public class PlantService {
    private PlantRepository plantRepo;

    @Autowired
    public PlantService(PlantRepository plantRepo) {
        this.plantRepo = plantRepo;
    }

    /**
     * Store plant data
     *
     * @param plant
     * @return
     */
    public PlantDataPojo storePlant(PlantDataPojo plant) {
        PlantDataDao plantDao = PlantDataMapper.INSTANCE.pojoToDao(plant);
        log.debug("POJO: " + plant.toString());
        log.debug("DAO: " + plantDao.toString());
        plantRepo.save(plantDao);
        return plant;
    }

    /**
     * Find all plants
     *
     * @return
     */
    public Iterable<PlantDataPojo> getAllPlants() {
        return PlantDataMapper.INSTANCE.daoListToPojoList(plantRepo.findAll());
    }

    /**
     * Find plant by Id. Id : long
     *
     * @param id
     * @return
     */
    public PlantDataPojo findPlantById(long id) {
        return PlantDataMapper.INSTANCE.daoToPojo(plantRepo.findById(id).get());
    }

    /**
     * Update existing plant
     *
     * @param pojoData
     * @return
     */
    public PlantDataPojo updatePlant(Long id, PlantDataPojo pojoData) {
        PlantDataDao plantDao = PlantDataMapper.INSTANCE.pojoToDao(pojoData);
        plantDao.setPlantId(id);
        plantRepo.save(plantDao);
        return pojoData;
    }
}
