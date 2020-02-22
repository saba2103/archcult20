package com.example.archcult20;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ScheduleData{
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static List<Schedule> scheduleList1 = new ArrayList<>();
    public static List<Schedule> scheduleList2 = new ArrayList<>();
    public static List<Schedule> scheduleList3 = new ArrayList<>();
    public static Map<String,Schedule> scheduleMap = new HashMap<>();

//    private List<ExcelSample> excelSamples = new ArrayList<>();

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        scheduleList.clear();
//
//        readScheduleData();
//
//        addProduct("Ar. Alok Shetty", "Guest Lecture","Dept Audi",2,"6 PM");
//        addProduct("title2","Workshop", "venue",1,"5 PM");
//        addProduct("title3","Activity", "venue",3,"12 PM");
//        addProduct("title", "Guest Lecture","venue",2,"6 PM");
//
//        this.finish();
//
//    }

    static {
        addProduct("Registration", "","PR Desk",1,"9AM - 1PM");
        addProduct("Art Galore", "Studio 1","Exhibition",1,"9AM - 6PM");
        addProduct("Inauguration", "PR Desk","Department",1,"9:30AM - 11:30AM");
        addProduct("Ar. Kevin Mark Low","Guest Lecture", "EEE Audi",1,"11:30AM - 1:30PM");
        addProduct("Ar. Pankaj Modi","Guest Lecture", "Malai Kovil",1,"1:30PM - 5:30PM");
        addProduct("Courtyard Events","Informal Event", "Dept Courtyard",1,"2PM - 4PM");
        addProduct("Comic Strip Design","Informal Event", "Studio 3",1,"2PM - 3:30PM");
        addProduct("Formal1","Formal Event", "Lecture Hall 1",1,"2PM - 4PM");
        addProduct("Lime Plaster","Workshop", "Exhibition Room - SF",1,"2:30PM - 5:30PM");
        addProduct("Inside the Box","Workshop", "Lecture Hall 2",1,"2:30PM - 5:30PM");
        addProduct("Bamboo Construction","Workshop", "MIG Plaza",1,"2:30PM - 6PM");
        addProduct("Catch The Angle","Informal Event", "FF Lobby",1,"3PM - 4:30PM");
        addProduct("Ar. Kevin Mark Low","Archcult Tea", "Review Room",1,"3:30PM - 5PM");
        addProduct("Matchsticks", "Formal Event","Studio 3",1,"3:30PM - 5:30PM");
        addProduct("Lil' Bit Of Drama","Formal Event", "Dept Courtyard",1,"4PM - 6PM");
        addProduct("Formal2","Formal Event", "Lecture Hall1",1,"4PM - 6PM");
        addProduct("Karaoke Night","Culturals", "Dept Courtyard",1,"6PM - 9PM");

        addProduct("Art Galore", "Studio 1","Exhibition",2,"9AM - 6PM");
        addProduct("Ar. Samuel Barclay","Guest Lecture", "EEE Audi",2,"10:30AM - 12PM");
        addProduct("Bamboo Construction","Workshop", "MIG Plaza",2,"10:30AM - 1:30PM");
        addProduct("Ar. Sanjay Patil","Guest Lecture", "EEE Audi",2,"12PM - 1:30PM");
        addProduct("Paperazzi","Formal Event", "Dept Audi",2,"2PM - 4PM");
        addProduct("Red Oxide","Workshop", "Studio 5 - SF",2,"2PM - 5:30PM");
        addProduct("Informal10","Informal Event", "Studio 3",2,"2:30PM - 4PM");
        addProduct("Picasso","Informal Event", "Lecture Hall 1",2,"2:30PM - 4PM");
        addProduct("Lime Plaster","Workshop", "Exhibition Room - SF",2,"2:30PM - 5:30PM");
        addProduct("Inside The Box","Workshop", "Lecture Hall 2",2,"2:30PM - 5:30PM");
        addProduct("Bamboo Construction","Workshop", "MIG Plaza",2,"2:30PM - 6PM");
        addProduct("Ar. Samuel Barclay","Archcult Tea", "Review Room",2,"3PM - 4:30PM");
        addProduct("Beg, Borrow, Steal", "Informal Event","Studio 3",2,"4PM - 5:30PM");
        addProduct("Photo Session","Informal Event", "Courtyard",2,"4PM - 6PM");
        addProduct("Gyatva Presentation","Formal Event", "Studio 3",2,"4PM - 6PM");
        addProduct("Sell Your Idea","Formal Event", "Lecture Hall 1",2,"4PM - 6PM");
        addProduct("Ar. Sanjay Patil","Archcult Tea", "Review Room",2,"4:30PM - 6PM");
        addProduct("Tug Of War","Informal Event", "Outside Dept",2,"5PM - 6PM");
        addProduct("Choreo Night","Culturals", "Dept Courtyard",2,"6PM - 9PM");

        addProduct("Art Galore", "Studio 1","Exhibition",3,"9AM - 6PM");
        addProduct("Ar. Dean D'Cruz","Guest Lecture", "EEE Audi",3,"10:30AM - 12PM");
        addProduct("Ar. Trupti Doshi","Guest Lecture", "EEE Audi",3,"12PM - 1:30PM");
        addProduct("Sherlocked","Informal Event", "Lobby FF",3,"2PM - 3:30PM");
        addProduct("Formal5","Formal Event", "Lecture Hall 1",3,"2PM - 4PM");
        addProduct("Taking Ideas Forward","Workshop", "Studio 5 - SF",3,"2PM - 5:30PM");
        addProduct("Salsa","Workshop", "Studio 3",3,"2:30PM - 5:30PM");
        addProduct("Inside The Box","Workshop", "Exhibition Room - SF",3,"2:30PM - 5:30PM");
        addProduct("Bamboo Construction","Workshop", "MIG Plaza",3,"2:30PM - 5:30PM");
        addProduct("Mr. & Ms. Archcult","Informal Event", "Dept Courtyard",3,"2:30PM - 6PM");
        addProduct("Ar. Trupti Doshi","Archcult Tea", "Review Room",3,"3PM - 4:30PM");
        addProduct("Spotlight", "Informal Event","Lobby FF",3,"3:30PM - 5:30PM");
        addProduct("Formal6","Formal Event", "Lecture Hall 1",3,"4PM - 6PM");
        addProduct("Valediction Ceremony","", "Dept Courtyard",3,"6PM - 9PM");
    }

    private static void addProduct(String title, String type, String venue, int day, String time) {
        Schedule item = new Schedule(title, type, venue, day, time);
        scheduleList.add(item);
        if(day==1){scheduleList1.add(item);}
        if(day==2){scheduleList2.add(item);}
        if(day==3){scheduleList3.add(item);}

        scheduleMap.put(title, item);
    }

    public static List<Schedule> getCategoryListDay1(String typeString) {
        List<Schedule> typeList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getType().contains(typeString) && schedule.getDay() == 1 ) {
                typeList.add(schedule);
            }
        }
        return typeList;
    }
    public static List<Schedule> getCategoryListDay2(String typeString) {
        List<Schedule> typeList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getType().contains(typeString) && schedule.getDay() == 2 ) {
                typeList.add(schedule);
            }
        }
        return typeList;
    }
    public static List<Schedule> getCategoryListDay3(String typeString) {
        List<Schedule> typeList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getType().contains(typeString) && schedule.getDay() == 3 ) {
                typeList.add(schedule);
            }
        }
        return typeList;
    }

    public static List<Schedule> getVenueListDay1(String venueString) {
        List<Schedule> venueList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getVenue().contains(venueString) && schedule.getDay() == 1 ) {
                venueList.add(schedule);
            }
        }
        return venueList;
    }
    public static List<Schedule> getVenueListDay2(String venueString) {
        List<Schedule> venueList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getVenue().contains(venueString) && schedule.getDay() == 2 ) {
                venueList.add(schedule);
            }
        }
        return venueList;
    }
    public static List<Schedule> getVenueListDay3(String venueString) {
        List<Schedule> venueList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getVenue().contains(venueString) && schedule.getDay() == 3 ) {
                venueList.add(schedule);
            }
        }
        return venueList;
    }


//    private void readScheduleData(){
//
//        InputStream is = getResources().openRawResource(R.raw.data);
//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(is, Charset.forName("UTF-8"))
//        );
//
//        String line = "";
//        try {
//            while ((line = reader.readLine()) != null) {
//                Log.d("ExcelData", "Line: " + line);
//                //split by ','
//                String[] tokens = line.split(",");
//
//                //read the data
////                ExcelSample sample = new ExcelSample();
////                sample.setTitle(tokens[0]);
////                sample.setType(tokens[1]);
////                sample.setVenue(tokens[2]);
////                sample.setTime(tokens[3]);
////                excelSamples.add(sample);
//
////                if (tokens[1].length()>0){
////                    sample.setDay(Integer.parseInt(tokens[1]));
////                } else {
////                    sample.setDay(0);
////                }
//
//                addProduct(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4]);
////                addProduct(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4]);
////                addProduct(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4]);
//
//                Log.d("ExcelData", "Just Created: ");
//            }
//        } catch (IOException e) {
//            Log.wtf("ExcelData","Error reading data file on line " + line, e);
//            e.printStackTrace();
//        }
//
//    }

}
