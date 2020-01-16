package com.example.archcult20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ScheduleData {
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static Map<String,Schedule> scheduleMap = new HashMap<>();

    static {
        addProduct("Ar. Alok Shetty", "Guest Lecture","Dept Audi",2,"6 PM");
        addProduct("title2","Workshop", "venue",1,"5 PM");
        addProduct("title3","Activity", "venue",3,"12 PM");
        addProduct("title", "Guest Lecture","venue",2,"6 PM");
        addProduct("title2","Workshop", "venue",1,"5 PM");
        addProduct("title3","Activity", "venue",3,"12 PM");
        addProduct("title", "Guest Lecture","venue",2,"6 PM");
        addProduct("title2","Workshop", "venue",1,"5 PM");
        addProduct("title3","Activity", "venue",3,"12 PM");
    }

    private static void addProduct(String title, String type, String venue, int i, String s) {
        Schedule item = new Schedule(title, type, venue,i,s);
        scheduleList.add(item);
        scheduleMap.put(title, item);
    }
}
