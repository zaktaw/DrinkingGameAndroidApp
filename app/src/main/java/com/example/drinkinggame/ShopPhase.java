package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class ShopPhase extends AppCompatActivity {

    int currentPlayerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_phase);

        // get current player
        Intent intent = getIntent();
        currentPlayerIndex = intent.getIntExtra("currentPlayer", 0);
        Player currentPlayer = Players.getPlayers().get(currentPlayerIndex);
        Log.d("currentPlayer", "Current player is " + currentPlayer.getName() + " (coins: " + currentPlayer.getCoins() + ")");
    }
}