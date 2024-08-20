package de.heimbrodt.sten.frontend;

import com.google.gson.Gson;
import de.heimbrodt.sten.models.SensorRead;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class SensorReadFileParser {
    private Gson gson;
    private Logger log = Logger.getLogger("SensorReadFileParser");

    public SensorReadFileParser() {
        this.gson = new Gson();
    }
    public SensorRead parseSensorRead(String filePath) {
        try {
            log.fine("Parsing file: " + filePath);
            //System.out.println(Files.readString(Path.of(filePath)));
            SensorRead sensorRead = gson.fromJson(Files.readString(Path.of(filePath)), SensorRead.class);
            return sensorRead;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
