/*
package com.example.archcult20;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ExcelData extends AppCompatActivity {

    private List<ExcelSample> excelSamples = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exceldata);

        readScheduleData();

        ListAdapter adapter = new ListAdapter(this, R.layout.schedule_item, excelSamples);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);
        Log.d("List", "Created successfully");
    }

    private void readScheduleData(){
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                Log.d("ExcelData", "Line: " + line);
                //split by ','
                String[] tokens = line.split(",");

                //read the data
                ExcelSample sample = new ExcelSample();
                sample.setTitle(tokens[0]);
                sample.setType(tokens[1]);
                sample.setVenue(tokens[2]);
                sample.setTime(tokens[3]);
                excelSamples.add(sample);

//                if (tokens[1].length()>0){
//                    sample.setDay(Integer.parseInt(tokens[1]));
//                } else {
//                    sample.setDay(0);
//                }

                Log.d("ExcelData", "Just Created: " + sample);
            }
        } catch (IOException e) {
            Log.wtf("ExcelData","Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }
}
 */
