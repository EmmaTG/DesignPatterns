package com.etg.Adapter;

public class WeatherService {
    // WOuld be an api that gives data in imperial units

    public double getTemperature(){
        return 105; // Temperature in Farenheit
    }
    public double getWindSpeed(){
        return 1.2; // Wind speed in miles per hour
    }

    public String whatsTheWeather(String units){
        String s = "Temperature: " + this.getTemperature();
        s += ", wind speed: " + this.getWindSpeed();
        return s;
    }
}
