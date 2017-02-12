package com.example.alba.colorweatherproyect;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.alba.colorweatherproyect.Adapters.DailyWeatherAdapter;

import java.util.ArrayList;

public class DailyWeatherActivity extends ListActivity { //ListActivity ayuda a trabajar con listViews

    public static final String TAG = DailyWeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_weather);

        ArrayList<Day> days = new ArrayList<Day>();

        for(int i = 0; i < 500; i++){

            Day day = new Day();
            day.setDayName("Monday");
            day.setWeatherDescription("It is going to rain");
            day.setRainProbability("Rain probability: 99%");

            days.add(day);

        }

        DailyWeatherAdapter dailyWeatherAdapter = new DailyWeatherAdapter(this,days);

        setListAdapter(dailyWeatherAdapter);
    }
}
