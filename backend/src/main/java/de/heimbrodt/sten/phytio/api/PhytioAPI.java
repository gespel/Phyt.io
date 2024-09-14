package de.heimbrodt.sten.phytio.api;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import de.heimbrodt.sten.phytio.datascraper.WeatherDataScraper;
import de.heimbrodt.sten.phytio.models.JsonDataResponseResource;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.logging.Logger;

public class PhytioAPI extends Thread {

    public void run() {
        Logger log = Logger.getLogger("API");
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        server.createContext("/data", new SensorHandler());
        server.createContext("/weather", new WeatherDataHandler());
        server.createContext("/data-processor", new SensorDataProcessorHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        log.info("API server started");
        log.info("Server is listening on port 8080");
    }

    static class SensorDataProcessorHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            SensorDataProcessor processor = new SensorDataProcessor();
            processor.process();
            t.sendResponseHeaders(200, "Ok".getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write("Ok".getBytes());
            os.close();
        }
    }

    static class WeatherDataHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            WeatherDataScraper scraper = new WeatherDataScraper();
            scraper.scrape();
            String response = new Gson().toJson(scraper.getWeather());
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
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
