package com.example.drinkinggame.gameActivities.staticGameActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.GamePhase;
import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class StaticGameActivity extends AppCompatActivity {

    private TextView textViewStaticGameTitle;
    private TextView textViewStaticGameDescription;
    private StaticGame game;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_game);

        textViewStaticGameTitle = findViewById(R.id.textViewStaticGameTitle);
        textViewStaticGameDescription = findViewById(R.id.textViewStaticGameDescription);
        game = StaticGames.getNextGame();

        player = Players.getRandomPlayer();
        setText();
        giveCoins();
    }

    public void setText() {
        textViewStaticGameTitle.setText(game.title);
        textViewStaticGameDescription.setText(game.description);

        // change all occurrences of [PLAYER] to an actual player name
        if (game.description.contains("[PLAYER]")) {
            String cardText = (String) textViewStaticGameDescription.getText();
            cardText = cardText.replaceAll("\\[PLAYER]", player.getName());
            textViewStaticGameDescription.setText(cardText);
        }
    }

    public void giveCoins() {
        if (game.giveCoins) {
            // give to a random player or all players
            if (game.targetPlayer) {
                player.giveCoins(game.amount);
            }
            else {
                Players.increaseCoinsAllPlayers(game.amount);
            }
        }
    }

    public void goToNextGame(View v) {
        Intent intent = GamePhase.goToNextGame(this);
        startActivity(intent);
    }
}