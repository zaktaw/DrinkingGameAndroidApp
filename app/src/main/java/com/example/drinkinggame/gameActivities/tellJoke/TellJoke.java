package com.example.drinkinggame.gameActivities.tellJoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.GamePhase;
import com.example.drinkinggame.gameActivities.pointingGame.PointingGameAlternatives;
import com.example.drinkinggame.gameActivities.pointingGame.PointingGameDialog;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class TellJoke extends AppCompatActivity {

    private View layoutTellJoke;
    private TextView textViewTellJokeDescription;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_joke);

        layoutTellJoke = findViewById(R.id.layoutTellJoke);
        layoutTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        textViewTellJokeDescription = findViewById(R.id.textViewTellJokeDescription);
        player = Players.getRandomPlayer();
        setText();
    }

    private void showDialog() {
        TellJokeDialog tellJokeDialog = new TellJokeDialog(player);
        tellJokeDialog.show(getSupportFragmentManager(), "tell joke dialog");
    }

    private void setText() {
        String cardText = (String) textViewTellJokeDescription.getText();
        cardText = cardText.replaceAll("\\[PLAYER]", player.getName());
        textViewTellJokeDescription.setText(cardText);
    }
}