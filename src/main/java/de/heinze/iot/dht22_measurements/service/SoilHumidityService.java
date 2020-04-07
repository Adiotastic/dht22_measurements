package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.SoilHumidityDao;
import de.heinze.iot.dht22_measurements.data.mapper.SoilHumidityDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.SoilHumidityDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.SoilHumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Service
public class SoilHumidityService {

    private SoilHumidityRepository soilRepo;

    @Autowired
    public SoilHumidityService(SoilHumidityRepository soilRepo) {
        this.soilRepo = soilRepo;
    }

    /**
     * Store Humidity Data
     * @param soilData
     * @return
     */
    public SoilHumidityDataPojo storeHumidity(SoilHumidityDataPojo soilData) {
        SoilHumidityDao dao = SoilHumidityDataMapper.INSTANCE.pojoToDao(soilData);
        soilRepo.save(dao);
        return soilData;
    }

    /**
     * Returns spcific data value
     * @param id
     * @return
     */
    public SoilHumidityDataPojo findById(Long id) {
        return SoilHumidityDataMapper.INSTANCE.daoToPojo(soilRepo.findById(id).get());
    }



}
