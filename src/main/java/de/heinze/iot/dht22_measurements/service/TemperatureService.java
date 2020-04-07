package de.heinze.iot.dht22_measurements.service;

import de.heinze.iot.dht22_measurements.data.dao.TemperatureDao;
import de.heinze.iot.dht22_measurements.data.mapper.TemperatureDataMapper;
import de.heinze.iot.dht22_measurements.data.pojo.TemperatureDataPojo;
import de.heinze.iot.dht22_measurements.data.repository.TemperatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 31.03.20
 */

@Slf4j
@Service
public class TemperatureService {

    private TemperatureRepository dht22Repo;

    /**
     * Tickrate in seconds. Default is 10
     */
    private int tickRate = 10;

    public TemperatureService(int i) {
        this.tickRate = tickRate;
    }

    @Autowired
    public TemperatureService(TemperatureRepository dht22Repo) {
        this.dht22Repo = dht22Repo;
    }

    public TemperatureDataPojo saveDHT22Data(TemperatureDataPojo pojoData) {
        log.info("PojoData: " + pojoData.toString());
        TemperatureDao dao = TemperatureDataMapper.INSTANCE.pojoToDao(pojoData);
        dht22Repo.save(dao);
        return pojoData;
    }

    public TemperatureDataPojo findById(Long id) {
        return TemperatureDataMapper.INSTANCE.daoToPojo(dht22Repo.findById(id).get());
    }
}
