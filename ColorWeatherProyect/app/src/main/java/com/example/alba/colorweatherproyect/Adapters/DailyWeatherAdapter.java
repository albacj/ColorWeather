package com.example.alba.colorweatherproyect.Adapters;

import android.content.Context;
import android.util.Log;
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

    public static final String TAG = DailyWeatherAdapter.class.getSimpleName();

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

        ViewHolder viewHolder;
        Day day = days.get(position);

        if(convertView == null){ //Si la vista es null, la creamos

            Log.d(TAG, "Creando y buscando vistas");

            convertView = LayoutInflater.from(context).inflate(R.layout.daily_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.dayTitle = (TextView) convertView.findViewById(R.id.dailyListTitle);
            viewHolder.dayDescription = (TextView) convertView.findViewById(R.id.dailyListDescription);
            viewHolder.dayRainProbability = (TextView) convertView.findViewById(R.id.dailyListProbability);

            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.dayTitle.setText(day.getDayName());
        viewHolder.dayDescription.setText(day.getWeatherDescription());
        viewHolder.dayRainProbability.setText(day.getRainProbability());

        return convertView;
    }

    static class ViewHolder{

        TextView dayTitle;
        TextView dayDescription;
        TextView dayRainProbability;

    }

}
