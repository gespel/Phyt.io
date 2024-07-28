package de.heimbrodt.sten.frontend;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import de.heimbrodt.sten.backend.SensorRead;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class StensWateringFrontend extends Thread {

    public void run() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        server.createContext("/hello", new SensorHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server is listening on port 8080");
    }

    static class SensorHandler implements HttpHandler {
        private SensorResource currentResource;

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Gson gson = new Gson();
            readFile("prototyp.csv");
            String response = gson.toJson(currentResource);
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        void readFile(String fileName) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(fileName));
                String line = br.readLine();
                currentResource = new SensorResource();
                while (line != null) {
                    String[] split = line.split(",");
                    List p = new ArrayList();
                    p.add(split[1]);
                    SensorRead sr = new SensorRead(split[0], p, java.time.Instant.now().toString());
                    currentResource.addRead(sr);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
