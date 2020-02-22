package com.example.archcult20.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.archcult20.DetailActivity;
import com.example.archcult20.R;
import com.example.archcult20.Schedule;
import com.example.archcult20.ScheduleActivity;
import com.example.archcult20.ScheduleData;
import com.example.archcult20.ScheduleListAdapter;

import java.util.List;

public class ScheduleDay3 extends Fragment {

    private List<Schedule> schedules = ScheduleData.scheduleList3;
    public static final String SCH_ID = "SCH_ID";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.schedule_day3, container, false);

        ScheduleListAdapter adapter = new ScheduleListAdapter(getActivity(),R.layout.schedule_item,schedules);
        ListView lv = rootView.findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Schedule schedule = schedules.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
                //Toast.makeText(getActivity(),"Clicked item " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
