package de.heimbrodt.sten.backend;

import java.util.List;

public class SensorRead {
    private String sensorName;
    private List<Plant> plants;

    public String getSensorName() {
        return sensorName;
    }
    public List<Plant> getPlants() {
        return plants;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
