package com.example.alumno.flappybanana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DeathScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_screen);
        String totalScore = getIntent().getStringExtra("score");
        final TextView score = (TextView)findViewById(R.id.score);
        score.setText("Score: " + totalScore);
    }
}
