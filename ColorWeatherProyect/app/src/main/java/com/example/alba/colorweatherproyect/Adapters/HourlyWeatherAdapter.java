package com.example.alba.colorweatherproyect.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alba.colorweatherproyect.Hour;
import com.example.alba.colorweatherproyect.R;

import java.util.ArrayList;

/**
 * Created by Alba on 31/01/2017.
 */

public class HourlyWeatherAdapter extends BaseAdapter{

    public static final String TAG = HourlyWeatherAdapter.class.getSimpleName();

    ArrayList<Hour> hours;
    Context context;

    public HourlyWeatherAdapter(Context context, ArrayList<Hour> hours){
        this.context = context;
        this.hours = hours;
    }

    @Override
    public int getCount() {
        return hours.size();
    }

    @Override
    public Object getItem(int position) {
        return hours.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        Hour hour = hours.get(position);

        if(convertView == null){ //Si la vista es null, la creamos

            Log.d(TAG, "Creando y buscando vistas");

            convertView = LayoutInflater.from(context).inflate(R.layout.hourly_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.hourlyTitleTextView);
            viewHolder.description = (TextView) convertView.findViewById(R.id.hourlyDescriptionTextView);

            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.title.setText(hour.getTitle());
        viewHolder.description.setText(hour.getWeatherDescription());

        return convertView;
    }

    static class ViewHolder{

        TextView title;
        TextView description;

    }
}
