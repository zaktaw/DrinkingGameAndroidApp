package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.ArrayList;
import java.util.Random;

public class PlayerSelectionPhase extends AppCompatActivity {

    TextView textViewCurrentPlayer;
    Random random = new Random();
    int currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection_phase);

        textViewCurrentPlayer = findViewById(R.id.textViewCurrentPlayer);
        updateCurrentPlayer();
    }

    public void goToShopPhase(View v) {
        Intent intent = new Intent(this, ShopPhase.class);
        intent.putExtra("currentPlayer", currentPlayer);
        startActivity(intent);
    }

    // choose a random player and update text view that shows who the current player is
    void updateCurrentPlayer() {
        Player player = Players.getRandomPlayer();
        textViewCurrentPlayer.setText(player.getName() + "s tur!");
        Log.d("updateCurrentPlayer", "Updated current player to " + player.getName());
    }
}