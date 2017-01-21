package com.example.alba.colorweatherproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private TextView dailyWeatherTextView;
    //private TextView hourlyWeatherTextView;
    //private TextView minutelylyWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailyWeatherTextView = (TextView) findViewById(R.id.dailyWeatherTextView);
        dailyWeatherTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dailyActivityIntent = new Intent(MainActivity.this, DailyWeatherActivity.class);
                startActivity(dailyActivityIntent);

            }
        });
    }
}
