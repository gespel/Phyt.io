package de.heimbrodt.sten.phytio.datascraper;

import com.google.gson.Gson;
import de.heimbrodt.sten.phytio.models.WeatherResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class WeatherDataScraper {
    Logger log = Logger.getLogger("WeatherDataScraper");
    Gson gson = new Gson();
    WeatherResponse weatherResponse;
    public WeatherDataScraper() {

    }

    public void scrape() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.brightsky.dev/current_weather?lat=52.52&lon=13.4"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {
                weatherResponse = gson.fromJson(response.body(), WeatherResponse.class);
            }
            else {
                System.out.println(response.statusCode());
            }
            client.close();
            log.info("Successfully scraped weather data.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public WeatherResponse.Weather getWeather() {
        return weatherResponse.getWeather();
    }
}
