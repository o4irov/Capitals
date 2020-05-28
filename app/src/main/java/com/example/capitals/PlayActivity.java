package com.example.capitals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    TextView question, quest, tru;
    Button answer1, answer2, answer3, answer4;
    int numberQ, number1, number2, number3;
    Random rand = new Random();
    int points = 0, k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources r = getResources();

        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        quest = findViewById(R.id.quest);
        tru = findViewById(R.id.tru);

        while (k < 10) {
            quest.setText("Вопрос №" + k + "/10");
            tru.setText("Верных: " + points + "/" + k);
            View.OnClickListener trueOCL = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Верный ответ!", Toast.LENGTH_LONG);
                    toast.show();
                    points++;
                    k++;
                }
            };

            View.OnClickListener falseOCL = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ответ не верный(", Toast.LENGTH_LONG);
                    toast.show();
                    k++;
                }
            };


            InputStream question_stream = r.openRawResource(R.raw.question);
            InputStreamReader question_reader = new InputStreamReader(question_stream);
            Gson gson = new Gson();
            ArrayList questions = gson.fromJson(question_reader, ArrayList.class);

            numberQ = rand.nextInt(questions.size());
            question.setText(String.valueOf(questions.get(numberQ)));

            InputStream answer_stream = r.openRawResource(R.raw.question);
            InputStreamReader answer_reader = new InputStreamReader(answer_stream);
            ArrayList answers = gson.fromJson(answer_reader, ArrayList.class);

            number1 = rand.nextInt(answers.size());
            number2 = rand.nextInt(answers.size());
            number3 = rand.nextInt(answers.size());

            ArrayList ans = new ArrayList();
            ans.add(questions.get(numberQ));
            ans.add(questions.get(number1));
            ans.add(questions.get(number2));
            ans.add(questions.get(number3));
            Collections.shuffle(ans);

            answer1.setText(String.valueOf(ans.get(0)));
            answer2.setText(String.valueOf(ans.get(1)));
            answer3.setText(String.valueOf(ans.get(2)));
            answer4.setText(String.valueOf(ans.get(3)));

            switch (ans.indexOf(questions.get(numberQ))) {
                case 0:
                    answer1.setOnClickListener(trueOCL);
                    break;
                case 1:
                    answer2.setOnClickListener(trueOCL);
                    break;
                case 2:
                    answer3.setOnClickListener(trueOCL);
                    break;
                case 3:
                    answer4.setOnClickListener(trueOCL);
                    break;
            }
            switch (ans.indexOf(questions.get(number1 | number2 | number3))) {
                case 0:
                    answer1.setOnClickListener(falseOCL);
                    break;
                case 1:
                    answer2.setOnClickListener(falseOCL);
                    break;
                case 2:
                    answer3.setOnClickListener(falseOCL);
                    break;
                case 3:
                    answer4.setOnClickListener(falseOCL);
                    break;
            }
        }
    }
}