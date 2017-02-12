package com.example.alba.colorweatherproyect;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alba on 30/01/2017.
 */

public class Day implements Parcelable{

    private String dayName;
    private String weatherDescription;
    private String rainProbability;

    public Day(){

    }

    protected Day(Parcel in) {
        dayName = in.readString();
        weatherDescription = in.readString();
        rainProbability = in.readString();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(String rainProbability) {
        this.rainProbability = rainProbability;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public int describeContents() {
        return 0; // No lo necesito
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(dayName);
        dest.writeString(weatherDescription);
        dest.writeString(rainProbability);

    }
}
