package de.heimbrodt.sten.backend;

import java.util.List;

public class SensorRead {
    private String sensorName;
    private List<Plant> plants;
    private String timestamp;

    public SensorRead() {
        this.timestamp = java.time.Instant.now().toString();
    }
    public SensorRead(String sensorName, List<Plant> plants, String timestamp) {
        this.timestamp = timestamp;
        this.sensorName = sensorName;
        this.plants = plants;
    }

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
    public String getTimestamp() {
        return timestamp;
    }
}
