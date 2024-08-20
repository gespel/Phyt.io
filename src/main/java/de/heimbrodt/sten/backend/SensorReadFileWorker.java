package de.heimbrodt.sten.backend;

import com.google.gson.Gson;
import de.heimbrodt.sten.models.SensorRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SensorReadFileWorker {

    void writeSensorRead(String response) throws FileNotFoundException {
        Gson gson = new Gson();
        SensorRead s = gson.fromJson(response, SensorRead.class);

        String saveName = "sensor-reads/" + s.getSensorName() + "-" + ZonedDateTime.ofInstant(java.time.Instant.now(), ZoneId.systemDefault()) + ".json";

        if(!new File("sensor-reads/").exists()) {
            new File("sensor-reads/").mkdir();
        }

        PrintWriter pw = new PrintWriter(saveName);
        pw.append(gson.toJson(s));
        pw.close();
    }
}
