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

public class VenueListAdapter extends ArrayAdapter<Schedule> {

    private List<Schedule> schedules;

    public VenueListAdapter(@NonNull Context context, int resource, @NonNull List<Schedule> objects) {
        super(context, resource, objects);
        schedules = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.schedule_item2,parent,false);
        }

        Typeface Opificio_light = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Opificio_Bold.ttf");

        Schedule schedule = schedules.get(position);

        TextView titleText = convertView.findViewById(R.id.titletext);
        titleText.setText(schedule.getTitle().toLowerCase());

        TextView typeText = convertView.findViewById(R.id.typetext);
        typeText.setText(schedule.getType().toLowerCase());

//        NumberFormat formatter = NumberFormat.getNumberInstance();
//        String getDayText = formatter.format(schedule.getDay());
//        TextView dayText = convertView.findViewById(R.id.daytext);
//        dayText.setText(getDayText);

        TextView timeText = convertView.findViewById(R.id.timetext);
        timeText.setText(schedule.getTime().toLowerCase());

        titleText.setTypeface(Opificio_bold);
        typeText.setTypeface(Opificio_light);
        timeText.setTypeface(Opificio_bold);

        return convertView;
    }
}
