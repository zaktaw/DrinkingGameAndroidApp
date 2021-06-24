package com.example.drinkinggame.gameActivities.whisperChallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.models.Players;

public class WhisperChallenge extends AppCompatActivity {

    private TextView textViewWhisperChallengeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_whisper_challenge);

        textViewWhisperChallengeDescription = findViewById(R.id.textViewWhisperChallengeDescription);
        setCardText();
    }

    public void showDialog(View v) {
        WhisperChallengeDialog whisperChallengeDialog = new WhisperChallengeDialog();
        whisperChallengeDialog.show(getSupportFragmentManager(), "whisper challenge dialog");
    }

    public void setCardText() {
        String cardText = (String) textViewWhisperChallengeDescription.getText();
        String player = Players.getRandomPlayer().getName();

        cardText = cardText.replaceAll("\\[PLAYER]", player);
        textViewWhisperChallengeDescription.setText(cardText);
    }
}