package com.example.archcult20;

public class Schedule {
    private String title;
    private String type;
    private String venue;
    private int day;
    private String time;

    public String getTitle(){
        return title;
    }
    public String getType(){
        return type;
    }
    public String getVenue(){
        return venue;
    }
    public int getDay(){
        return day;
    }
    public String getTime(){
        return time;
    }

    public Schedule(String title, String type, String venue, int day, String time){
        this.title = title;
        this.type = type;
        this.venue = venue;
        this.day = day;
        this.time = time;
    }
}
