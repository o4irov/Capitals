package com.example.capitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newGame, review, howPlay;
    // test comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame = findViewById(R.id.newGame);
        review = findViewById(R.id.review);
        howPlay = findViewById(R.id.howPlay);


        View.OnClickListener singleOCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.newGame:
                        Intent singleI = new Intent(MainActivity.this, PlayActivity.class);
                        startActivity(singleI); break;
                    case R.id.review:
                        Intent review = new Intent(MainActivity.this, Review.class);
                        startActivity(review); break;
                    case R.id.howPlay:
                        Intent howToPlay = new Intent(MainActivity.this, HowPlay.class);
                        startActivity(howToPlay); break;
                }
            }
        };
        newGame.setOnClickListener(singleOCL);
        review.setOnClickListener(singleOCL);
        howPlay.setOnClickListener(singleOCL);
    }
}