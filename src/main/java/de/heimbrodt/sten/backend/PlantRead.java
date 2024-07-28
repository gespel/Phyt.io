package de.heimbrodt.sten.backend;

public class PlantRead {
    public Plant plant;
    public String timestamp;

    public PlantRead(Plant plant) {
        this.plant = plant;
        this.timestamp = java.time.Instant.now().toString();
    }
}
