package com.example.archcult20.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.archcult20.R;
import com.example.archcult20.Schedule;
import com.example.archcult20.ScheduleData;
import com.example.archcult20.ScheduleListAdapter;

import java.util.List;

public class ScheduleDay1 extends Fragment {

    private List<Schedule> schedules = ScheduleData.scheduleList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.schedule_day1, container, false);

        View v = inflater.inflate(R.layout.schedule_day1, container, false);

        ScheduleListAdapter adapter = new ScheduleListAdapter(this.getActivity(),R.layout.schedule_item,schedules);
        ListView lv = v.findViewById(R.id.listView);
        lv.setAdapter(adapter);

        return rootView;
    }
}
