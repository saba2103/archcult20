package com.example.archcult20;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.Timer;

public class ScheduleActivity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    LinearLayout sliderDotspanel;
    private int dotsCount;
    private ImageView[] dots;

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

        pager = findViewById(R.id.pager);
        pagerAdapter = new SchedulePagerAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);

        sliderDotspanel = findViewById(R.id.sliderDots);
        dotsCount = pagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i=0; i<dotsCount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0; i<dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
