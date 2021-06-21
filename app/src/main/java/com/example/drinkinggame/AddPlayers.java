package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

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
        Log.d("players", "Updated players text view");
    }

    // add player to players array and update the text view showing all players
    public void addPlayer(View v) {
        String name = inputPlayer.getText().toString();
        Player player = new Player(name);
        Players.addPlayer(player);
        textViewplayers.setText(Players.playersToString());
        Log.d("addPlayer", "Added player " + name);
    }

    public void startGame(View v) {
        Intent intent = new Intent(this, RoundStart.class);
        startActivity(intent);
    }
}