package com.example.capitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Review extends AppCompatActivity {

    EditText review;
    ImageButton send, undo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        review = findViewById(R.id.review);
        send = findViewById(R.id.send);
        undo = findViewById(R.id.undo);

       View.OnClickListener sendOCL = new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast toast = Toast.makeText(getApplicationContext(), "Благодарим за отзыв", Toast.LENGTH_SHORT);
               toast.show();
           }
       };
       send.setOnClickListener(sendOCL);

        View.OnClickListener undoOCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent undoIntent = new Intent(Review.this, MainActivity.class);
                startActivity(undoIntent);
            }
        };
        undo.setOnClickListener(undoOCL);
    }
}
