package com.example.archcult20;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextList extends AppCompatActivity {

    TextView output;
    public static final String FILE_NAME = "ac20schedule.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textlist);

        output = findViewById(R.id.outputText);
        output.setText("Ready to code!");
    }

    public void onCreateButtonClick(View view) {
        String string = "rtext";

        FileOutputStream fileOutputStream = null;
        File file = new File(FILE_NAME);

        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(string.getBytes());
            Toast.makeText(this, "File Written: " + FILE_NAME, Toast.LENGTH_SHORT).show();
        } catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "File Written: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try{
                fileOutputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void onReadButtonClick(View view){
        File file = new File(getFilesDir(), FILE_NAME);
        if(file.exists()){

            Toast.makeText(this, "File Read", Toast.LENGTH_SHORT).show();
        }
    }

    public void onDeleteButtonClick(View view){
        File file = new File(getFilesDir(), FILE_NAME);
        if(file.exists()){
            deleteFile(FILE_NAME);
            Toast.makeText(this, "File Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}
