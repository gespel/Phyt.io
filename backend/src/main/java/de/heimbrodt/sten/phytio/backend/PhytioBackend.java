package de.heimbrodt.sten.phytio.backend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class PhytioBackend extends Thread {
    private SensorReadFileWorker worker = new SensorReadFileWorker();
    Logger logger = Logger.getLogger("backend");
    public PhytioBackend( ) {
        logger.info("Phyt.io Backend initialized");
    }

    public void run() {
        logger.info("Phyt.io Backend started");
        while (true) {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("http://192.168.2.168/json"))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if(response.statusCode() == 200) {
                    worker.writeSensorRead(response.body());
                }
                else {
                    System.out.println(response.statusCode());
                }
                client.close();
                logger.info("Successfully added datapoint from sensor.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
