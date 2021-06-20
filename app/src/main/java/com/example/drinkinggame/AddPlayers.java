package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddPlayers extends AppCompatActivity {

    TextView textViewplayers;
    TextView inputPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        textViewplayers = findViewById(R.id.textViewPlayers);
        inputPlayer = findViewById(R.id.inputPlayer);
    }

    public void addPlayer(View v) {
        String player = inputPlayer.getText().toString();
        String players = textViewplayers.getText().toString() + "\n";
        players += "\n" + player;
        textViewplayers.setText(players);
    }
}