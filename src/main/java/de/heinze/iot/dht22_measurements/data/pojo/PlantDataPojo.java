package de.heinze.iot.dht22_measurements.data.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantDataPojo {

    private long minimumTemperature;

    private long optimumSoilHumidity;

    private long optimumLighting;

    private String plantName;

    private String note;

    private String location;

}
