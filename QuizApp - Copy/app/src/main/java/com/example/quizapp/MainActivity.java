package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button newQuizButton;
    RecyclerView recyclerView;
    List<Model> quizList;// {"Animal Quiz", "A world of food", "laugh and laugh"}; // Example quiz titles

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listView);

        quizList = new ArrayList<>();
        // Add your quizzes here
        quizList.add(new Model("Animal Quiz", R.drawable.animal, 1));
        quizList.add(new Model("A world of Food", R.drawable.food, 2));
        quizList.add(new Model("laugh and laugh", R.drawable.funny, 3));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(quizList, this);
        recyclerView.setAdapter(adapter);

        newQuizButton = findViewById(R.id.newQuizButton);
        newQuizButton.setOnClickListener(v -> startNewQuiz());
    }

    private void startQuiz(int quizId, String quizTitle) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("QUIZ_ID", quizId);
        intent.putExtra("QUIZ_TITLE", quizTitle);
        startActivity(intent);
    }

    private void startNewQuiz() {
        Random random = new Random();
        int randomIndex = random.nextInt(quizList.size());
        Model selectedQuiz = quizList.get(randomIndex);
        startQuiz(selectedQuiz.getId(), selectedQuiz.getTitle());
    }

}
