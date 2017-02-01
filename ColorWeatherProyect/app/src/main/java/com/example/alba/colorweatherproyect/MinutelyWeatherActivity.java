package com.example.alba.colorweatherproyect;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alba.colorweatherproyect.Adapters.MinutelyWeatherAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MinutelyWeatherActivity extends Activity {

    @BindView(R.id.minutelyRecyclerView) RecyclerView minutelyRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutely_weather);
        ButterKnife.bind(this);

        ArrayList<Minute> minutes = new ArrayList<Minute>();

        Minute minute = new Minute();
        minute.setTitle("19:55");
        minute.setRainProbability("99%");

        Minute minute2 = new Minute();
        minute2.setTitle("19:56");
        minute2.setRainProbability("99%");

        Minute minute3 = new Minute();
        minute3.setTitle("19:57");
        minute3.setRainProbability("99%");

        Minute minute4 = new Minute();
        minute4.setTitle("19:58");
        minute4.setRainProbability("99%");

        minutes.add(minute);
        minutes.add(minute2);
        minutes.add(minute3);
        minutes.add(minute4);

        MinutelyWeatherAdapter minutelyWeatherAdapter = new MinutelyWeatherAdapter(this, minutes);

        minutelyRecyclerView.setAdapter(minutelyWeatherAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        minutelyRecyclerView.setLayoutManager(layoutManager);

        minutelyRecyclerView.setHasFixedSize(true); // Los elementos son de un tamaño especifico

    }
}
