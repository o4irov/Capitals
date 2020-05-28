package com.example.capitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HowPlay extends AppCompatActivity {

    ImageButton undo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_play);
        undo = findViewById(R.id.undo);

        View.OnClickListener undoOCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent undoIntent = new Intent(HowPlay.this, MainActivity.class);
                startActivity(undoIntent);
            }
        };
        undo.setOnClickListener(undoOCL);
    }
}
