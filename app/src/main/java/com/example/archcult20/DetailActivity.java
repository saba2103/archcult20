package com.example.archcult20;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.archcult20.Fragments.ScheduleDay1;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class DetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        String scheduleTitle = getIntent().getStringExtra(ScheduleDay1.SCH_ID);
        final Schedule schedule = ScheduleData.scheduleMap.get(scheduleTitle);

        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.this.finish();
            }
        });

        Typeface Opificio_light = Typeface.createFromAsset(this.getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(this.getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(this.getAssets(),  "fonts/Opificio_Bold.ttf");

        //Schedule schedule = schedules.get(position);

        Bitmap bm = null;
        try {
            bm = getBitmapFromAsset("GL3.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //BitmapDrawable ob = new BitmapDrawable(getResources(), bm);
        //RelativeLayout imagelayout = findViewById(R.id.imagelayout);
        ImageView iv = findViewById(R.id.imageview);
        iv.setImageBitmap(bm);
        //iv.setColorFilter(Color.argb(100, 255, 255, 255));

        TextView titleText = findViewById(R.id.titletext);
        titleText.setText(schedule.getTitle().toLowerCase());

        TextView typeText = findViewById(R.id.typetext);
        typeText.setText(schedule.getType().toLowerCase());

        TextView venue = findViewById(R.id.venue);
        venue.setAllCaps(false);
        TextView venueText = findViewById(R.id.venuetext);
        venueText.setText(schedule.getVenue().toLowerCase());

        TextView time = findViewById(R.id.time);
        time.setAllCaps(false);
        TextView timeText = findViewById(R.id.timetext);
        timeText.setText(schedule.getTime().toLowerCase());

        TextView day = findViewById(R.id.day);
        day.setAllCaps(false);
        NumberFormat formatter = NumberFormat.getNumberInstance();
        String getDayText = formatter.format(schedule.getDay());
        TextView dayText = findViewById(R.id.daytext);
        dayText.setText(getDayText.toLowerCase());

        TextView description = findViewById(R.id.description);
        description.setAllCaps(false);

        Button registerButton = findViewById(R.id.registerbutton);

        if(schedule.getType().toLowerCase().contains("informal event")
                || schedule.getType().toLowerCase().contains("formal event")){
            registerButton.setVisibility(View.VISIBLE);
        } else {
            registerButton.setVisibility(View.GONE);
        }

        titleText.setTypeface(Opificio_bold);
        typeText.setTypeface(Opificio_regular);
        venue.setTypeface(Opificio_light);
        venueText.setTypeface(Opificio_bold);
        time.setTypeface(Opificio_light);
        timeText.setTypeface(Opificio_bold);
        day.setTypeface(Opificio_light);
        dayText.setTypeface(Opificio_bold);
        description.setTypeface(Opificio_regular);

        registerButton.setTypeface(Opificio_bold);
    }

    private Bitmap getBitmapFromAsset(String strName) throws IOException
    {
        AssetManager assetManager = getAssets();
        InputStream istr = assetManager.open(strName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }
}
