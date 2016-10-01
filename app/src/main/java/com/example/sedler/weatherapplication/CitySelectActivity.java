package com.example.sedler.weatherapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.mail.weather.lib.City;
import ru.mail.weather.lib.WeatherStorage;

public class CitySelectActivity extends AppCompatActivity {

    private Button firstTownButton;
    private Button secondTownButton;
    private Button thirdTownButton;
    private Button fourthTownButton;
    private Button fifthTownButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);

        firstTownButton = (Button)findViewById(R.id.firstTownButton);
        secondTownButton = (Button)findViewById(R.id.secondTownButton);
        thirdTownButton = (Button)findViewById(R.id.thirdTownButton);
        fourthTownButton = (Button)findViewById(R.id.fourthTownButton);
        fifthTownButton = (Button)findViewById(R.id.fifthTownButton);

        firstTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.SPRINGFIELD);
                finish();
            }
        });

        secondTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.RACCOON_CITY);
                finish();
            }
        });

        thirdTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.SILENT_HILL);
                finish();
            }
        });

        fourthTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.VICE_CITY);
                finish();
            }
        });

        fifthTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherStorage.getInstance(CitySelectActivity.this).setCurrentCity(City.SOUTH_PARK);
                finish();
            }
        });


    }


}

