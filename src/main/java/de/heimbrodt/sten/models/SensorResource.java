package de.heimbrodt.sten.models;

import java.util.ArrayList;
import java.util.List;

public class SensorResource {
    private List<SensorRead> sensorReads;

    public SensorResource() {
        this.sensorReads = new ArrayList<>();
    }

    public void addRead(SensorRead read) {
        this.sensorReads.add(read);
    }
    public List<SensorRead> getResource() {
        return this.sensorReads;
    }
}
