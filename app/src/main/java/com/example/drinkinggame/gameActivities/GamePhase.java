package com.example.drinkinggame.gameActivities;

import android.content.Context;
import android.content.Intent;

import com.example.drinkinggame.MainActivity;
import com.example.drinkinggame.PlayerSelectionPhase;
import com.example.drinkinggame.models.GameState;

public class GamePhase {
    public static Intent goToNextGame(Context context) {
        Intent intent;

        if (GameState.isGameOver()) intent = new Intent(context, MainActivity.class);
        else intent = new Intent(context, PlayerSelectionPhase.class);

        return intent;
    }
}
