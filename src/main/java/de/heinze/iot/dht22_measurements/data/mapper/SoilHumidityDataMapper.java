package de.heinze.iot.dht22_measurements.data.mapper;

import de.heinze.iot.dht22_measurements.data.dao.SoilHumidityDao;
import de.heinze.iot.dht22_measurements.data.pojo.SoilHumidityDataPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Mapper
public interface SoilHumidityDataMapper {

    SoilHumidityDataMapper INSTANCE = Mappers.getMapper(SoilHumidityDataMapper.class);

    SoilHumidityDataPojo daoToPojo(SoilHumidityDao plantDao);

    SoilHumidityDao pojoToDao(SoilHumidityDataPojo plantPojo);

    Iterable<SoilHumidityDataPojo> daoListToPojoList(Iterable<SoilHumidityDao> daoList);

    Iterable<SoilHumidityDao> pojoListToDaoList(Iterable<SoilHumidityDataPojo> pojoList);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }


}
