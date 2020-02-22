package com.example.archcult20;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SortedSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorted_schedule);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SortedSchedule.this.finish();
            }
        });

        Typeface Opificio_light = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_Bold.ttf");

        TextView layouttitle = findViewById(R.id.layouttitle);
        layouttitle.setTypeface(Opificio_bold);

        TextView popupday1 = findViewById(R.id.popupday1);
        popupday1.setTypeface(Opificio_light);
        TextView popupday2 = findViewById(R.id.popupday2);
        popupday2.setTypeface(Opificio_light);
        TextView popupday3 = findViewById(R.id.popupday3);
        popupday3.setTypeface(Opificio_light);

        String scheduleType = getIntent().getStringExtra(MainActivity.SCH_TYPE_ID);
        List<Schedule> typelistday1 = ScheduleData.getCategoryListDay1(scheduleType);
        List<Schedule> typelistday2 = ScheduleData.getCategoryListDay2(scheduleType);
        List<Schedule> typelistday3 = ScheduleData.getCategoryListDay3(scheduleType);

        layouttitle.setText(scheduleType.toLowerCase() + "s");

        TypeListAdapter adapterday1 = new TypeListAdapter(this, R.layout.schedule_item3, typelistday1);
        TypeListAdapter adapterday2 = new TypeListAdapter(this, R.layout.schedule_item3, typelistday3);
        TypeListAdapter adapterday3 = new TypeListAdapter(this, R.layout.schedule_item3, typelistday2);
        ListView lv1 = findViewById(R.id.listView1);
        ListView lv2 = findViewById(R.id.listView2);
        ListView lv3 = findViewById(R.id.listView3);
        lv1.setAdapter(adapterday1);
        lv2.setAdapter(adapterday2);
        lv3.setAdapter(adapterday3);

        UIUtils.setListViewHeightBasedOnItems(lv1);
        UIUtils.setListViewHeightBasedOnItems(lv2);
        UIUtils.setListViewHeightBasedOnItems(lv3);
    }
}
