package de.heimbrodt.sten.models;

public class PlantDataPoint {
    private String name;
    private float humidity;

    public PlantDataPoint(String name, float humidity) {
        this.name = name;
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }
    public float getHumidity() {
        return humidity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
