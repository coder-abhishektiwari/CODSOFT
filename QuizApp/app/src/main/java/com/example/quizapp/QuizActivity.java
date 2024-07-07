package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private int quizIndex;
    private int currentQuestionIndex = 0, score = 0, totalQuestions;
    private int[] userAnswers;

    private TextView questionTextView, quizTitleText, liveScore;
    private String quizTitle;
    private int quizId;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton, preButton, buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizTitleText = findViewById(R.id.quizTitleWindow);
        liveScore = findViewById(R.id.liveScore);
        questionTextView = findViewById(R.id.questionTextView);
        optionsGroup = findViewById(R.id.optionsGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);
        preButton = findViewById(R.id.previousButton);
        buttonHome = findViewById(R.id.buttonHome);

        Intent intent = getIntent();
        quizId = intent.getIntExtra("QUIZ_ID", -1);
        quizTitle = intent.getStringExtra("QUIZ_TITLE");
        quizTitleText.setText(quizTitle);

        loadQuizData(quizId);

        totalQuestions = QuizData.questions[quizIndex].length;
        userAnswers = new int[totalQuestions];
        // Initialize userAnswers array with -1 to indicate unanswered questions
        resetQuiz();

        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                currentQuestionIndex++;
                preButton.setVisibility(View.VISIBLE);
                if (currentQuestionIndex < totalQuestions) {
                    loadQuestion();
                } else {
                    showResults();
                }
            }
        });

        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    loadQuestion();
                } else if (currentQuestionIndex == 0) {
                    preButton.setVisibility(View.INVISIBLE);
                    Toast.makeText(QuizActivity.this, "You have reached the first question", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        optionsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lockOptions();
            }
        });

        // Live score update
        updateScore();
    }

    private void loadQuizData(int quizId) {
        switch (quizId) {
            case 1:
                quizIndex = 0;  // Assuming 0 index for Quiz 1 in QuizData
                break;
            case 2:
                quizIndex = 1;  // Assuming 1 index for Quiz 2 in QuizData
                break;
            case 3:
                quizIndex = 2;  // Assuming 2 index for Quiz 3 in QuizData
                break;
            default:
                quizIndex = 0;  // Default to first quiz if no valid quizId is provided
                break;
        }
    }

    private void loadQuestion() {
        questionTextView.setText(QuizData.questions[quizIndex][currentQuestionIndex][0]);
        option1.setText(QuizData.questions[quizIndex][currentQuestionIndex][1]);
        option2.setText(QuizData.questions[quizIndex][currentQuestionIndex][2]);
        option3.setText(QuizData.questions[quizIndex][currentQuestionIndex][3]);
        option4.setText(QuizData.questions[quizIndex][currentQuestionIndex][4]);
        optionsGroup.clearCheck();
        enableOptions();

        // Check if the question was already answered
        if (userAnswers[currentQuestionIndex] != -1) {
            // Set the checked option
            ((RadioButton) optionsGroup.getChildAt(userAnswers[currentQuestionIndex])).setChecked(true);
            // Lock the options
            lockOptions();
        }
    }

    private void checkAnswer() {
        int selectedOption = optionsGroup.indexOfChild(findViewById(optionsGroup.getCheckedRadioButtonId()));
        userAnswers[currentQuestionIndex] = selectedOption;
        if (selectedOption == QuizData.correctAnswers[quizIndex][currentQuestionIndex]) {
            Toast.makeText(this, "Yeh! Correct Answer", Toast.LENGTH_SHORT).show();
            score++;
            updateScore();
        }else{
            Toast.makeText(this, "Oh no! Incorrect Answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void showResults() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL_QUESTIONS", totalQuestions);
        intent.putExtra("CORRECT_ANSWERS", QuizData.correctAnswers[quizIndex]);
        intent.putExtra("USER_ANSWERS", userAnswers);
        startActivity(intent);
        finish();
    }

    private void updateScore() {
        liveScore.setText(getString(R.string.score) + " " + score + "/" + totalQuestions);
    }

    private void lockOptions() {
        for (int i = 0; i < optionsGroup.getChildCount(); i++) {
            optionsGroup.getChildAt(i).setEnabled(false);
        }
    }

    private void enableOptions() {
        for (int i = 0; i < optionsGroup.getChildCount(); i++) {
            optionsGroup.getChildAt(i).setEnabled(true);
        }
    }

    private void resetQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        for (int i = 0; i < totalQuestions; i++) {
            userAnswers[i] = -1;
        }
        enableOptions();
    }
}
