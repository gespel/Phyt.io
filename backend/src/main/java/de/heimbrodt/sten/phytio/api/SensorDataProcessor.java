package de.heimbrodt.sten.phytio.api;

import com.google.gson.Gson;
import de.heimbrodt.sten.phytio.models.PlantDataPoint;
import de.heimbrodt.sten.phytio.models.SensorRead;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SensorDataProcessor {
    private List<SensorRead> sensorReadList = new ArrayList<>();

    public SensorDataProcessor() throws IOException {
        Gson gson = new Gson();
        for(File f : Objects.requireNonNull(new File("sensor-reads").listFiles())) {
            SensorRead sr = gson.fromJson(new FileReader(f), SensorRead.class);
            sensorReadList.add(sr);
        }
    }

    public void process() {
        for(SensorRead sr : sensorReadList) {
            System.out.println(sr.getSensorName());
            System.out.println(sr.getTimestamp());
            for(PlantDataPoint dp : sr.getPlantDataPoints()) {
                System.out.println(dp.getName());
                System.out.println(dp.getHumidity());
            }
            System.out.println();
        }
    }
}
