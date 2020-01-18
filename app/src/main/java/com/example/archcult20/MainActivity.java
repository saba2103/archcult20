package com.example.archcult20;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //androidx.constraintlayout.widget.ConstraintLayout mainactivitylayout = findViewById(R.id.mainactivity);

    private List<Schedule> schedules = ScheduleData.scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.miragetext);
        tv.setText("M   I   R   A   G   E");

        Typeface Opificio_light = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_Bold.ttf");
        tv.setTypeface(Opificio_regular);

        Button scheduleButton = findViewById(R.id.schedulebutton);
        scheduleButton.setTypeface(Opificio_bold);

        Button menuButton = findViewById(R.id.menubutton);
        menuButton.setTypeface(Opificio_bold);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"You just clicked Menu", Toast.LENGTH_SHORT).show();
                //Snackbar.make(view, "You just clicked Menu", Snackbar.LENGTH_SHORT).setAction("Action",null).show();

                Intent menuintent = new Intent(MainActivity.this,MainMenu.class);
                MainActivity.this.startActivity(menuintent);
            }
        });

        String[] items = getResources().getStringArray(R.array.schedule);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        ScheduleListAdapter adapter = new ScheduleListAdapter(this,R.layout.schedule_item,schedules);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);

//        TextView titleText = findViewById(R.id.titletext);
//        TextView typeText = findViewById(R.id.typetext);
//        TextView venueText = findViewById(R.id.venuetext);
//        TextView timeText = findViewById(R.id.timetext);
//        titleText.setTypeface(Opificio_bold);
//        typeText.setTypeface(Opificio_light);
//        venueText.setTypeface(Opificio_regular);
//        timeText.setTypeface(Opificio_regular);


//        NumberFormat formatter = NumberFormat.getNumberInstance();
//        String getDayText = formatter.format(schedule.getDay());
//        TextView dayText = convertView.findViewById(R.id.daytext);
//        dayText.setText(getDayText);


    }
}
