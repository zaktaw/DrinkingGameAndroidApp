package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.ArrayList;

public class AddPlayers extends AppCompatActivity {

    TextView textViewplayers;
    TextView inputPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        textViewplayers = findViewById(R.id.textViewPlayers);
        inputPlayer = findViewById(R.id.inputPlayer);

        textViewplayers.setText(Players.playersToString());
    }

    public void addPlayer(View v) {
        String name = inputPlayer.getText().toString();
        Player player = new Player(name);
        Players.addPlayer(player);
        textViewplayers.setText(Players.playersToString());
        Log.d("addPlayer", "Added player " + name);
    }
}