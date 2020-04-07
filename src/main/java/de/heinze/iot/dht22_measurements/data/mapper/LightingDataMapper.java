package de.heinze.iot.dht22_measurements.data.mapper;

import de.heinze.iot.dht22_measurements.data.dao.LightingDao;
import de.heinze.iot.dht22_measurements.data.pojo.LightingDataPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Mapper
public interface LightingDataMapper {

    LightingDataMapper INSTANCE = Mappers.getMapper(LightingDataMapper.class);

    LightingDataPojo daoToPojo(LightingDao plantDao);

    LightingDao pojoToDao(LightingDataPojo plantPojo);

    Iterable<LightingDataPojo> daoListToPojoList(Iterable<LightingDao> daoList);

    Iterable<LightingDao> pojoListToDaoList(Iterable<LightingDataPojo> pojoList);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }


}
