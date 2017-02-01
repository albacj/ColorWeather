package com.example.alba.colorweatherproyect;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.iconImageView) ImageView iconImageView;
    @BindView(R.id.descriptionTextView) TextView descriptionTextView;
    @BindView(R.id.currentTempTextView) TextView currentTempTextView;
    @BindView(R.id.highestTemptextView) TextView highestTempTextView;
    @BindView(R.id.lowestTemptextView) TextView lowestTempTextView;

    @BindDrawable(R.drawable.clear_night) Drawable clearNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url ="https://api.darksky.net/forecast/555f4b7ea7d6d56e50b3edb687f9034f/37.8267,-122.4233?units=si";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    CurrentWeather currentWeather = getCurrentWeatherFromJSON(response);

                    ArrayList<Day> days = getDailyWeatherFromJson(response);

                    for (Day day : days) {
                        Log.d(TAG, day.getDayName());
                        Log.d(TAG, day.getWeatherDescription());
                        Log.d(TAG, day.getRainProbability());
                    }

                    iconImageView.setImageDrawable(currentWeather.getIconDrawableResource());
                    descriptionTextView.setText(currentWeather.getDescription());
                    currentTempTextView.setText(currentWeather.getCurrentTemperature());
                    highestTempTextView.setText(String.format("H: %sº", currentWeather.getHighestTemperature()));
                    lowestTempTextView.setText(String.format("L: %sº", currentWeather.getLowestTemperature()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "That didn't work");
            }
        });

    // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    @OnClick(R.id.dailyWeatherTextView)
    public void dailyWeatherClick(){
        Intent dailyActivityIntent = new Intent(MainActivity.this, DailyWeatherActivity.class);
        startActivity(dailyActivityIntent);
    }

    @OnClick(R.id.hourlyWeatherTextView)
    public void hourlyWeatherClick(){
        Intent hourlyActivityIntent = new Intent(MainActivity.this, HourlyWeatherActivity.class);
        startActivity(hourlyActivityIntent);
    }

    @OnClick(R.id.minutelyWeatherTextView)
    public void minutelyWeatherClick(){
        Intent minutelyActivityIntent = new Intent(MainActivity.this, MinutelyWeatherActivity.class);
        startActivity(minutelyActivityIntent);
    }

    private CurrentWeather getCurrentWeatherFromJSON(String json)throws JSONException{

        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonWithCurrentWeather = jsonObject.getJSONObject("currently");
        JSONObject jsonWithDailyWeather = jsonObject.getJSONObject("daily");

        JSONArray jsonWithDailyWeatherData = jsonWithDailyWeather.getJSONArray("data");

        JSONObject jsonWithTodayData = jsonWithDailyWeatherData.getJSONObject(0);

        String summary = jsonWithCurrentWeather.getString("summary");
        String icon = jsonWithCurrentWeather.getString("icon");
        String temperature = Math.round(jsonWithCurrentWeather.getDouble("temperature")) + "";
        String maxTemperature = Math.round(jsonWithTodayData.getDouble("temperatureMax")) + "";
        String minTemperature = Math.round(jsonWithTodayData.getDouble("temperatureMin")) + "";

        CurrentWeather currentWeather = new CurrentWeather(MainActivity.this);

        currentWeather.setDescription(summary);
        currentWeather.setIconImage(icon);
        currentWeather.setCurrentTemperature(temperature);
        currentWeather.setHighestTemperature(maxTemperature);
        currentWeather.setLowestTemperature(minTemperature);

        return currentWeather;

    }

    private ArrayList<Day> getDailyWeatherFromJson(String json)throws JSONException{

        DateFormat dateFormat = new SimpleDateFormat("EEEE");

        ArrayList<Day> days = new ArrayList<Day>();

        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonWithDailyWeather = jsonObject.getJSONObject("daily");

        JSONArray jsonWithDailyWeatherData = jsonWithDailyWeather.getJSONArray("data");

        for(int i = 0; i <= jsonWithDailyWeatherData.length(); i++){ // Devuelve e numero de elementos

            Day day = new Day();

            JSONObject jsonWithDayData = jsonWithDailyWeatherData.getJSONObject(i);

            String rainProbability = jsonWithDayData.getLong("precipProbability") + "";
            String description = jsonWithDayData.getString("summary");
            String dayName = dateFormat.format(jsonWithDayData.getLong("time")*1000); // Pasar de ms a s

            day.setDayName(dayName);
            day.setRainProbability(rainProbability);
            day.setWeatherDescription(description);

            days.add(day);

        }

        return days;

    }

}
