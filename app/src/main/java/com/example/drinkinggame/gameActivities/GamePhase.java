package com.example.drinkinggame.gameActivities;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.drinkinggame.GameOverPhase;
import com.example.drinkinggame.MainActivity;
import com.example.drinkinggame.PlayerSelectionPhase;
import com.example.drinkinggame.gameActivities.categoryGame.CategoryGame;
import com.example.drinkinggame.gameActivities.pointingGame.PointingGame;
import com.example.drinkinggame.gameActivities.staticGameActivity.StaticGameActivity;
import com.example.drinkinggame.gameActivities.tellJoke.TellJoke;
import com.example.drinkinggame.gameActivities.whisperChallenge.WhisperChallenge;
import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.Random;

public class GamePhase {

    static Random random;

    public static Intent goToNextGame(Context context) {
        Intent intent;
        random = new Random();

        if (GameState.isGameOver()) intent = new Intent(context, GameOverPhase.class);
        else {
            // 1/4 chance to go to shop phase
            if (random.nextInt(1) == 0) {
                intent = new Intent(context, PlayerSelectionPhase.class);
            }
            else {
                intent = new Intent(context, chooseGame());
            }
        }

        return intent;
    }

    public static Class chooseGame() {

        String gameCard = GameState.getNextGameCard();

        // determine which game activity to go to based on which game card that was drawn
        switch (gameCard) {
            case "WhisperChallenge" :
                return WhisperChallenge.class;
            case "PointingGame" :
                return PointingGame.class;
            case "CategoryGame" :
                return CategoryGame.class;
            case "StaticGame" :
                return StaticGameActivity.class;
            case "TellJoke" :
                return TellJoke.class;
            default :
                return MainActivity.class;
        }
    }

    // replaces all occurces of [PLAYER] in a card text with an actual player name and returns the card text
    public static String insertPlayer(String cardText) {
        String playerName = Players.getRandomPlayer().getName();
        String cardTextEdited = cardText.replaceAll("\\[PLAYER]", playerName);
        return cardTextEdited;
    }
}
