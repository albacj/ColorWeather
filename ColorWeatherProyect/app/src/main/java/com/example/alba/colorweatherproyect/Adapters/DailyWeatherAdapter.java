package com.example.alba.colorweatherproyect.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Alba on 30/01/2017.
 */

public class DailyWeatherAdapter extends BaseAdapter{

    @Override
    public int getCount() { // cuántos elementos hay en nuestros datos
        return 0;
    }

    @Override
    public Object getItem(int position) { // Posiciones a "rendear"
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0; // No lo usaremos
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //Como vamos a rendear la vista y a mapear los datos
        return null;
    }

}
