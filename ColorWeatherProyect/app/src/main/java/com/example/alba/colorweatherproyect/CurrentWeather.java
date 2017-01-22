package com.example.alba.colorweatherproyect;

import android.graphics.drawable.Drawable;

/**
 * Created by Alba on 22/01/2017.
 */

public class CurrentWeather {

    private String description;
    private String currentTemperature;
    private String lowestTemperature;
    private String highestTemperature;
    private String iconImage;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getLowestTemperature() {
        return lowestTemperature;
    }

    public void setLowestTemperature(String lowestTemperature) {
        this.lowestTemperature = lowestTemperature;
    }

    public String getHighestTemperature() {
        return highestTemperature;
    }

    public void setHighestTemperature(String highestTemperature) {
        this.highestTemperature = highestTemperature;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    private Drawable getIconDrawableResource(){

        return null;

        

    }

}
