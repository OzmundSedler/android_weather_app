package com.example.sedler.weatherapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.support.v4.content.LocalBroadcastManager;
import java.io.IOException;

import ru.mail.weather.lib.City;
import ru.mail.weather.lib.Weather;
import ru.mail.weather.lib.WeatherStorage;
import ru.mail.weather.lib.WeatherUtils;


public class WeatherService extends IntentService {

    public final static String WEATHER_ACTION = "com.example.sedler.weatherapplication.action.weather";

    public WeatherService() {
        super("WeatherService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        WeatherStorage weatherStorage = WeatherStorage.getInstance(this);

        try {
            City city = WeatherStorage.getInstance(WeatherService.this).getCurrentCity();
            Weather weather = WeatherUtils.getInstance().loadWeather(city);
            weatherStorage.saveWeather(city, weather);
            Intent wIntent = new Intent(WEATHER_ACTION);
            LocalBroadcastManager.getInstance(this).sendBroadcast(wIntent);
        }
        catch (IOException e) {
            Log.d("ERROR","error");
        }

    }

}