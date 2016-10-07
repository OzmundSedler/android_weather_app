package com.example.sedler.weatherapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.content.LocalBroadcastManager;
import ru.mail.weather.lib.City;
import ru.mail.weather.lib.WeatherStorage;

public class CitySelectActivity extends AppCompatActivity {

    private Button springfieldButton;
    private Button racoonButton;
    private Button silentButton;
    private Button viceButton;
    private Button southButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);

        springfieldButton = (Button)findViewById(R.id.springfieldButton);
        racoonButton = (Button)findViewById(R.id.racoonButton);
        silentButton = (Button)findViewById(R.id.silentButton);
        viceButton = (Button)findViewById(R.id.viceButton);
        southButton = (Button)findViewById(R.id.southButton);

        springfieldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.SPRINGFIELD);
                finish();
            }
        });

        racoonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.RACCOON_CITY);
                finish();
            }
        });

        silentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.SILENT_HILL);
                finish();
            }
        });

        viceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.VICE_CITY);
                finish();
            }
        });

        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.SOUTH_PARK);
                finish();
            }
        });


    }


}

