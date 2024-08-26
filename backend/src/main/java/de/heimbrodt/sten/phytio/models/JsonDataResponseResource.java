package de.heimbrodt.sten.phytio.models;

import java.util.ArrayList;
import java.util.List;

public class JsonDataResponseResource {
    private List<SensorRead> sensorReads = new ArrayList<>();

    public JsonDataResponseResource() {

    }

    public List<SensorRead> getSensorReads() {
        return sensorReads;
    }

    public void addSensorRead(SensorRead sr) {
        this.sensorReads.add(sr);
    }
}
