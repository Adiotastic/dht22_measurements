package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.LightingDao;
import de.heinze.iot.dht22_measurements.data.mapper.LightingDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.LightingDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.LightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Service
public class LightingService {

    private LightingRepository lightingRepo;

    @Autowired
    public LightingService(LightingRepository lightingRepo) {
        this.lightingRepo = lightingRepo;
    }

    /**
     * Store lighting data
     *
     * @param data
     * @return
     */
    public LightingDataPojo storeLightingData(LightingDataPojo data) {
        LightingDao dao = LightingDataMapper.INSTANCE.pojoToDao(data);
        lightingRepo.save(dao);
        return data;
    }

    /**
     * Get single entry by id
     *
     * @param id
     * @return
     */
    public LightingDataPojo findById(Long id) {
        return LightingDataMapper.INSTANCE.daoToPojo(lightingRepo.findById(id).get());
    }
}
