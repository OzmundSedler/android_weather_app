package com.example.sedler.weatherapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.mail.weather.lib.*;

public class MainActivity extends AppCompatActivity {

    private TextView temperatureTextView;
    private TextView statusTextView;
    private Button townButton;
    private Button foneButton;
    private Button noFoneButton;

    BroadcastReceiver broadcastReceiver;
    WeatherStorage weatherStorage;

    public final static String WEATHER_ACTION = "com.example.sedler.weatherapplication.action.weather";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureTextView = (TextView)findViewById(R.id.temperatureTextView);
        statusTextView = (TextView)findViewById(R.id.statusTextView);
        townButton = (Button)findViewById(R.id.townButton);
        foneButton = (Button)findViewById(R.id.foneButton);
        noFoneButton = (Button)findViewById(R.id.noFoneButton);

        weatherStorage = WeatherStorage.getInstance(MainActivity.this);
        townButton.setText(weatherStorage.getCurrentCity().name());

        townButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CitySelectActivity.class);
                startActivity(intent);
            }
        });

        foneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WeatherService.class);
                WeatherUtils.getInstance().schedule(MainActivity.this, intent);
            }
        });

        noFoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherService.class);
                WeatherUtils.getInstance().unschedule(MainActivity.this, intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        weatherStorage = WeatherStorage.getInstance(MainActivity.this);
        townButton.setText(weatherStorage.getCurrentCity().name());
        setWeather();
        IntentFilter intentFilter = new IntentFilter(WEATHER_ACTION);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setWeather();
            }
        };

        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(broadcastReceiver);
    }

    private void setWeather() {
        City city = weatherStorage.getCurrentCity();
        Weather weather = weatherStorage.getLastSavedWeather(city);
        if (weather != null) {
            temperatureTextView.setText(String.format("%s", weather.getTemperature()));
            statusTextView.setText(String.format("%s", weather.getDescription()));
        }
        else {
            statusTextView.setText("Пока погоды нет, нажмите на  обновить");
        }
    }
}


