package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.ArrayList;
import java.util.Random;

public class RoundStart extends AppCompatActivity {

    TextView textViewCurrentPlayer;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_start);

        textViewCurrentPlayer = findViewById(R.id.textViewCurrentPlayer);
        updateCurrentPlayer();
    }

    public void goToShopPhase(View v) {
        updateCurrentPlayer();
    }

    // choose a random player and update text view that shows who the current player is
    void updateCurrentPlayer() {
        ArrayList players = Players.getPlayers();
        int randNum = random.nextInt(players.size());
        Player player = (Player) players.get(randNum);
        textViewCurrentPlayer.setText(player.getName() + "s tur!");
        Log.d("updateCurrentPlayer", "Updated current player to " + player.getName());
    }
}