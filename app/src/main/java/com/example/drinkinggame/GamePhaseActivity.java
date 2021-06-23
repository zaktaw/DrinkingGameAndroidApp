package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;
import com.example.drinkinggame.models.gameCards.GameCard;
import com.example.drinkinggame.models.gameCards.GameCards;

import java.util.ArrayList;

public class GamePhaseActivity extends AppCompatActivity {

    TextView textViewGameCard;

    int pageCounter = 0;
    GameCard currentGameCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_phase);

        textViewGameCard = findViewById(R.id.textViewGameCard);

        currentGameCard = GameCards.getRandomGameCard();
        Log.d("classTest", String.valueOf(currentGameCard.getClass()));

        // replaces all occurrences of "*" in the first game card with the names of the involved players
        ArrayList<Player> involvedPlayers = Players.getRandomPlayers(currentGameCard.getPlayersInvolved());
        String gameCardFirstPage = currentGameCard.getPages().get(0);

        int playerCounter = 0;
        while (gameCardFirstPage.contains("[PLAYER]")) {
            gameCardFirstPage = gameCardFirstPage.replaceFirst("\\[PLAYER]", involvedPlayers.get(playerCounter).getName());
            playerCounter++;
        }

        textViewGameCard.setText(gameCardFirstPage);
    }

    public void nextPage(View v) {
        pageCounter++;

        // go to next game card if there aren't any more pages left in current game card
        if (pageCounter == currentGameCard.getPages().size()) {

            // end game if there aren't more rounds left
            /**
            GameState.increaseRoundsElapsed();
            Intent intent;
            if (GameState.getRoundsElapsed() == GameState.getMaximumRounds()) {
                intent = new Intent(this, MainActivity.class);
            }
            else {
                intent = new Intent(this, PlayerSelectionPhase.class);
            }
            startActivity(intent);
             **/

        }
        else {
            textViewGameCard.setText(currentGameCard.getPages().get(pageCounter));
        }
    }
}