package com.nourhan.qwizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score;
    private EditText Q1EditText;
    private RadioButton Q2Java, Q4Kotlin;
    private CheckBox Q3Swift, Q3Objective, Q3Java, Q3Prolog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIDs();

    }

    private void setIDs() {

        Q1EditText = findViewById(R.id.Q1ET);
        //-------------------------------------------
        Q2Java = findViewById(R.id.Q2JavaRB);
        //-------------------------------------------
        Q3Swift = findViewById(R.id.Q3SwiftCHK);
        Q3Objective = findViewById(R.id.Q3ObjectiveCHk);
        Q3Java = findViewById(R.id.Q3JavaCHK);
        Q3Prolog = findViewById(R.id.Q3PrologCHK);
        //-------------------------------------------
        Q4Kotlin = findViewById(R.id.Q4KotlinRB);
        //-------------------------------------------

    }


    private void checkQ1() {
        if (Q1EditText.getText().toString().equals("2")) score++;
    }

    private void checkQ2() {
        if (Q2Java.isChecked()) score++;
    }

    private void checkQ3() {
        if (Q3Swift.isChecked() && Q3Objective.isChecked() && !Q3Java.isChecked() && !Q3Prolog.isChecked())
            score++;
    }

    private void checkQ4() {
        if (Q4Kotlin.isChecked()) score++;
    }

    public void submit(View view) {
        score = 0;
        checkQ1();
        checkQ2();
        checkQ3();
        checkQ4();

        if (score == 4) Toast.makeText(this, "Your score is 4 Great!", Toast.LENGTH_SHORT).show();
        else if (score == 3)
            Toast.makeText(this, "Your score is 3 Nice!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Your score is " + score + " try harder :)", Toast.LENGTH_SHORT).show();
        Intent secondScreen = new Intent(Intent.ACTION_VIEW);
        
    }
}