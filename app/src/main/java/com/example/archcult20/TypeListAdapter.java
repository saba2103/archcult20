package com.example.archcult20;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TypeListAdapter extends ArrayAdapter<Schedule> {

    private List<Schedule> schedules;

    public TypeListAdapter(@NonNull Context context, int resource, @NonNull List<Schedule> objects) {
        super(context, resource, objects);
        schedules = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.schedule_item3,parent,false);
        }

        Typeface Opificio_light = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Opificio_Bold.ttf");

        Schedule schedule = schedules.get(position);

        TextView titleText = convertView.findViewById(R.id.titletext);
        titleText.setText(schedule.getTitle().toLowerCase());

        TextView venueText = convertView.findViewById(R.id.venuetext);
        venueText.setText(schedule.getVenue().toLowerCase());

//        NumberFormat formatter = NumberFormat.getNumberInstance();
//        String getDayText = formatter.format(schedule.getDay());
//        TextView dayText = convertView.findViewById(R.id.daytext);
//        dayText.setText(getDayText);

        TextView timeText = convertView.findViewById(R.id.timetext);
        timeText.setText(schedule.getTime().toLowerCase());

        titleText.setTypeface(Opificio_bold);
        venueText.setTypeface(Opificio_regular);
        timeText.setTypeface(Opificio_bold);

        return convertView;
    }
}
