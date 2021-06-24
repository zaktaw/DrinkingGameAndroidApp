package com.example.drinkinggame.gameActivities.whisperChallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drinkinggame.MainActivity;
import com.example.drinkinggame.PlayerSelectionPhase;
import com.example.drinkinggame.R;
import com.example.drinkinggame.models.GameState;

public class WhisperChallenge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_whisper_challenge);
    }

    public void nextCard(View v) {
        Intent intent;

        if (GameState.isGameOver()) intent = new Intent(this, MainActivity.class);
        else intent = new Intent(this, PlayerSelectionPhase.class);

        startActivity(intent);
    }
}