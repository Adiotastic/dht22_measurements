package de.heinze.iot.dht22_measurements.data.mapper;

import de.heinze.iot.dht22_measurements.data.dao.TemperatureDao;
import de.heinze.iot.dht22_measurements.data.pojo.TemperatureDataPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Mapper
public interface TemperatureDataMapper {

    TemperatureDataMapper INSTANCE = Mappers.getMapper(TemperatureDataMapper.class);

    TemperatureDataPojo daoToPojo(TemperatureDao plantDao);

    TemperatureDao pojoToDao(TemperatureDataPojo plantPojo);

    Iterable<TemperatureDataPojo> daoListToPojoList(Iterable<TemperatureDao> daoList);

    Iterable<TemperatureDao> pojoListToDaoList(Iterable<TemperatureDataPojo> pojoList);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }


}
