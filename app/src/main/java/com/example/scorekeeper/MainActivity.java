package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1;
    private int score2;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.score_1);
        textView2 = findViewById(R.id.score_2);
    }

    public void decreaseScore(View view) {
        switch (view.getId()) {
            case R.id.decreaseTeam1:
                score1--;
                textView.setText(Integer.toString(score1));
                break;
            case R.id.decreaseTeam2:
                score2--;
                textView2.setText(Integer.toString(score2));
                break;
            default:
                //Do nothing
        }
    }

    public void increaseScore(View view) {
        switch (view.getId()) {
            case R.id.increaseTeam1:
                score1++;
                textView.setText(Integer.toString(score1));
                break;
            case R.id.increaseTeam2:
                score2++;
                textView2.setText(Integer.toString(score2));
                break;
            default:
                //Do nothing
        }
    }
}