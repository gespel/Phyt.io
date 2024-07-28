package de.heimbrodt.sten.backend;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class StensWateringBackend {
    private String pathPrefix;

    public StensWateringBackend(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public void run() throws InterruptedException {
        Logger log = Logger.getLogger("StensWateringBackend");
        while (true) {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("http://192.168.2.168/json"))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if(response.statusCode() == 200) {
                    Gson gson = new Gson();
                    SensorRead s = gson.fromJson(response.body(), SensorRead.class);

                    String saveName = pathPrefix + s.getSensorName() + ".csv";
                    File f = new File(saveName);
                    PrintWriter pw = null;

                    if(f.exists() && !f.isDirectory()) {
                        pw = new PrintWriter(new FileOutputStream(saveName, true));
                    }
                    else {
                        pw = new PrintWriter(saveName);
                    }
                    for(Plant p : s.getPlants()) {
                        pw
                                .append(java.time.Instant.now().toString())
                                .append(",")
                                .append(p.getName())
                                .append(",")
                                .append(String.valueOf(p.getHumidity()))
                                .append("\n");
                    }
                    pw.close();
                }
                else {
                    System.out.println(response.statusCode());
                }
                client.close();
                log.info("Successfully added datapoint.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(10000);
        }
    }
}
