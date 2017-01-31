package com.example.alba.colorweatherproyect;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.alba.colorweatherproyect.Adapters.HourlyWeatherAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyWeatherActivity extends Activity {

    @BindView(R.id.hourlyListView) ListView hourlyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);
        ButterKnife.bind(this);

        Hour hour = new Hour();
        hour.setTitle("11:00 pm");
        hour.setWeatherDescription("There is a storm");

        Hour hour2 = new Hour();
        hour2.setTitle("12:00 pm");
        hour2.setWeatherDescription("There is a storm");

        ArrayList<Hour> hours = new ArrayList<Hour>();
        hours.add(hour);
        hours.add(hour2);

        HourlyWeatherAdapter hourlyWeatherAdapter = new HourlyWeatherAdapter(this, hours);

        hourlyListView.setAdapter(hourlyWeatherAdapter);

    }
}
