package de.heinze.iot.dht22_measurements.data.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Author: christianheinz
 * Date: 07.04.20
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantDataDao {
    @Id
    @GeneratedValue
    private long plantId;

    private long minimumTemperature;

    private long optimumSoilHumidity;

    private long optimumLighting;

    private String plantName;

    private String note;

    private String location;

    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<LightingDao> lightingData;

    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<TemperatureDao> temperatureData;

    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<SoilHumidityDao> soilHumidityData;
}
