package de.heinze.iot.dht22_measurements.data.mapper;

import de.heinze.iot.dht22_measurements.data.dao.PlantDataDao;
import de.heinze.iot.dht22_measurements.data.pojo.PlantDataPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Mapper
public interface PlantDataMapper {

    PlantDataMapper INSTANCE = Mappers.getMapper(PlantDataMapper.class);

    PlantDataPojo daoToPojo(PlantDataDao plantDao);

    PlantDataDao pojoToDao(PlantDataPojo plantPojo);

    Iterable<PlantDataPojo> daoListToPojoList(Iterable<PlantDataDao> daoList);

    Iterable<PlantDataDao> pojoListToDaoList(Iterable<PlantDataPojo> pojoList);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }


}
