package com.example.archcult20;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main_menu);

        Typeface Opificio_light = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_light.ttf");
        Typeface Opificio_regular = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_regular.ttf");
        Typeface Opificio_bold = Typeface.createFromAsset(getAssets(),  "fonts/Opificio_Bold.ttf");

        TextView stallstext = findViewById(R.id.stallstext);
        TextView gltext = findViewById(R.id.gltext);
        TextView wstext = findViewById(R.id.wstext);
        TextView comptext = findViewById(R.id.comptext);
        TextView eventstext = findViewById(R.id.eventstext);

        stallstext.setTypeface(Opificio_bold);
        gltext.setTypeface(Opificio_bold);
        wstext.setTypeface(Opificio_bold);
        comptext.setTypeface(Opificio_bold);
        eventstext.setTypeface(Opificio_bold);

        ImageView closebutton = findViewById(R.id.closebutton);
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.this.finish();
            }
        });

        stallstext.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent menuintent = new Intent(MainMenu.this,ScheduleActivity.class);
                                              MainMenu.this.startActivity(menuintent);
                                          }
                                      }
        );
    }
}
