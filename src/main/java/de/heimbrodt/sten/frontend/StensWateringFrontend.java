package de.heimbrodt.sten.frontend;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import de.heimbrodt.sten.models.JsonDataResponseResource;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Objects;
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
        private JsonDataResponseResource currentResource;
        private SensorReadFileParser fp = new SensorReadFileParser();

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Gson gson = new Gson();
            updateResponseJson();
            String response = gson.toJson(currentResource);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        void updateResponseJson() {
            currentResource = new JsonDataResponseResource();
            for(File f : Objects.requireNonNull(new File("sensor-reads").listFiles())) {
                currentResource.addSensorRead(fp.parseSensorRead(f.getAbsolutePath()));
            }
        }
    }
}
