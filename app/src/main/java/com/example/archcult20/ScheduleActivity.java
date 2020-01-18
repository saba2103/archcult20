package com.example.archcult20;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.archcult20.Fragments.ScheduleDay1;
import com.example.archcult20.Fragments.ScheduleDay2;
import com.example.archcult20.Fragments.ScheduleDay3;
import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

//    LinearLayout sliderDotspanel;
//    private int dotsCount;
//    private ImageView[] dots;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        List<Fragment> list = new ArrayList<>();
        list.add(new ScheduleDay1());
        list.add(new ScheduleDay2());
        list.add(new ScheduleDay3());

        ViewPager pager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new SchedulePagerAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);

//        sliderDotspanel = findViewById(R.id.sliderDots);
//        dotsCount = pagerAdapter.getCount();
//        dots = new ImageView[dotsCount];

        final int daysCount = pagerAdapter.getCount();

        final Button[] daysbutton = new Button[pagerAdapter.getCount()];
        daysbutton[0] = findViewById(R.id.day1button);
        daysbutton[1] = findViewById(R.id.day2button);
        daysbutton[2] = findViewById(R.id.day3button);

        Typeface Opificio_light = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_Bold.ttf");

        for(int i=0; i<daysCount; i++){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                daysbutton[i].setBackground(ContextCompat.getDrawable(getBaseContext(), R.drawable.nonactive_button));
            }
            daysbutton[i].setTypeface(Opificio_bold);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            daysbutton[0].setBackground(ContextCompat.getDrawable(getBaseContext(), R.drawable.active_button));
        }

//        for(int i=0; i<dotsCount; i++){
//            dots[i] = new ImageView(this);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.setMargins(8, 0, 8, 0);
//            sliderDotspanel.addView(dots[i], params);
//        }

        //dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*
                for(int i=0; i<dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
                */

                for(int i=0; i<daysCount; i++){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        daysbutton[i].setBackground(ContextCompat.getDrawable(getBaseContext(), R.drawable.nonactive_button));
                    }
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    daysbutton[position].setBackground(ContextCompat.getDrawable(getBaseContext(), R.drawable.active_button));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
