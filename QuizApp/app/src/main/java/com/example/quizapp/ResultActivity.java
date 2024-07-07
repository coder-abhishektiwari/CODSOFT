package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView scoreTextView;
    ListView resultList;
    Button btnHome;

    ArrayList<String> resultDetails;
    int[] correctAnswers;
    int[] userAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = findViewById(R.id.scoreTextView);
        resultList = findViewById(R.id.resultList);
        btnHome = findViewById(R.id.btnHome);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);
        int totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0);
        correctAnswers = intent.getIntArrayExtra("CORRECT_ANSWERS");
        userAnswers = intent.getIntArrayExtra("USER_ANSWERS");

        scoreTextView.setText(getString(R.string.score) + score + "/" + totalQuestions);

        resultDetails = new ArrayList<>();
        for (int i = 0; i < totalQuestions; i++) {
            String result = getString(R.string.question) + (i + 1) + ": ";
            if (userAnswers[i] == correctAnswers[i]) {
                result += getString(R.string.correct);
            } else {
                result += getString(R.string.incorrect_correct_answer_option) + (correctAnswers[i] + 1) + ")";
            }
            resultDetails.add(result);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.resultlist_textview, R.id.text, resultDetails);
        resultList.setAdapter(adapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
