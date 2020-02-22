package com.example.archcult20;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    androidx.constraintlayout.widget.ConstraintLayout mainactivitylayout = findViewById(R.id.mainactivity);

//    private List<Schedule> schedules = ScheduleData.scheduleList;

    public static final String SCH_ID = "SCH_ID";
    int count;

    Dialog popup;
    TextView popupvenue,popupday1,popupday2,popupday3,popupempty;
    View titledivider,day1line1,day1line2,day2line1,day2line2,day3line1,day3line2;
    LinearLayout day1layout,day2layout,day3layout,popupdialog;

    LinearLayout list1;

    ImageView closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent dataintent = new Intent(MainActivity.this,ScheduleData.class);
//        MainActivity.this.startActivity(dataintent);

        Log.d("MainActivity", "This is a test message");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);

        popup = new Dialog(this);

        TextView tv = findViewById(R.id.miragetext);
        tv.setText("mirage");

        Typeface Opificio_light = Typeface.createFromAsset(getAssets(), "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getAssets(), "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getAssets(), "fonts/Opificio_Bold.ttf");
        tv.setTypeface(Opificio_regular);

//        popupvenue = popup.findViewById(R.id.popupvenue);
//        popupvenue.setTypeface(Opificio_bold);
//        popupday1 = popup.findViewById(R.id.popupday1);
//        popupday1.setTypeface(Opificio_light);

        Button scheduleButton = findViewById(R.id.schedulebutton);
        scheduleButton.setTypeface(Opificio_bold);

/*
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

*/
        scheduleButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent menuintent = new Intent(MainActivity.this, ScheduleActivity.class);
                                                  MainActivity.this.startActivity(menuintent);
                                                  overridePendingTransition(R.anim.bottom_up, R.anim.nothing);
                                              }
                                          }
        );

//        String[] items = getResources().getStringArray(R.array.schedule);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
//        ScheduleListAdapter adapter = new ScheduleListAdapter(this,R.layout.schedule_item,schedules);
//        ListView lv = findViewById(R.id.listView);
//        lv.setAdapter(adapter);

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

        TextView floor = findViewById(R.id.floor);
        floor.setTypeface(Opificio_regular);

        TextView location = findViewById(R.id.location);
        location.setTypeface(Opificio_bold);

        View dgf_courtyard = findViewById(R.id.dgf_courtyard);
        dgf_courtyard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"You just clicked Menu", Toast.LENGTH_SHORT).show();
                Snackbar.make(v, "Courtyard", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Dept Courtyard");
//                Intent menuintent = new Intent(MainActivity.this,ScheduleActivity.class);
//                MainActivity.this.startActivity(menuintent);
            }
        });

        View dgf_studio1 = findViewById(R.id.dgf_studio1);
        dgf_studio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Studio1", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Studio 1");
            }
        });

        View dgf_studio2 = findViewById(R.id.dgf_studio2);
        dgf_studio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Studio2", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Studio 2");
            }
        });

        View dgf_studio3 = findViewById(R.id.dgf_studio3);
        dgf_studio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Studio3", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Studio 3");
            }
        });

        View dgf_studio4 = findViewById(R.id.dgf_studio4);
        dgf_studio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Studio4", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Studio 4");
            }
        });

        View dgf_studio5 = findViewById(R.id.dgf_studio5);
        dgf_studio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Studio5", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Studio 5");
            }
        });

        View dgf_complab = findViewById(R.id.dgf_complab);
        dgf_complab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Computer Lab", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Computer Lab");
            }
        });

        View dgf_lobbyf = findViewById(R.id.dgf_lobbyf);
        dgf_lobbyf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Lobby Front", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Lobby");
            }
        });

        View dgf_lobbyb = findViewById(R.id.dgf_lobbyb);
        dgf_lobbyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Lobby Back", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Lobby Back");
            }
        });

        View dgf_stairsb = findViewById(R.id.dgf_stairsb);
        View dgf_stairsm = findViewById(R.id.dgf_stairsm);
        View dgf_stairsf = findViewById(R.id.dgf_stairsf);
        dgf_stairsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Stairs Back", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
        dgf_stairsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Stairs Middle", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
        dgf_stairsf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Stairs Front", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });

        View dgf_gents = findViewById(R.id.dgf_gents);
        View dgf_ladies = findViewById(R.id.dgf_ladies);
        dgf_gents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Gents Toilet", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
        dgf_ladies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Ladies Toilet", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
    }

    public void venuePopUp(String venue) {
        popup.setContentView(R.layout.activity_venue_list);

        Typeface Opificio_light = Typeface.createFromAsset(getAssets(), "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getAssets(), "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getAssets(), "fonts/Opificio_Bold.ttf");
        popupvenue = popup.findViewById(R.id.popupvenue);
        popupvenue.setTypeface(Opificio_bold);
        popupday1 = popup.findViewById(R.id.popupday1);
        popupday1.setTypeface(Opificio_light);

        popupday2 = popup.findViewById(R.id.popupday2);
        popupday2.setTypeface(Opificio_light);

        popupday3 = popup.findViewById(R.id.popupday3);
        popupday3.setTypeface(Opificio_light);

        popupvenue.setText(venue);

        final List<Schedule> schedules1 = ScheduleData.getVenueListDay1(venue);
        VenueListAdapter adapter1 = new VenueListAdapter(this, R.layout.schedule_item2, schedules1);
        ListView lv1 = popup.findViewById(R.id.listView1);
        lv1.setAdapter(adapter1);

        final List<Schedule> schedules2 = ScheduleData.getVenueListDay2(venue);
        VenueListAdapter adapter2 = new VenueListAdapter(this, R.layout.schedule_item2, schedules2);
        ListView lv2 = popup.findViewById(R.id.listView2);
        lv2.setAdapter(adapter2);

        final List<Schedule> schedules3 = ScheduleData.getVenueListDay3(venue);
        VenueListAdapter adapter3 = new VenueListAdapter(this, R.layout.schedule_item2, schedules3);
        ListView lv3 = popup.findViewById(R.id.listView3);
        lv3.setAdapter(adapter3);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                Schedule schedule = schedules1.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                Schedule schedule = schedules2.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
            }
        });
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                Schedule schedule = schedules3.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
            }
        });
/*
        ShapeDrawable sb = (ShapeDrawable) lv1.getBackground();
        sb.getPaint().setColor(color);

        final LayoutInflater factory = getLayoutInflater();
        final View listitemview = factory.inflate(R.layout.schedule_item2, null);
        LinearLayout listitem2bg = (LinearLayout) listitemview.findViewById(R.id.listitem2bg);
        listitem2bg.setBackgroundColor(Color.BLUE);

        //View v;
        for (int i = 0; i < lv1.getChildCount(); i++) {
            //v = lv1.getAdapter().getView(i, null, null);
            lv1.getChildAt(i).setBackgroundColor(Color.BLUE);
        }
*/
        UIUtils.setListViewHeightBasedOnItems(lv1);
        UIUtils.setListViewHeightBasedOnItems(lv2);
        UIUtils.setListViewHeightBasedOnItems(lv3);

        popupempty = popup.findViewById(R.id.popupempty);
        titledivider = popup.findViewById(R.id.titledivider);

        day1layout = popup.findViewById(R.id.day1layout);
        day2layout = popup.findViewById(R.id.day2layout);
        day3layout = popup.findViewById(R.id.day3layout);

        day1line1 = popup.findViewById(R.id.day1line1);
        day1line2 = popup.findViewById(R.id.day1line2);

        day2line1 = popup.findViewById(R.id.day2line1);
        day2line2 = popup.findViewById(R.id.day2line2);

        day3line1 = popup.findViewById(R.id.day3line1);
        day3line2 = popup.findViewById(R.id.day3line2);

        popupempty.setTypeface(Opificio_regular);

        if (schedules1.isEmpty()) {
//            popupday1.setVisibility(View.GONE);
//            day1line1.setVisibility(View.GONE);
//            day1line2.setVisibility(View.GONE);
            lv1.setVisibility(View.GONE);
            day1layout.setVisibility(View.GONE);
        }
        if (schedules2.isEmpty()) {
//            popupday2.setVisibility(View.GONE);
//            day2line1.setVisibility(View.GONE);
//            day2line2.setVisibility(View.GONE);
            lv2.setVisibility(View.GONE);
            day2layout.setVisibility(View.GONE);
        }
        if (schedules3.isEmpty()) {
//            popupday3.setVisibility(View.GONE);
//            day3line1.setVisibility(View.GONE);
//            day3line2.setVisibility(View.GONE);
            lv3.setVisibility(View.GONE);
            day3layout.setVisibility(View.GONE);
        }

        if (schedules1.isEmpty() && schedules2.isEmpty() && schedules3.isEmpty()){
            titledivider.setVisibility(View.VISIBLE);
            popupempty.setVisibility(View.VISIBLE);
        }

        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //popup.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(popup.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        lp.height = (int)(getResources().getDisplayMetrics().heightPixels*0.75);
//        lp.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.8f, getResources().getDisplayMetrics());
        popup.getWindow().setAttributes(lp);

        count = lv1.getAdapter().getCount() + lv2.getAdapter().getCount() + lv3.getAdapter().getCount();

        if(count > 3) {
            lp.height = (int)(getResources().getDisplayMetrics().heightPixels*0.75);
            popup.getWindow().setAttributes(lp);
            count=0;
        }

        popup.setCanceledOnTouchOutside(true);
        popup.setCancelable(true);
        popup.show();

        closeButton = popup.findViewById(R.id.closebutton);
        closeButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               popup.dismiss();
                                           }
                                       }
        );
    }
}
