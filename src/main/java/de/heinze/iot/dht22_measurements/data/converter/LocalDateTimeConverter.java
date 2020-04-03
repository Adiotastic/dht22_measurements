package de.heinze.iot.dht22_measurements.data.converter;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Author: christianheinz
 * Date: 03.04.20
 */
@Slf4j
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Long> {
    @Override
    public Long convertToDatabaseColumn(LocalDateTime localDateTime) {
        log.debug("Long " + localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli() +" is date " + localDateTime);
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Long s) {
        log.debug("Long " + s +" is date " + LocalDateTime.ofInstant(Instant.ofEpochMilli(s), ZoneId.of("UTC")));
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(s), ZoneId.of("UTC"));
    }
}
