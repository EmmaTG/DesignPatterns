package com.etg.Adapter;

public class ImperialAdapter extends WeatherForecast {
    private WeatherService weather;

    public ImperialAdapter(WeatherService weather) {
        this.weather = weather;
    }

    @Override
    public String whatsTheWeather(String unit) {
        String s = "Temperature: ";
        double celsiusTemp = (weather.getTemperature()-32)*5/9;
        s += celsiusTemp;
        s += ", wind speed: ";
        double kmpWindSpeed = (weather.getWindSpeed())/1.6;
        s += kmpWindSpeed;

        return s;
    }
}
