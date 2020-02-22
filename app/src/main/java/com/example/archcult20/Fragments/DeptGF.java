package com.example.archcult20.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.archcult20.DetailActivity;
import com.example.archcult20.R;
import com.example.archcult20.Schedule;
import com.example.archcult20.ScheduleData;
import com.example.archcult20.UIUtils;
import com.example.archcult20.VenueListAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class DeptGF extends Fragment {

    public static final String SCH_ID = "SCH_ID";
    int count;

    Dialog popup;
    TextView popupvenue,popupday1,popupday2,popupday3,popupempty;
    View titledivider,day1line1,day1line2,day2line1,day2line2,day3line1,day3line2;
    LinearLayout day1layout,day2layout,day3layout,popupdialog;

    LinearLayout list1;

    ImageView closeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.map_dept_gf, container, false);

        popup = new Dialog(getContext());

        View dgf_courtyard = rootView.findViewById(R.id.dgf_courtyard);
        dgf_courtyard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"You just clicked Menu", Toast.LENGTH_SHORT).show();
//                Snackbar.make(v, "Courtyard", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                venuePopUp("Dept Courtyard");
//                Intent menuintent = new Intent(MainActivity.this,ScheduleActivity.class);
//                MainActivity.this.startActivity(menuintent);
            }
        });

        View dgf_studio1 = rootView.findViewById(R.id.dgf_studio1);
        dgf_studio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Studio 1");
            }
        });

        View dgf_studio2 = rootView.findViewById(R.id.dgf_studio2);
        dgf_studio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Studio 2");
            }
        });

        View dgf_studio3 = rootView.findViewById(R.id.dgf_studio3);
        dgf_studio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Studio 3");
            }
        });

        View dgf_studio4 = rootView.findViewById(R.id.dgf_studio4);
        dgf_studio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Studio 4");
            }
        });

        View dgf_studio5 = rootView.findViewById(R.id.dgf_studio5);
        dgf_studio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Studio 5");
            }
        });

        View dgf_complab = rootView.findViewById(R.id.dgf_complab);
        dgf_complab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Computer Lab");
            }
        });

        View dgf_lobbyf = rootView.findViewById(R.id.dgf_lobbyf);
        dgf_lobbyf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Lobby");
            }
        });

        View dgf_lobbyb = rootView.findViewById(R.id.dgf_lobbyb);
        dgf_lobbyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venuePopUp("Lobby Back");
            }
        });

        View dgf_stairsb = rootView.findViewById(R.id.dgf_stairsb);
        View dgf_stairsm = rootView.findViewById(R.id.dgf_stairsm);
        View dgf_stairsf = rootView.findViewById(R.id.dgf_stairsf);
        dgf_stairsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        dgf_stairsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        dgf_stairsf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        View dgf_gents = rootView.findViewById(R.id.dgf_gents);
        View dgf_ladies = rootView.findViewById(R.id.dgf_ladies);
        dgf_gents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        dgf_ladies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return rootView;
    }

    public void venuePopUp(String venue) {
        popup.setContentView(R.layout.activity_venue_list);

        Typeface Opificio_light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Opificio_Bold.ttf");
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
        VenueListAdapter adapter1 = new VenueListAdapter(getContext(), R.layout.schedule_item2, schedules1);
        ListView lv1 = popup.findViewById(R.id.listView1);
        lv1.setAdapter(adapter1);

        final List<Schedule> schedules2 = ScheduleData.getVenueListDay2(venue);
        VenueListAdapter adapter2 = new VenueListAdapter(getContext(), R.layout.schedule_item2, schedules2);
        ListView lv2 = popup.findViewById(R.id.listView2);
        lv2.setAdapter(adapter2);

        final List<Schedule> schedules3 = ScheduleData.getVenueListDay3(venue);
        VenueListAdapter adapter3 = new VenueListAdapter(getContext(), R.layout.schedule_item2, schedules3);
        ListView lv3 = popup.findViewById(R.id.listView3);
        lv3.setAdapter(adapter3);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Schedule schedule = schedules1.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Schedule schedule = schedules2.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
            }
        });
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Schedule schedule = schedules3.get(position);
                intent.putExtra(SCH_ID, schedule.getTitle());
                startActivity(intent);
            }
        });

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
            lv1.setVisibility(View.GONE);
            day1layout.setVisibility(View.GONE);
        }
        if (schedules2.isEmpty()) {
            lv2.setVisibility(View.GONE);
            day2layout.setVisibility(View.GONE);
        }
        if (schedules3.isEmpty()) {
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