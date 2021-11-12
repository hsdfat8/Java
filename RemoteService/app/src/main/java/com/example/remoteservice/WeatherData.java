package com.example.remoteservice;

import java.util.List;

public class WeatherData {
    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;
    public static final String KEY_Weather_DATA = "KEY_Weather_DATA";


    public WeatherData(Coord coord, List<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, int dt, Sys sys, int timezone, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public static class Coord{
        public double lon;
        public double lat;

        public Coord(double lon, double lat) {
            this.lon = lon;
            this.lat = lat;
        }
    }

    public static class Weather{
        public int id;
        public String main;
        public String description;
        public String icon;

        public Weather(int id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }
    }

    public static class Main{
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public int pressure;
        public int humidity;

        public Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity) {
            this.temp = temp;
            this.feels_like = feels_like;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
            this.pressure = pressure;
            this.humidity = humidity;
        }
    }

    public static class Wind{
        public double speed;
        public int deg;
        public double gust;

        public Wind(double speed, int deg, double gust) {
            this.speed = speed;
            this.deg = deg;
            this.gust = gust;
        }
    }

    public static class Clouds{
        public int all;

        public Clouds(int all) {
            this.all = all;
        }
    }

    public static class Sys{
        public int type;
        public int id;
        public String country;
        public int sunrise;
        public int sunset;

        public Sys(int type, int id, String country, int sunrise, int sunset) {
            this.type = type;
            this.id = id;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }
    }


}
