package com.example.alba.colorweatherproyect.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alba.colorweatherproyect.Day;
import com.example.alba.colorweatherproyect.R;

import java.util.ArrayList;

/**
 * Created by Alba on 30/01/2017.
 */

public class DailyWeatherAdapter extends BaseAdapter{

    ArrayList<Day> days;
    Context context;

    public DailyWeatherAdapter(Context context, ArrayList<Day> days){
        this.context = context;
        this.days = days;
    }

    @Override
    public int getCount() { // cuántos elementos hay en nuestros datos
        return days.size();
    }

    @Override
    public Object getItem(int position) { // Posiciones a "rendear"
        return days.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0; // No lo usaremos
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //Como vamos a rendear la vista y a mapear los datos

        Day day = days.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.daily_list_item, null);

        TextView dayTitle = (TextView) convertView.findViewById(R.id.dailyListTitle);
        TextView dayDescription = (TextView) convertView.findViewById(R.id.dailyListDescription);
        TextView dayRainProbability = (TextView) convertView.findViewById(R.id.dailyListProbability);

        dayTitle.setText(day.getDayName());
        dayDescription.setText(day.getWeatherDescription());
        dayRainProbability.setText(day.getRainProbability());

        return convertView;
    }

}
