package de.heimbrodt.sten.backend;

import java.util.List;

public class SaveJson {
    private String sensorName;
    private List<PlantRead> data;

    public String getSensorName() {
        return sensorName;
    }
    public List<PlantRead> getData() {
        return data;
    }

    public void addDataPoint(Plant plant) {
        data.add(new PlantRead(plant));
    }

}
