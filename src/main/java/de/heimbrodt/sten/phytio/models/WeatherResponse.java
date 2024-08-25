package de.heimbrodt.sten.phytio.models;

import java.util.List;
import java.util.Map;

public class WeatherResponse {

    private Weather weather;
    private List<Source> sources;

    // Getter und Setter
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "weather=" + weather +
                ", sources=" + sources +
                '}';
    }

    // Weather-Klasse
    public static class Weather {
        private int source_id;
        private String timestamp;
        private int cloud_cover;
        private String condition;
        private double dew_point;
        private double solar_10;
        private double solar_30;
        private double solar_60;
        private double precipitation_10;
        private double precipitation_30;
        private double precipitation_60;
        private double pressure_msl;
        private int relative_humidity;
        private int visibility;
        private int wind_direction_10;
        private int wind_direction_30;
        private int wind_direction_60;
        private double wind_speed_10;
        private double wind_speed_30;
        private double wind_speed_60;
        private int wind_gust_direction_10;
        private int wind_gust_direction_30;
        private int wind_gust_direction_60;
        private double wind_gust_speed_10;
        private double wind_gust_speed_30;
        private double wind_gust_speed_60;
        private int sunshine_30;
        private int sunshine_60;
        private double temperature;
        private Map<String, Integer> fallback_source_ids;
        private String icon;

        // Getter und Setter

        public int getSource_id() {
            return source_id;
        }

        public void setSource_id(int source_id) {
            this.source_id = source_id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getCloud_cover() {
            return cloud_cover;
        }

        public void setCloud_cover(int cloud_cover) {
            this.cloud_cover = cloud_cover;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public double getDew_point() {
            return dew_point;
        }

        public void setDew_point(double dew_point) {
            this.dew_point = dew_point;
        }

        public double getSolar_10() {
            return solar_10;
        }

        public void setSolar_10(double solar_10) {
            this.solar_10 = solar_10;
        }

        public double getSolar_30() {
            return solar_30;
        }

        public void setSolar_30(double solar_30) {
            this.solar_30 = solar_30;
        }

        public double getSolar_60() {
            return solar_60;
        }

        public void setSolar_60(double solar_60) {
            this.solar_60 = solar_60;
        }

        public double getPrecipitation_10() {
            return precipitation_10;
        }

        public void setPrecipitation_10(double precipitation_10) {
            this.precipitation_10 = precipitation_10;
        }

        public double getPrecipitation_30() {
            return precipitation_30;
        }

        public void setPrecipitation_30(double precipitation_30) {
            this.precipitation_30 = precipitation_30;
        }

        public double getPrecipitation_60() {
            return precipitation_60;
        }

        public void setPrecipitation_60(double precipitation_60) {
            this.precipitation_60 = precipitation_60;
        }

        public double getPressure_msl() {
            return pressure_msl;
        }

        public void setPressure_msl(double pressure_msl) {
            this.pressure_msl = pressure_msl;
        }

        public int getRelative_humidity() {
            return relative_humidity;
        }

        public void setRelative_humidity(int relative_humidity) {
            this.relative_humidity = relative_humidity;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        public int getWind_direction_10() {
            return wind_direction_10;
        }

        public void setWind_direction_10(int wind_direction_10) {
            this.wind_direction_10 = wind_direction_10;
        }

        public int getWind_direction_30() {
            return wind_direction_30;
        }

        public void setWind_direction_30(int wind_direction_30) {
            this.wind_direction_30 = wind_direction_30;
        }

        public int getWind_direction_60() {
            return wind_direction_60;
        }

        public void setWind_direction_60(int wind_direction_60) {
            this.wind_direction_60 = wind_direction_60;
        }

        public double getWind_speed_10() {
            return wind_speed_10;
        }

        public void setWind_speed_10(double wind_speed_10) {
            this.wind_speed_10 = wind_speed_10;
        }

        public double getWind_speed_30() {
            return wind_speed_30;
        }

        public void setWind_speed_30(double wind_speed_30) {
            this.wind_speed_30 = wind_speed_30;
        }

        public double getWind_speed_60() {
            return wind_speed_60;
        }

        public void setWind_speed_60(double wind_speed_60) {
            this.wind_speed_60 = wind_speed_60;
        }

        public int getWind_gust_direction_10() {
            return wind_gust_direction_10;
        }

        public void setWind_gust_direction_10(int wind_gust_direction_10) {
            this.wind_gust_direction_10 = wind_gust_direction_10;
        }

        public int getWind_gust_direction_30() {
            return wind_gust_direction_30;
        }

        public void setWind_gust_direction_30(int wind_gust_direction_30) {
            this.wind_gust_direction_30 = wind_gust_direction_30;
        }

        public int getWind_gust_direction_60() {
            return wind_gust_direction_60;
        }

        public void setWind_gust_direction_60(int wind_gust_direction_60) {
            this.wind_gust_direction_60 = wind_gust_direction_60;
        }

        public double getWind_gust_speed_10() {
            return wind_gust_speed_10;
        }

        public void setWind_gust_speed_10(double wind_gust_speed_10) {
            this.wind_gust_speed_10 = wind_gust_speed_10;
        }

        public double getWind_gust_speed_30() {
            return wind_gust_speed_30;
        }

        public void setWind_gust_speed_30(double wind_gust_speed_30) {
            this.wind_gust_speed_30 = wind_gust_speed_30;
        }

        public double getWind_gust_speed_60() {
            return wind_gust_speed_60;
        }

        public void setWind_gust_speed_60(double wind_gust_speed_60) {
            this.wind_gust_speed_60 = wind_gust_speed_60;
        }

        public int getSunshine_30() {
            return sunshine_30;
        }

        public void setSunshine_30(int sunshine_30) {
            this.sunshine_30 = sunshine_30;
        }

        public int getSunshine_60() {
            return sunshine_60;
        }

        public void setSunshine_60(int sunshine_60) {
            this.sunshine_60 = sunshine_60;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public Map<String, Integer> getFallback_source_ids() {
            return fallback_source_ids;
        }

        public void setFallback_source_ids(Map<String, Integer> fallback_source_ids) {
            this.fallback_source_ids = fallback_source_ids;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "source_id=" + source_id +
                    ", timestamp='" + timestamp + '\'' +
                    ", cloud_cover=" + cloud_cover +
                    ", condition='" + condition + '\'' +
                    ", dew_point=" + dew_point +
                    ", solar_10=" + solar_10 +
                    ", solar_30=" + solar_30 +
                    ", solar_60=" + solar_60 +
                    ", precipitation_10=" + precipitation_10 +
                    ", precipitation_30=" + precipitation_30 +
                    ", precipitation_60=" + precipitation_60 +
                    ", pressure_msl=" + pressure_msl +
                    ", relative_humidity=" + relative_humidity +
                    ", visibility=" + visibility +
                    ", wind_direction_10=" + wind_direction_10 +
                    ", wind_direction_30=" + wind_direction_30 +
                    ", wind_direction_60=" + wind_direction_60 +
                    ", wind_speed_10=" + wind_speed_10 +
                    ", wind_speed_30=" + wind_speed_30 +
                    ", wind_speed_60=" + wind_speed_60 +
                    ", wind_gust_direction_10=" + wind_gust_direction_10 +
                    ", wind_gust_direction_30=" + wind_gust_direction_30 +
                    ", wind_gust_direction_60=" + wind_gust_direction_60 +
                    ", wind_gust_speed_10=" + wind_gust_speed_10 +
                    ", wind_gust_speed_30=" + wind_gust_speed_30 +
                    ", wind_gust_speed_60=" + wind_gust_speed_60 +
                    ", sunshine_30=" + sunshine_30 +
                    ", sunshine_60=" + sunshine_60 +
                    ", temperature=" + temperature +
                    ", fallback_source_ids=" + fallback_source_ids +
                    ", icon='" + icon + '\'' +
                    '}';
        }
    }

    // Source-Klasse
    public static class Source {
        private int id;
        private String dwd_station_id;
        private String observation_type;
        private double lat;
        private double lon;
        private double height;
        private String station_name;
        private String wmo_station_id;
        private String first_record;
        private String last_record;
        private int distance;

        // Getter und Setter

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDwd_station_id() {
            return dwd_station_id;
        }

        public void setDwd_station_id(String dwd_station_id) {
            this.dwd_station_id = dwd_station_id;
        }

        public String getObservation_type() {
            return observation_type;
        }

        public void setObservation_type(String observation_type) {
            this.observation_type = observation_type;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getStation_name() {
            return station_name;
        }

        public void setStation_name(String station_name) {
            this.station_name = station_name;
        }

        public String getWmo_station_id() {
            return wmo_station_id;
        }

        public void setWmo_station_id(String wmo_station_id) {
            this.wmo_station_id = wmo_station_id;
        }

        public String getFirst_record() {
            return first_record;
        }

        public void setFirst_record(String first_record) {
            this.first_record = first_record;
        }

        public String getLast_record() {
            return last_record;
        }

        public void setLast_record(String last_record) {
            this.last_record = last_record;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Source{" +
                    "id=" + id +
                    ", dwd_station_id='" + dwd_station_id + '\'' +
                    ", observation_type='" + observation_type + '\'' +
                    ", lat=" + lat +
                    ", lon=" + lon +
                    ", height=" + height +
                    ", station_name='" + station_name + '\'' +
                    ", wmo_station_id='" + wmo_station_id + '\'' +
                    ", first_record='" + first_record + '\'' +
                    ", last_record='" + last_record + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }
}
