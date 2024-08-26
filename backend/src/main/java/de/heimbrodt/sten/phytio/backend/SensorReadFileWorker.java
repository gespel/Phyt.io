package de.heimbrodt.sten.phytio.backend;

import com.google.gson.Gson;
import de.heimbrodt.sten.phytio.models.SensorRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SensorReadFileWorker {

    void writeSensorRead(String response) throws FileNotFoundException {
        Gson gson = new Gson();
        SensorRead s = gson.fromJson(response, SensorRead.class);

        String saveName = "sensor-reads/" + s.getSensorName() + "-" + java.time.Instant.now() + ".json";

        if(!new File("sensor-reads/").exists()) {
            new File("sensor-reads/").mkdir();
        }

        PrintWriter pw = new PrintWriter(saveName);
        pw.append(gson.toJson(s));
        pw.close();
    }
}
