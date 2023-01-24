package com.etg.Adapter;

public class WeatherForecast {
    WeatherService weatherService = new WeatherService();

    public String whatsTheWeather(String unitsType){
        if (unitsType.equals("METRIC")) {
            ImperialAdapter adapter = new ImperialAdapter(weatherService);
            return adapter.whatsTheWeather(unitsType);
        }
        else if (unitsType.equals("IMPERIAL")) {
            return weatherService.whatsTheWeather(unitsType);
        }
        return "";
    }
}
