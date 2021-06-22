package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class PlayerSelectionPhase extends AppCompatActivity {

    TextView textViewCurrentPlayer;
    String currentPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection_phase);

        textViewCurrentPlayer = findViewById(R.id.textViewCurrentPlayer);
        updateCurrentPlayer();
    }

    public void goToShopPhase(View v) {
        Intent intent = new Intent(this, ShopPhase.class);
        intent.putExtra("currentPlayer", currentPlayerName);
        startActivity(intent);
    }

    // choose a random player and update text view that shows who the current player is
    void updateCurrentPlayer() {
        Player player = Players.getRandomPlayer();
        currentPlayerName = player.getName();
        textViewCurrentPlayer.setText(currentPlayerName + "s tur!");
        Log.d("updateCurrentPlayer", "Updated current player to " + currentPlayerName);
    }
}