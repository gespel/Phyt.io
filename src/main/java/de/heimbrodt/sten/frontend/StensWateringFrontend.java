package de.heimbrodt.sten.frontend;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import de.heimbrodt.sten.models.Plant;
import de.heimbrodt.sten.models.SensorRead;
import de.heimbrodt.sten.models.SensorResource;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StensWateringFrontend extends Thread {

    public void run() {
        Logger log = Logger.getLogger("Frontend");
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        server.createContext("/data", new SensorHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        log.info("Frontend server started");
        log.info("Server is listening on port 8080");
    }

    static class SensorHandler implements HttpHandler {
        private SensorResource currentResource;

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Gson gson = new Gson();
            readFile("prototyp.csv");
            String response = gson.toJson(currentResource);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        void readFile(String fileName) {
            BufferedReader br = null;
            String sensorName = fileName.split("\\.")[0];
            try {
                br = new BufferedReader(new FileReader(fileName));
                String line = br.readLine();
                currentResource = new SensorResource();
                while (line != null) {
                    String[] split = line.split(",");
                    List<Plant> plants = new ArrayList<Plant>();
                    Plant pl = new Plant(split[1], Float.parseFloat(split[2]));

                    plants.add(pl);

                    SensorRead sr = new SensorRead(sensorName, plants, split[0]);

                    currentResource.addRead(sr);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error reading file " + e.getMessage());
            }
        }
    }
}
