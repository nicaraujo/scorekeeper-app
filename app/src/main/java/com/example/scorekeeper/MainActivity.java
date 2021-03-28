package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";
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
        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);
            textView.setText(String.valueOf(score1));
            textView2.setText(String.valueOf(score2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
        super.onSaveInstanceState(outState);
    }
}