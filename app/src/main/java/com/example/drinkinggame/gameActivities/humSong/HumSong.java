package com.example.drinkinggame.gameActivities.humSong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.tellJoke.TellJokeDialog;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class HumSong extends AppCompatActivity {

    private TextView textViewHumSongDescription;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hum_song);

        player = Players.getRandomPlayer();
        textViewHumSongDescription = findViewById(R.id.textViewHumSongDescription);
        setText();
    }

    public void showDialog(View v) {
        HumSongDialog1 humSongDialog1 = new HumSongDialog1(player);
        humSongDialog1.show(getSupportFragmentManager(), "tell joke dialog");
    }

    private void setText() {
        String cardText = (String) textViewHumSongDescription.getText();
        cardText = cardText.replaceAll("\\[PLAYER]", player.getName());
        textViewHumSongDescription.setText(cardText);
    }
}