package de.heimbrodt.sten.frontend;

import de.heimbrodt.sten.backend.PlantRead;
import de.heimbrodt.sten.backend.SensorRead;

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
